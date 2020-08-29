package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverType.CHROME;

public abstract class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	BasePage() {
		this.driver = DriverFactory.getManager(CHROME).getDriver();
		wait = new WebDriverWait(driver, 20);
	}

	public abstract BasePage openPage();

	public abstract void isPageOpened();
	//TODO
	// It is unlikely for java naming convention to have method starting from "is" returning void
}
