package framework.core.drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected WebDriver driver;

	protected abstract void createWebDriver();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getWebDriver() {
		if (null == driver)
			createWebDriver();
		return driver;
	}
}
