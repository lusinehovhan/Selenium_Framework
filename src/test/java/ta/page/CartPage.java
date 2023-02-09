package ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {
  private final String BASE_URL = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";

  @FindBy(xpath = "//div[@id='sw-subtotal']//span[contains(@class,'a-offscreen')]")
  private WebElement itemPrice;

  @FindBy(xpath = "//div[@data-name='Subtotals']//span//span")
  private WebElement getItemPriceWhole;

  @FindBy(xpath = "//span[@class='a-price-fraction']")
  private WebElement getItemPriceFraction;

  @FindBy(xpath = "//input[@data-action='delete']")
  private WebElement buttonDelete;

  public CartPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public String getCartItemPrice() {
    String price = getItemPriceWhole.getText();
    return price;
  }

  public void deleteCartItem() {
    buttonDelete.click();
  }

  @Override
  protected AbstractPage openPage() {
    driver.navigate().to(BASE_URL);
    return this;
  }
}
