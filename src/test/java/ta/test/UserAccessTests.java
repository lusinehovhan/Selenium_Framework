package ta.test;

import ta.model.User;
import ta.page.LoginPage;
import ta.page.HomePage;
import ta.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserAccessTests extends CommonConditions {
  @Test(groups ={"smoke"} )
  public void oneCanLoginAmazon() {
    User testUser = UserCreator.withCredentialsFromProperty();
    new HomePage(driver).clickSignInButton();
    String loggedInUserName = new LoginPage(driver)
            .openPage()
            .login(testUser)
            .getLoggedInUserName();
    assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
  }
}
