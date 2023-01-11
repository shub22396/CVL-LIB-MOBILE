package com.resumelibrary.webdriverprovider;

import com.resumelibrary.utilities.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;

public class WebDriverProvider implements Constants {

    private static final Logger logger = LogManager.getLogger(WebDriverProvider.class);
    public static ThreadLocal<Map<String, Object>> threadLocalMap = new ThreadLocal<>();

    public String getConstantsURL(String URL) {
        return null;
    }
}