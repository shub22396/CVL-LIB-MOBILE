package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.Constants;
import com.resumelibrary.utilities.WebURLHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(WebDriverProvider.class);
    public static ThreadLocal<Map<String, Object>> threadLocalMap = new ThreadLocal<>();

    public String getConstantsURL(String URL) {
        return null;
    }
}