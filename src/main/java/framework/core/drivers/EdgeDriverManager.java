package framework.core.drivers;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager extends DriverManager {
	@Override
	protected void createWebDriver() {
		WebDriverManager.edgedriver().setup();
		this.driver = new EdgeDriver();
		this.driver.manage().window().maximize();
	}

}
