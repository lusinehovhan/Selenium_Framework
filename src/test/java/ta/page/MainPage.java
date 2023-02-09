package ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
  private final String BASE_URL = "https://www.amazon.com";

  @FindBy(xpath = "//div[@id='nav-signin-tooltip']//span")
  private WebElement buttonSignIn;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement inputItemName;

  @FindBy(id = "nav-search-submit-button")
  private WebElement buttonSearch;

  @FindBy(xpath = "//summary[contains(@aria-label, 'Create new')]")
  private WebElement buttonCreateNew;

  private final By linkLoggedInUserLocator = By.id("nav-link-accountList-nav-line-1");

  public MainPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public OrderItemPage orderItem(String itemName) {
    inputItemName.sendKeys(itemName);
    buttonSearch.click();
    return new OrderItemPage(driver);
  }

  @Override
  public MainPage openPage() {
    driver.navigate().to(BASE_URL);
    return this;
  }

  public String getLoggedInUserName() {
    WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
    return linkLoggedInUser.getText();
  }

  public LoginPage clickSignInButton() {
    driver.navigate().to(BASE_URL);
    buttonSignIn.click();
    return new LoginPage(driver);
  }
}
