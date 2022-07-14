package com.resumelibrary.cucumber;

import com.resumelibrary.utilities.*;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.apache.commons.collections.map.HashedMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomFormatter extends Utility implements ConcurrentEventListener {
    String failedTestCases = "";
    List<String> scenarioList = new ArrayList<String>();
    Map<String,Integer> scenarioRetryMap=new HashedMap();
    List<ScenarioStepResults> scenarioStepResultList = null;
    Map<String, List> scenarioStepResultsMap = new HashMap<String, List>();
    String GREEN_BACKGROUND = "\033[42m";
    String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    String RED_BOLD_BRIGHT = "\033[1;91m";
    String ANSI_RESET = "\u001B[0m";
    String GREEN_BOLD_BRIGHT = "\033[1;92m";
    String WHITE_BOLD_BRIGHT = "\033[1;97m";
    List<String> tagNames;
    Map<String, Object> threadMapObj;
    PropertyFileReader propertyFileReader;
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomFormatter.class);

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        LOGGER.info("[--->in setEventPublisher<---]");
        publisher.registerHandlerFor(TestCaseStarted.class, this::scenarioStartedHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, this::scenarioFinishedHandler);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStartedHandler);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinishedHandler);
    }

    private void scenarioStartedHandler(TestCaseStarted event) {
        propertyFileReader = new PropertyFileReader();
        LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
        LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "     scenario started   :  " + event.getTestCase().getName() +ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
        LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
        if (!event.getTestCase().getTags().contains("@skip_hooks")) {
            try {
                tagNames = propertyFileReader.getTagNamesFromProperties();
                threadMapObj = new HashMap<>();
                threadMapObj.put("runnerClass", System.getProperty("runnerClass"));
                threadMapObj.put("skipTest", isSkipTest(event.getTestCase().getTags().toString(), tagNames));
                getDriver(System.getProperty("browserName"), System.getProperty("machineName"), threadMapObj, event.getTestCase().getName());
                LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "driver created successfully for:" + event.getTestCase().getName() + ANSI_RESET+ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
                scenarioStepResultList = new ArrayList<ScenarioStepResults>();
                scenarioStepResultsMap.put(event.getTestCase().getName(), scenarioStepResultList);
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.info(RED_BOLD_BRIGHT+"[--->"+BLACK_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + "Unable to create driver for:" + event.getTestCase().getName() + ",with error message: " + e.getMessage() +ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
            }
        } else {
            scenarioStepResultList = new ArrayList<ScenarioStepResults>();
            scenarioStepResultsMap.put(event.getTestCase().getName(), scenarioStepResultList);
        }
    }

    private void scenarioFinishedHandler(TestCaseFinished event) {
        LOGGER.info("[--->in scenarioFinishedHandler<---]");
         scenarioStepResultList = scenarioStepResultsMap.get(event.getTestCase().getName());
        String resultText = "";
        Result result = event.getResult();
        if (result.getStatus().equals(Status.FAILED)) {
                 if(scenarioRetryMap.get(event.getTestCase().getName())==null ){
                    scenarioRetryMap.put(event.getTestCase().getName(),0);
                }
                if (((Integer)scenarioRetryMap.get(event.getTestCase().getName()) == Integer.parseInt(PropertyFileReader.getInstance().getProperty("retryCount")))) {
                   resultText = BLACK_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT + "FAILED" + ANSI_RESET;
                    ExcelUtil excelUtil = new ExcelUtil();
                    FailedScenarioPojo failedScenarioPojo = new FailedScenarioPojo();
                    failedScenarioPojo.setScenarioName(event.getTestCase().getName());
                    failedScenarioPojo.setTagDetails(event.getTestCase().getTags().toString());
                    for (int i = 0; i < scenarioStepResultList.size(); i++) {
                        if (scenarioStepResultList.get(i).getScenarioName().equalsIgnoreCase(event.getTestCase().getName())) {
                            if (scenarioStepResultList.get(i).getStepResult().contains("FAILED")) {
                                failedScenarioPojo.setStepDescription(scenarioStepResultList.get(i).getStepDescription());
                                failedScenarioPojo.setFailedReason(scenarioStepResultList.get(i).getFailedReason());
                                excelUtil.addRowsFailedExcel(failedScenarioPojo, isSkipTest());
                            }
                        }
                    }
                    LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
                    LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "     scenario " + resultText + "   :  " + GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + event.getTestCase().getName() +ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
                    LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
                    for (int i = 0; i < scenarioStepResultList.size(); i++) {
                        if (scenarioStepResultList.get(i).getScenarioName().equalsIgnoreCase(event.getTestCase().getName())) {
                            LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "Step " + (i + 1) + ": " + scenarioStepResultList.get(i).getStepResult()+ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
                            if (scenarioStepResultList.get(i).getStepResult().contains("FAILED")) {
                                LOGGER.error(RED_BOLD_BRIGHT+"[--->"+"Failed Reason:\r\n" + scenarioStepResultList.get(i).getFailedReason() + "\r\n\n"+ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
                            }
                        }
                    }
                }else{
                    int retryCount=  ((Integer)scenarioRetryMap.get(event.getTestCase().getName()));
                    scenarioRetryMap.put(event.getTestCase().getName(),retryCount+1);
                }
      } else if (result.getStatus().equals(Status.PASSED)) {
            resultText = BLACK_BACKGROUND_BRIGHT + GREEN_BOLD_BRIGHT + "PASSED" + ANSI_RESET;
            LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
            LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "     scenario " + resultText + "   :  " + GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + event.getTestCase().getName() + ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
            LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
            String showPassedStepsInConsole = PropertyFileReader.getInstance().getProperty("showPassedStepsInConsole");
            if (showPassedStepsInConsole.equalsIgnoreCase("yes")) {
                for (int i = 0; i < scenarioStepResultList.size(); i++) {
                    if (scenarioStepResultList.get(i).getScenarioName().equalsIgnoreCase(event.getTestCase().getName())) {
                        LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "Step " + (i + 1) + ": " + scenarioStepResultList.get(i).getStepResult()+ ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
                    }
                }
            }
        }
        if (getThreadDriver() != null) {
            LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
            LOGGER.info(RED_BOLD_BRIGHT+"[--->"+GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + " browser closed for scenario : " + event.getTestCase().getName() + ANSI_RESET+RED_BOLD_BRIGHT+"<---]" + ANSI_RESET);
            getThreadDriver().quit();
            LOGGER.info("|----------------------------------------------------------------------------------------------------------------------------------|");
        }
    }

    private void stepStartedHandler(TestStepStarted event) {
        LOGGER.info("[--->in stepStartedHandler<---]");
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
        }
    }

    private void stepFinishedHandler(TestStepFinished event) {
        LOGGER.info("[--->in stepFinishedHandler<---]");
        String stepResult = "";
        String error = "";
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            Result result = event.getResult();
            if (result.getStatus().equals(Status.FAILED)) {
                error = convertStackTraceToString(result.getError());
                if (failedTestCases.contains(event.getTestCase().getName())) {
                    stepResult = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + testStep.getStep().getText() + RED_BOLD_BRIGHT + "[FAILED]" + ANSI_RESET;
                } else {
                    stepResult = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + testStep.getStep().getText() + RED_BOLD_BRIGHT + "[FAILED]" + ANSI_RESET;
                    failedTestCases += event.getTestCase().getName() + "@@";
                }
            } else if (result.getStatus().equals(Status.PASSED)) {
                stepResult = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + testStep.getStep().getText() + GREEN_BOLD_BRIGHT + "[PASSED]" + ANSI_RESET;
            } else if (result.getStatus().equals(Status.SKIPPED)) {
                stepResult = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD_BRIGHT + testStep.getStep().getText() + GREEN_BOLD_BRIGHT + "[SKIPPED]" + ANSI_RESET;
            }
            List scenarioStepResultList = scenarioStepResultsMap.get(event.getTestCase().getName());
            ScenarioStepResults scenarioStepResults = new ScenarioStepResults();
            scenarioStepResults.setScenarioName(event.getTestCase().getName());
            scenarioStepResults.setFeatureName(event.getTestCase().getTags().toString());
            scenarioStepResults.setStepDescription(testStep.getStep().getText());
            scenarioStepResults.setScenarioName(event.getTestCase().getName());
            scenarioStepResults.setFailedReason(error);
            scenarioStepResults.setStepResult(stepResult);
            scenarioStepResultList.add(scenarioStepResults);
            scenarioStepResultsMap.put(event.getTestCase().getName(), scenarioStepResultList);
        }
   }

    private static String convertStackTraceToString(Throwable throwable) {
        LOGGER.info("[--->in convertStackTraceToString<---]");
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException(ioe);
        }
    }

    public String isSkipTest(String tags, List tagNames) {
        LOGGER.info("[--->in isSkipTest<---]");
        String isSkipTest = "NO";
        for (int i = 0; i < tagNames.size(); i++) {
            if (tags.contains("@" + tagNames.get(i).toString())) {
                isSkipTest = "YES";
                break;
            }
        }
        return isSkipTest;
    }
}
