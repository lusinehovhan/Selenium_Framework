package ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

  private static WebDriver driver;


  private DriverSingleton() {
  }

  public static WebDriver getDriver(String browser) {
    if (null == driver) {
      switch (browser) {
//        case "firefox": {
//          WebDriverManager.firefoxdriver().setup();
//          driver = new FirefoxDriver();
//        }
        case "chrome": {
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
        }
//        case "edge": {
//          WebDriverManager.edgedriver().setup();
//          driver = new EdgeDriver();
//        }
      }
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
