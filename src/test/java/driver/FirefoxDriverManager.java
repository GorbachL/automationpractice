package driver;

import org.openqa.selenium.firefox.FirefoxDriver;

class FirefoxDriverManager extends DriverManager {

	@Override
	void createDriver() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}
}
