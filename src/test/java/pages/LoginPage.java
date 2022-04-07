package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import framework.core.BaseFramework;
import framework.enums.ByType;
import utils.ObjectFileReader;
import utils.TestData;

public class LoginPage {
	ObjectFileReader ofrHome, ofrLogin;
	Properties homeObj, loginObj;
	WebDriver driver;
	BaseFramework bf;
	String message;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ofrHome = new ObjectFileReader("home");
		ofrLogin = new ObjectFileReader("login");
		homeObj = ofrHome.getProperties();
		loginObj = ofrLogin.getProperties();
	}

	public void TryLogIn() {

		try {
			this.driver.get(homeObj.getProperty("cart.framework.URL"));
			bf = new BaseFramework(driver, 20);

			bf.getElementBy(homeObj.getProperty("cart.framework.account.myaccount"), ByType.XPATH).click();
			bf.getElementBy(loginObj.getProperty("cart.framework.login.login"), ByType.XPATH).click();
			bf.getElementBy(loginObj.getProperty("cart.framework.login.email"), ByType.XPATH)
					.sendKeys(TestData.LOGIN_EMAIL);
			bf.getElementBy(loginObj.getProperty("cart.framework.login.password"), ByType.XPATH)
					.sendKeys(TestData.LOGIN_PASSWORD);
			bf.getElementBy(loginObj.getProperty("cart.framework.login.tryLogin"), ByType.XPATH).click();

			// mensaje de registro correcto
			message = bf.waitForElementVisibitlityAndGetText(
					bf.getElementBy(loginObj.getProperty("cart.framework.login.MyAccount"), ByType.XPATH));

			// bf.getElementBy(properties.getProperty("cart.framework.register.continue"),
			// ByType.XPATH).click();
		} catch (Exception e) {
			message = "";
		}

	}

	public String getMessage() {
		return message;
	}

}
