package framework.core.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
	}

}
