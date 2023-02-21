package ta.test;

import ta.model.User;
import ta.page.CartPage;
import ta.page.LoginPage;
import ta.page.HomePage;
import ta.page.OrderItemPage;
import ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class OrderItemTests extends CommonConditions {
  private int selectedItemNumber = 1;

  @Test(description = "JIRA-7566")
  public void selectedItemPriceTest() throws InterruptedException {
    CartPage cartPage = new CartPage(driver);
    OrderItemPage orderItemPage = new OrderItemPage(driver);
    User testUser = UserCreator.withCredentialsFromProperty();
    new HomePage(driver).clickSignInButton();
    String orderedItemPrice = new LoginPage(driver)
            .openPage()
            .login(testUser)
            .orderItem("parfume")
            .selectItemFromList(selectedItemNumber)
            .getItemPrice(selectedItemNumber);
    orderItemPage.addItemToCart(selectedItemNumber);
    orderItemPage.clickCart();
    assertThat(orderedItemPrice, is(equalTo(cartPage.getCartItemPrice())));
    cartPage.deleteCartItem();
  }
}
