package com.resumelibrary.utilities;

public class ScenarioStepResults {

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    private String scenarioName;
    private String featureName;
    private String failedReason;

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    private String stepDescription;

    public String getStepResult() {
        return stepResult;
    }

    public void setStepResult(String stepResult) {
        this.stepResult = stepResult;
    }

    private String stepResult;



}
