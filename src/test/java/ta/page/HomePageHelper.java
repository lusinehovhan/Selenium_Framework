package ta.page;

import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HomePage{

  public HomePageHelper(WebDriver driver) {
    super(driver);
  }

  public void printWarningMessage() {
    System.out.println("Spending too much time on online shopping is waste of time!");
  }
}
