package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.Constants;
import com.resumelibrary.utilities.PropertyFileReader;
import com.resumelibrary.utilities.WebURLHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Map;

public class DriverController extends CloudDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(DriverController.class);

    public DriverController() {
        PageFactory.initElements(getThreadDriver(), this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG_PROPERTY_FILE_PATH);
    }

    public void getDriver(String browserName, String machineName, ThreadLocal<Map<String,Object>> threadMap, String testName, String deviceName) {

        String isRealDevice = PropertyFileReader.getInstance().getProperty("isRealDevice");
        String isRealDeviceVal = WebURLHelper.getParameterFromEnvOrSysParam("ISREALDEVICE", isRealDevice);

        switch (browserName) {
            case "lambdaAndroidChromeMobileWeb":
                logger.info("[--->Using  lambdaMobileWeb<---]");
                if (isRealDeviceVal.equalsIgnoreCase("yes")) {
                    logger.info("[--->isRealDeviceVal:" + isRealDeviceVal + "<---]");
                    androidChromeRealMobileWeb(threadMap, testName, deviceName);
                } else {
                    logger.info("[--->isRealDeviceVal:" + isRealDeviceVal + "<---]");
                    androidChromeMobileWeb(threadMap.get(), testName);
                }
                break;
            case "lambdaAndroidFirefoxMobileWeb":
                logger.info("[--->Using  lambdaMobileWeb<---]");
                if (isRealDeviceVal.equalsIgnoreCase("yes")) {
                    logger.info("[--->isRealDeviceVal:" + isRealDeviceVal + "<---]");
                    androidFirefoxRealMobileWeb(threadMap.get(), testName, deviceName);
                } else {
                    logger.info("[--->isRealDeviceVal:" + isRealDeviceVal + "<---]");
                    androidFirefoxMobileWeb(threadMap.get(), testName);
                }
                break;
            case "lambdaSafariMobileWeb":
                logger.info("[--->Using  lambdaMobileWeb<---]");
                iOSSafariRealMobileWeb(threadMap.get(), testName);
                break;
            case "localMobileWeb":
                logger.info("[--->Using  localMobileWeb<---]");
                localMobileWeb(threadMap.get());
                break;
        }
        manageBrowser();
    }

    private void manageBrowser() {
        //getThreadDriver().manage().window().setSize(new Dimension(414,736));
        // getThreadDriver().manage().window().maximize();
        getThreadDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getThreadDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getInstance().getProperty("implicitlyWait"))));
        getThreadDriver().manage().deleteAllCookies();
    }

    public WebDriver getThreadDriver() {
        WebDriver webdriverObj = null;
        try {
            webdriverObj = (AndroidDriver) ((Map) threadLocalMap.get()).get("webdriverObj");
            // webdriverObj = (RemoteWebDriver) ((Map) threadLocalMap.get()).get("webdriverObj");
        } catch (Exception e) {

        }
        return webdriverObj;
    }

    public WebDriver getAppiumdDriver() {
        WebDriver webdriverObj = null;
        try {
            webdriverObj = (AppiumDriver) ((Map) threadLocalMap.get()).get("webdriverObj");
        } catch (Exception e) {

        }
        return webdriverObj;
    }

    public String getRunnerName() {
        return (((Map) threadLocalMap.get()).get("runnerClass")).toString();
    }

    public String isSkipTest() {
        return ((Map) threadLocalMap.get()).get("skipTest").toString();
    }

    public String getRandomEmail() {
        return ((Map) threadLocalMap.get()).get("randomEmail").toString();
    }

    public void setRandomEmail(String email) {
        ((Map) threadLocalMap.get()).put("randomEmail", email);
    }

    public String getConstantsURL(String URL) {
        return null;
    }
}