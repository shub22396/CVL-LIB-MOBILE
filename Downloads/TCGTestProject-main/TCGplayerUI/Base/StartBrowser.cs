﻿using AventStack.ExtentReports;
using Framework.Config;
using Framework.Helpers;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Interactions;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Safari;
using System;
using System.Collections.Generic;
using System.Net;
using System.Threading;
using System.Threading.Tasks;
using TCGplayerUI





//[assembly:Parallelizable(ParallelScope.Fixtures)]

namespace Framework.Base
{
    [TestFixture("chrome", "100", "Windows 10")]
   // [TestFixture("internet explorer", "11", "Windows 10")]
    // [TestFixture("firefox", "60", "Windows 7")]
    //[TestFixture("chrome", "95", "Windows 11")]
    //[TestFixture("internet explorer", "11", "Windows 10")]
    //[TestFixture("firefox", "58", "Windows 7")]
    //[TestFixture("chrome", "67", "Windows 7")]
    //[TestFixture("internet explorer", "10", "Windows 7")]
    //[TestFixture("firefox", "55", "Windows 7")]

    [Parallelizable(ParallelScope.Children)]


    public class StartBrowser
    {

       
        

        public static ThreadLocal<IWebDriver> driver = new ThreadLocal<IWebDriver>();

        public String browserName;
        public String Version;
        public String platform;


       

        

        //log = new LoginTest();

        //public StartBrowser(String browser, String version, String os)
        //{


        //    this.browser = browser;
        //    this.version = version;
        //    this.os = os;

        //    Console.Out.Write("" + os + "" + browser);
        //}


        

        



        protected static readonly object ConfigReader;
        // public static IWebDriver driver;
        public static ExtentTest parentTest;
        public static ExtentTest childTest;
       // public string browser { get; set; }
       // public string version { get; set; }
        //public string os { get; set; }

        public static string LT_USERNAME = Environment.GetEnvironmentVariable("LT_USERNAME") == null ? "shubhamr" : Environment.GetEnvironmentVariable("LT_USERNAME");
        public static string LT_ACCESS_KEY = Environment.GetEnvironmentVariable("LT_ACCESS_KEY") == null ? "CCCCTfelp95y0WKq0MSKORBzWD7xpFGOTv5KlMTZ18qnAcGjId" : Environment.GetEnvironmentVariable("LT_ACCESS_KEY");
        public static bool tunnel = Boolean.Parse(Environment.GetEnvironmentVariable("LT_TUNNEL") == null ? "false" : Environment.GetEnvironmentVariable("LT_TUNNEL"));
        public static string build = Environment.GetEnvironmentVariable("LT_BUILD") == null ? "Test" : Environment.GetEnvironmentVariable("LT_BUILD");
        public static string seleniumUri = "https://hub.lambdatest.com:443/wd/hub";
        public static string sessionId;


       public StartBrowser() { }
        public StartBrowser(AventStack.ExtentReports.ExtentReports tempExtent)
        {
            extent = tempExtent;
        }
      

        AventStack.ExtentReports.ExtentReports extent;
        public void Setup(AventStack.ExtentReports.ExtentReports tempExtent, string url)
        {
            extent = tempExtent;
            ConfigReaders.LoadConfig();
            OpenBrowser();
            Console.WriteLine("Starting Tests");
            var file = JsonHelpers.GetJsonDataEnv("Urls.json");
            string testCaseUrl = file[url];
            StartBrowser.driver.Value.Url = testCaseUrl;
        }
        //public StartBrowser(String browser, String version, String os)
        //{
        //    this.browser = browser;
        //    this.version = version;
        //    this.os = os;
        //}
        public void OpenBrowser()
        {
            //String username = "qadirya.dolqun";
            //String accesskey = "uXFBx46K4otwRNSs5l4OZu7QGWoVVtArrdiuhutdAM0YXcqhsb";
            //String gridURL = "https://hub.lambdatest.com:443/wd/hub";


            //this.browser = browser;
            //this.os = os;
            //this.version


            


            Dictionary<string, object> ltOptions = new Dictionary<string, object>();
            ltOptions.Add("build", "Qadirya");
            ltOptions.Add("name", "Qadirya test");
            ltOptions.Add("browserName",browserName);
            ltOptions.Add("browserVersion", Version);
            ltOptions.Add("platformName", platform);
            ltOptions.Add("user", LT_USERNAME);
            ltOptions.Add("accessKey", LT_ACCESS_KEY);
            ltOptions.Add("visual", true);

            RemoteSessionSettings options = new RemoteSessionSettings();
            options.AddMetadataSetting("LT:Options", ltOptions);
            Console.WriteLine(options);
            driver.Value = new RemoteWebDriver(new Uri(seleniumUri), options);
            Console.Out.WriteLine(driver);
        }

        [SetUp]
        public void BeforeTest()
        {
            extent = new AventStack.ExtentReports.ExtentReports();
               parentTest = extent.CreateTest(TestContext.CurrentContext.Test.Name);
            Console.Out.Write(extent + "  ----00---  " + parentTest);

        }
        [OneTimeTearDown]
        public void ExtentClose()
        {
            StartBrowser.driver.Value.Close();
            StartBrowser.driver.Value.Quit();
        }
       
    }
}












