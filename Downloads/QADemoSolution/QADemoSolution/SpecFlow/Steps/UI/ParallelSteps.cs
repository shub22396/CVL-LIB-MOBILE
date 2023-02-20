using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Remote;
using QADemoSolution.Helpers;
using QADemoSolution.PageObjects;
using System;
using System.Threading;
using TechTalk.SpecFlow;
[assembly: Parallelize(Scope = ExecutionScope.MethodLevel)]


namespace QADemoSolution
{
    [Binding]
    public class CommonSteps
    {
        public static IWebDriver driver { get; set; }
        private ScenarioContext _scenarioContext;

        ParkerHomePage parkerHomePage = new ParkerHomePage(driver);
        ParkerProductsPage parkerProductsPage = new ParkerProductsPage(driver);

        [BeforeScenario("UI")]
        
        public void Setup(ScenarioContext ScenarioContext)
        {
            String Tname = ScenarioContext.Current.ScenarioInfo.Title;




            Console.WriteLine("ScenarioContext----->" + Tname);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.SetCapability("browserName", "Chrome");
            capabilities.SetCapability("version", "104.0");
            capabilities.SetCapability("username", "shubhamr");
            capabilities.SetCapability("accessKey", "CCCCTfelp95y0WKq0MSKORBzWD7xpFGOTv5KlMTZ18qnAcGjId");
            capabilities.SetCapability("visual", true);
            capabilities.SetCapability("video", true);
            capabilities.SetCapability("platform", "Windows 10");
            capabilities.SetCapability("resolution", "1920x1080");
            capabilities.SetCapability("network", true);
            capabilities.SetCapability("build", "LambdaTest Demo - Parker");
            capabilities.SetCapability("project", "Parker.com");
            capabilities.SetCapability("name", Tname);
            //capabilities.SetCapability("tags", ["Demo 1"]);
            capabilities.SetCapability("console", "true");
            capabilities.SetCapability("w3c", true);
            //capabilities.SetCapability("plugin", "c#-nunit");

            driver = new RemoteWebDriver(new Uri("https://shubhamr:CCCCTfelp95y0WKq0MSKORBzWD7xpFGOTv5KlMTZ18qnAcGjId@hub.lambdatest.com/wd/hub"), capabilities);
            Console.WriteLine("Driver----->" + driver);
            //driver.Manage().Window.Maximize();
        }

        [AfterScenario("UI")]
        public void Cleanup(ScenarioContext ScenarioContext)
        {
            var result = _scenarioContext.ScenarioExecutionStatus;
            try
            {
                // Logs the result to Lambdatest
                ((IJavaScriptExecutor)driver).ExecuteScript("lambda-status=" + (result.Equals(ScenarioExecutionStatus.OK) ? "passed" : "failed"));
            }
            finally
            {
                // Terminates the remote webdriver session
                driver.Quit();
            }
        }


        [Given(@"I go to the parker homepage")]
        public void GivenIGoToTheParkerHomepage()
        {
            // driver.Navigate().GoToUrl(ConfigHelper.GetUrl());
            driver.Navigate().GoToUrl("http://lambdatest.com");
        }

        [When(@"I click the products link")]
        public void WhenIClickTheProductsLink()
        {
            CommonHelper.ClickableElement(driver, parkerHomePage.productsLink);
        }

        [Then(@"I should see the products page load")]
        public void ThenIShouldSeeTheProductsPageLoad()
        {
            Assert.IsTrue(CommonHelper.VerifyElementDisplayed(driver, parkerProductsPage.productsTitle));
        }

        [When(@"I click the help and support link")]
        public void WhenIClickTheHelpAndSupportLink()
        {
            CommonHelper.ClickableElement(driver, parkerHomePage.helpAndSupportLink);
        }

        [Then(@"I should see the help and support page load")]
        public void ThenIShouldSeeTheHelpAndSupportPageLoad()
        {
            Assert.IsTrue(CommonHelper.VerifyElementDisplayed(driver, parkerProductsPage.helpAndSupportTitle));
        }



    }
}
