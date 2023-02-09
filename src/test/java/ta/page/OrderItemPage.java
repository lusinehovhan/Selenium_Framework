package ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderItemPage extends AbstractPage {
  private final String BASE_URL = "https://www.amazon.com/s?k=parfume&crid=36C2MG07D9FG6&sprefix=parfume%2Caps%2C802&ref=nb_sb_noss_2";
  private final Logger logger = LogManager.getRootLogger();

  @FindBy(id = "nav-cart-text-container")
  private WebElement buttonCart;

  private final By itemInCardLoc = By.xpath("//div[contains(@class,'a-row')]//span[contains(text(),'in cart')]");

  private WebElement selectedItemName(int index) {
    String searchItemLoc = String.format("//div[@data-component-type='s-search-result'][%s]//h2", index);
    return driver.findElement(By.xpath(searchItemLoc));
  }

  private WebElement selectedItemPriceWhole(int index) {
    String selectedItemPriceW = String.format("//div[@data-component-type='s-search-result'][%s]//span[@class='a-price-whole']", index);
    return driver.findElement(By.xpath(selectedItemPriceW));
  }

  private WebElement selectedItemPriceFraction(int index) {
    String selectedItemPriceF = String.format("//div[@data-component-type='s-search-result'][%s]//span[@class='a-price-fraction']", index);
    return driver.findElement(By.xpath(selectedItemPriceF));
  }

  private WebElement buttonAddToCart(int index) {
    String buttonAddCart = String.format("//div[@data-component-type='s-search-result'][%s]//button[@class='a-button-text']", index);
    return driver.findElement(By.xpath(buttonAddCart));
  }

  public OrderItemPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public OrderItemPage selectItemFromList(int itemNumber) {
    selectedItemName(itemNumber).getText();
    logger.info("Selected Item name: " + "\n" + selectedItemName(itemNumber).getText());
    return this;
  }

  public String getItemPrice(int itemNumber) {
    String price = "$" + selectedItemPriceWhole(itemNumber).getText() + "." + selectedItemPriceFraction(itemNumber).getText();
    logger.info("Selected Item price: " + price);
    return price;
  }

  public void clickCart() {
    buttonCart.click();
  }

  public void addItemToCart(int itemNumber) throws InterruptedException {
    Actions actions = new Actions(driver);
    actions.moveToElement(buttonAddToCart(itemNumber)).perform();
    buttonAddToCart(itemNumber).click();
    Thread.sleep(5000);
  }

  @Override
  public OrderItemPage openPage() {
    driver.navigate().to(BASE_URL);
    return this;
  }
}
