package ta.driver;

import org.openqa.selenium.WebDriver;

public class CloseDriver {
  private static WebDriver driver;

  public CloseDriver(WebDriver driver) {
    CloseDriver.driver = driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
