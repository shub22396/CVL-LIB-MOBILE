package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.Constants;
import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.WebURLHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CloudDriverProvider extends WebDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(CloudDriverProvider.class);


    public CloudDriverProvider() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG_PROPERTY_FILE_PATH);
    }

    void remoteLambdaTestinChrome(Map threadMap, String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("build", "RL Regression[" + jobBaseName + "-Build:" + buildId + "]");
            ltOptions.put("project", project);
            ltOptions.put("name", testName);
            ltOptions.put("console", "info");
            ltOptions.put("visual", true);
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("selenium_version", "4.1.2");
            ltOptions.put("driver_version", "100.0");
            ltOptions.put("resolution", "1920x1080");
            ltOptions.put("network", false);
            ltOptions.put("tunnel", true);
            caps.setCapability("LT:Options", ltOptions);
            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), caps));
            threadLocalMap.set(threadMap);
            caps.setCapability("tunnelName", "RLRegressionTunnel");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void remoteLambdaTestinFirefox(Map threadMap, String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            System.out.println("jenkinsBuildNumber = " + buildId);
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Firefox");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("build", "RL Regression[" + jobBaseName + "-Build:" + buildId + "]");
            ltOptions.put("project", project);
            ltOptions.put("name", testName);
            ltOptions.put("console", "info");
            ltOptions.put("visual", true);
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("selenium_version", "4.1.2");
            ltOptions.put("driver_version", "v0.31.0");
            ltOptions.put("resolution", "1920x1080");
            ltOptions.put("network", false);
            ltOptions.put("tunnel", true);
            caps.setCapability("LT:Options", ltOptions);
            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), caps));
            threadLocalMap.set(threadMap);
            caps.setCapability("tunnelName", "RLRegressionTunnel");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void remoteBrowserStackChrome(Map threadMap, String testName) {
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";

            String username = PropertyFileReader.getInstance().getProperty("browserStackUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("browserStackAccessKey");
            final String driverURL = "https://" + username + ":" + accessKey + "@hub-scale.browserstack.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("browserVersion", "100.0");

            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");

            //for Chrome + Mac
            //browserstackOptions.put("os", "OS X");
            //browserstackOptions.put("osVersion", "Big Sur");

            browserStackCommonCapblts(threadMap, project, driverURL, caps, browserstackOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void browserStackCommonCapblts(Map threadMap, String buildId, String driverURL, DesiredCapabilities caps, HashMap<String, Object> browserstackOptions) throws MalformedURLException {

        browserstackOptions.put("debug", "true");  // for enabling visual logs
        browserstackOptions.put("consoleLogs", "info");  // to enable console logs at the info level. You can also use other log levels here
        browserstackOptions.put("networkLogs", "false");  // to enable network logs to be logged
        browserstackOptions.put("video", "true");
        browserstackOptions.put("projectName", "rl-selenium-tests");
        //browserstackOptions.put("seleniumVersion", "4.1.2");
        browserstackOptions.put("autoWait", "0");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("buildName", buildId);
        caps.setCapability("bstack:options", browserstackOptions);
        threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), caps));
        threadLocalMap.set(threadMap);
    }

    void remoteBrowserStackFireFox(Map threadMap, String testName) {
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);
            logger.info("[--->jenkinsBuildNumber : " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            String username = PropertyFileReader.getInstance().getProperty("browserStackUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("browserStackAccessKey");
            final String driverURL = "https://" + username + ":" + accessKey + "@hub-scale.browserstack.com/wd/hub";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "Firefox");
            caps.setCapability("browserVersion", "100.0");
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");
            //for Firefox + Mac
            //browserstackOptions.put("os", "OS X");
            //browserstackOptions.put("osVersion", "Big Sur");
            browserStackCommonCapblts(threadMap, project, driverURL, caps, browserstackOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConstantsURL(String URL) {
        return null;
    }

    void androidMobileWeb(Map threadMap,String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId+"<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL+"<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","RL Regression[" + jobBaseName + "-Build:" + buildId + "]");
            capabilities.setCapability("name",testName);
            capabilities.setCapability("project", project);

            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Galaxy M31");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("video", true);
            capabilities.setCapability("tunnel", true);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("tunnelName", "RLRegressionTunnel");

            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), capabilities));
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void iosMobileWeb(Map threadMap,String testName) {
        try {
            String username = PropertyFileReader.getInstance().getProperty("lambdaUsername");
            String accessKey = PropertyFileReader.getInstance().getProperty("lambdaAccessKey");

            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);

            logger.info("[--->jenkinsBuildNumber = " + buildId+"<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "https://" + username + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL+"<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","RL Regression[" + jobBaseName + "-Build:" + buildId + "]");
            capabilities.setCapability("name",testName);
            capabilities.setCapability("project", project);
            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("deviceName", "iPhone 11 Pro");
            capabilities.setCapability("platformVersion", "13");
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", true);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("video", true);
            capabilities.setCapability("tunnel", true);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("tunnelName", "RLRegressionTunnel");
            threadMap.put("webdriverObj", new RemoteWebDriver(new URL(driverURL), capabilities));
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void androidMobileWeb2(Map threadMap) {
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobnameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobnameFromConfig);
            System.out.println("jenkinsBuildNumber = " + buildId);
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://127.0.0.1:4723/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.22.3");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Nexus 5 API 33");
            capabilities.setCapability("udid", "emulator-5554");
            // capabilities.setCapability("appPackage", "com.example.myapplication");
            //capabilities.setCapability("appActivity", "MainActivity");
            // capabilities.setCapability("appPackage", "com.demo.test.demo");
            //capabilities.setCapability("appActivity", ".RootActivity");
            capabilities.setCapability("noReset", "true");
            // capabilities.setCapability("browserName","WEBView Browser Tester");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            // capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
            // capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.chromium.my_webview_shell");
            //    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
            capabilities.setCapability("chromedriverExecutableDir", "/home/lpottumuthu/Downloads/Chrome-Driver");
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setJavascriptEnabled(true);
            threadMap.put("webdriverObj", new AndroidDriver(new URL(driverURL), capabilities));
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


