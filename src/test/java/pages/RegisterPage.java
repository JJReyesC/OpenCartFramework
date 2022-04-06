package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import framework.core.BaseFramework;
import framework.enums.ByType;
import utils.ObjectFileReader;
import utils.TestData;

//al final manda a la pantalla = https://opencart.abstracta.us/index.php?route=account/account
//Se muestra texto de "Congratulations"
public class RegisterPage {
	
	ObjectFileReader ofrHome, ofrRegister;
	Properties homeObj, registerObj;
	WebDriver driver;
	BaseFramework bf;
	
	String message;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void TryRegister () {
		
			try {
				ofrHome = new ObjectFileReader("home");
				ofrRegister = new ObjectFileReader("register");
				homeObj = ofrHome.getProperties();
				registerObj = ofrRegister.getProperties();
				this.driver.get(homeObj.getProperty("cart.framework.URL"));
				bf = new BaseFramework(driver);
				
				bf.getElementBy(homeObj.getProperty("cart.framework.account.myaccount"), ByType.XPATH).click();
				bf.getElementBy(registerObj.getProperty("cart.framework.register.register"), ByType.XPATH).click();
				bf.getElementBy(registerObj.getProperty("cart.framework.register.firstname"), ByType.XPATH).sendKeys(TestData.FAKE_NAME);
				bf.getElementBy(registerObj.getProperty("cart.framework.register.lastname"), ByType.XPATH).sendKeys("Fernandez gaucin");
				bf.getElementBy(registerObj.getProperty("cart.framework.register.email"), ByType.XPATH).sendKeys("juanpe1010@correo.com");				
				bf.getElementBy(registerObj.getProperty("cart.framework.register.telephone"), ByType.XPATH).sendKeys("8711454545");				
				bf.getElementBy(registerObj.getProperty("cart.framework.register.password"), ByType.XPATH).sendKeys("1234567890");				
				bf.getElementBy(registerObj.getProperty("cart.framework.register.confirm"), ByType.XPATH).sendKeys("1234567890");				
				bf.getElementBy(registerObj.getProperty("cart.framework.register.newsletter.yes"), ByType.XPATH).click();	
				bf.getElementBy(registerObj.getProperty("cart.framework.register.checkbox_privacy"), ByType.XPATH).click();				
				bf.getElementBy(registerObj.getProperty("cart.framework.register.submit_continue"), ByType.XPATH).click();
				
				//Thread.sleep(5000);
				
				//mensaje de registro correcto
				message = bf
						.getElementBy(registerObj.getProperty("cart.framework.register.congratulations"), ByType.XPATH)
						.getText();
				
				//bf.getElementBy(properties.getProperty("cart.framework.register.continue"), ByType.XPATH).click();
			} catch (Exception e) {
				message = "";
			}

	}

	public String getMessage() {
		return message;
	}
	
	
	
	
}
