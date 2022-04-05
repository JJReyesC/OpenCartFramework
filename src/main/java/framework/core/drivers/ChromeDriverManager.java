package framework.core.drivers;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
	}

}
