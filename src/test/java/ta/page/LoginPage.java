package ta.page;

import ta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String PAGE_URL = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";

	@FindBy(id = "ap_email")
	private WebElement inputLogin;

	@FindBy(id = "continue")
	private WebElement buttonContinue;

	@FindBy(id = "ap_password")
	private WebElement inputPassword;

	@FindBy(id = "signInSubmit")
	private WebElement buttonSignIn;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
		return this;
	}

	public MainPage login(User user)
	{
		inputLogin.sendKeys(user.getUseremail());
		buttonContinue.click();
		inputPassword.sendKeys(user.getPassword());
		buttonSignIn.click();
		logger.info("Login performed");
		return new MainPage(driver);
	}
}
