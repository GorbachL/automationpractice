package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected static WebDriver driver;
	//TODO
	// One-thread solution, you will be not able to run tests in multiple threads

	abstract void createDriver();

	public void quiteDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		if (null == driver) {
			createDriver();
		}
		return driver;
	}
}
