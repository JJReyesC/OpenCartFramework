package pages;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import framework.core.BaseFramework;
import framework.enums.ByType;
import utils.ObjectFileReader;
import utils.TestData;

public class LoginPage {
	ObjectFileReader ofrHome, ofrRegister;
	Properties homeObj, registerObj;
	WebDriver driver;
	BaseFramework bf;
	String message;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void TryLogIn () {
		
		try {
			ofrHome = new ObjectFileReader("home");
			ofrRegister = new ObjectFileReader("login");
			homeObj = ofrHome.getProperties();
			registerObj = ofrRegister.getProperties();
			this.driver.get(homeObj.getProperty("cart.framework.URL"));
			bf = new BaseFramework(driver,20);
			
			bf.getElementBy(homeObj.getProperty("cart.framework.account.myaccount"), ByType.XPATH).click();
			bf.getElementBy(registerObj.getProperty("cart.framework.login.login"), ByType.XPATH).click();
			bf.getElementBy(registerObj.getProperty("cart.framework.login.email"), ByType.XPATH).sendKeys(TestData.LOGIN_EMAIL);
			bf.getElementBy(registerObj.getProperty("cart.framework.login.password"), ByType.XPATH).sendKeys(TestData.LOGIN_PASSWORD);
			bf.getElementBy(registerObj.getProperty("cart.framework.login.tryLogin"), ByType.XPATH).click();	
			
			
			//mensaje de registro correcto
			message = bf.waitForElementVisibitlityAndGetText(
					bf
					.getElementBy(registerObj.getProperty("cart.framework.login.MyAccount"), ByType.XPATH)
					);
			
			//bf.getElementBy(properties.getProperty("cart.framework.register.continue"), ByType.XPATH).click();
		} catch (Exception e) {
			message = "";
		}

}

public String getMessage() {
	return message;
}
	
}
