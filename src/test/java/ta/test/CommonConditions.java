package ta.test;

import ta.driver.CloseDriver;
import ta.driver.DriverFactory;
import ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static ta.service.UserCreator.TESTDATA_BROWSER;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverFactory.getDriver(TESTDATA_BROWSER);
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        CloseDriver.closeDriver();
    }
}
