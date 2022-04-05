package framework.core;

import framework.core.drivers.ChromeDriverManager;
import framework.core.drivers.DriverManager;
import framework.core.drivers.EdgeDriverManager;
import framework.core.drivers.FirefoxDriverManager;
import framework.enums.DriverType;

public class DriverManagerFactory {

	public static DriverManager getDriverManager(DriverType type) {
		DriverManager manager;
		switch (type) {
		case CHROME:
			manager = new ChromeDriverManager();
			break;

		case FIREFOX:
			manager = new FirefoxDriverManager();
			break;
		case EDGE:
			manager = new EdgeDriverManager();
			break;

		default:
			manager = new ChromeDriverManager();
			break;
		}
		return manager;
	}

}
