package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.Constants;
import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.WebURLHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CloudDriverProvider extends WebDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(CloudDriverProvider.class);

    public String tunnelName = null;
    String lambdaUsername = null;
    String lambdaAccessKey = null;
    String buildId = null;
    String jobBaseName = null;

    public CloudDriverProvider() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG_PROPERTY_FILE_PATH);
        lambdaUsername = "shubhamr";
        lambdaAccessKey = "";
        String buildIdFromConfig = WebURLHelper.getParameterFromEnvOrSysParam("user.name", "unknown_user");
        buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
        String jobNameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
        jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobNameFromConfig);
        String tunnelName2 = WebURLHelper.getParameterFromEnvOrSysParam("TUNNELNAME", PropertyFileReader.getInstance().getProperty("tunnelName"));
        tunnelName = tunnelName2 + buildId;
    }

    void androidFirefoxRealMobileWeb(Map threadMap, String testName, String deviceName) {
        try {
            String threadDeviceName = deviceName.split("@")[0];
            String threadDeviceVersion = deviceName.split("@")[1];
            System.out.println("threadTunnelName:" + threadDeviceVersion);
            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://" + lambdaUsername + ":" + lambdaAccessKey + "@localhost:9688/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            System.out.println("in androidRealMobileWeb method");
            logger.info("[--->tunnelName = " + tunnelName + "<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<Object, Object> caps = new HashMap<>();
            caps.put("build", "A");
            caps.put("project", project);
            caps.put("name", testName);
            caps.put("platformName", "Android");
            caps.put("deviceName", threadDeviceName);
            caps.put("platformVersion", threadDeviceVersion);
            caps.put("isRealMobile", true);
            caps.put("console", true);
            caps.put("visual", true);
            caps.put("devicelog", true);
            caps.put("video", true);
            caps.put("tunnel", true);
            caps.put(MobileCapabilityType.BROWSER_NAME, "Firefox");
            caps.put("autoGrantPermissions", true);
            caps.put("autoAcceptAlerts", true);
            caps.put("tunnelName","RL-Anantha");
            caps.put("network", false);
            caps.put("w3c", true);
            caps.put("eventTimings", true);
            caps.put("idleTimeout", "1800");
            capabilities.setCapability("lt:options", caps);

            threadMap.put("webdriverObj", new AndroidDriver(new URL(driverURL), capabilities));
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void androidFirefoxMobileWeb(Map threadMap, String testName) {
        try {
            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://" + lambdaUsername + ":" + lambdaAccessKey + "@localhost:9688/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            logger.info("[--->tunnelName = " + tunnelName + "<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "B");
            capabilities.setCapability("name", testName);
            capabilities.setCapability("project", project);
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("deviceName", "Google Pixel");
            capabilities.setCapability("platformVersion", "8");
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("tunnel", true);
            capabilities.setCapability("tunnelName","RL-Anantha");
            capabilities.setCapability("acceptInsecureCerts", true);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Firefox");
            capabilities.setCapability("idleTimeout", "1800");

            ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).readTimeout(Duration.ofMinutes(20));
            WebDriver testDriver = RemoteWebDriver.builder().oneOf(capabilities).address(driverURL).config(config).build();
            threadMap.put("webdriverObj", testDriver);
            threadLocalMap.set(threadMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConstantsURL(String URL) {
        return null;
    }

    void androidChromeRealMobileWeb(Map threadMap, String testName, String deviceName) {
        try {
            String threadDeviceName = deviceName.split("@")[0];
            String threadDeviceVersion = deviceName.split("@")[1];
            System.out.println("threadTunnelName:" + threadDeviceVersion);
            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://" + lambdaUsername + ":" + lambdaAccessKey + "@mobile-hub.lambdatest.com/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            System.out.println("in androidRealMobileWeb method");
            logger.info("[--->tunnelName = " + tunnelName + "<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<Object, Object> caps = new HashMap<>();
            caps.put("build", "C2");
            caps.put("project", project);
            caps.put("name", testName);
            caps.put("platformName", "Android");
            caps.put("deviceName", threadDeviceName);
            caps.put("platformVersion", threadDeviceVersion);
            caps.put("isRealMobile", true);
            caps.put("console", true);
            caps.put("visual", true);
            caps.put("devicelog", true);
            caps.put("video", true);
            caps.put("tunnel", true);
            caps.put(MobileCapabilityType.BROWSER_NAME, "Chrome");
            caps.put("autoGrantPermissions", true);
            caps.put("autoAcceptAlerts", true);
            caps.put("tunnelName", "RL-Shubham");
            caps.put("network", false);
            caps.put("w3c", true);
            //   caps.put("newCommandTimeout", 180);
            caps.put("eventTimings", true);
            caps.put("idleTimeout", "1800");
            capabilities.setCapability("lt:options", caps);

            threadMap.put("webdriverObj", new AndroidDriver(new URL(driverURL), capabilities));
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void androidChromeMobileWeb(Map threadMap, String testName) {
        try {
            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://" + lambdaUsername + ":" + lambdaAccessKey + "@localhost:9688/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            logger.info("[--->tunnelName = " + tunnelName + "<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "D");
            capabilities.setCapability("name", testName);
            capabilities.setCapability("project", project);
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("deviceName", "Google Pixel");
            capabilities.setCapability("platformVersion", "8");
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("tunnel", true);
            capabilities.setCapability("tunnelName", "RL-Anantha");
            capabilities.setCapability("acceptInsecureCerts", true);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            capabilities.setCapability("idleTimeout", "1800");

            ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).readTimeout(Duration.ofMinutes(20));
            WebDriver testDriver = RemoteWebDriver.builder().oneOf(capabilities).address(driverURL).config(config).build();
            threadMap.put("webdriverObj", testDriver);
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void iOSSafariRealMobileWeb(Map threadMap, String testName) {
        try {

            logger.info("[--->jenkinsBuildNumber = " + buildId + "<---]");
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://" + lambdaUsername + ":" + lambdaAccessKey + "@localhost:9688/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            logger.info("[--->tunnelName = " + tunnelName + "<---]");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "E");
            capabilities.setCapability("name", testName);
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
            capabilities.setCapability("tunnelName", "RL-Anantha");
            capabilities.setCapability("idleTimeout", "1800");

            ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).readTimeout(Duration.ofMinutes(20));
            WebDriver testDriver = RemoteWebDriver.builder().oneOf(capabilities).address(driverURL).config(config).build();
            threadMap.put("webdriverObj", testDriver);
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void localMobileWeb(Map threadMap) {
        try {
            String buildIdFromConfig = WebURLHelper.getParameterFromEnvOrSysParam("user.name", "unknown_user");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            String jobNameFromConfig = PropertyFileReader.getInstance().getProperty("jobName");
            String jobBaseName = WebURLHelper.getParameterFromEnvOrSysParam("JOB_BASE_NAME", jobNameFromConfig);
            System.out.println("jenkinsBuildNumber = " + buildId);
            String project = "[" + jobBaseName + "-Build:" + buildId + "]";
            final String driverURL = "http://127.0.0.1:4723/wd/hub";
            logger.info("[--->driverURL:" + driverURL + "<---]");
            logger.info("[--->tunnelName = " + tunnelName + "<---]");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.22.3");
            capabilities.setCapability("platformName", "Android");
            //capabilities.setCapability("deviceName", "Pixel 3 API 30");
            capabilities.setCapability("udid", "17a52c7b7d83");
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
            capabilities.setCapability("chromedriverExecutableDir", "/home/sguduru/Downloads/Chrome-Driver");
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setJavascriptEnabled(true);
           /* threadMap.put("webdriverObj", new AndroidDriver(new URL(driverURL), capabilities));
            threadLocalMap.set(threadMap);*/
            ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).readTimeout(Duration.ofMinutes(20));
            WebDriver testDriver = RemoteWebDriver.builder().oneOf(capabilities).address(driverURL).config(config).build();
            threadMap.put("webdriverObj", testDriver);
            threadLocalMap.set(threadMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getThreadDevice() {
        return (((Map) threadLocalMap.get()).get("ThreadDevice")).toString();
    }
}