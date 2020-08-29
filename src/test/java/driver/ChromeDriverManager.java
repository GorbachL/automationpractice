package driver;

import org.openqa.selenium.chrome.ChromeDriver;

class ChromeDriverManager extends DriverManager {

	@Override
	void createDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
}
