package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class APSelector {

	public void write(WebDriver driver, String label, String option) {

		String selectorLocator = "//div[@class='account_creation']//label[text()='%s']/..";
		By selectByLocator = By.xpath(String.format(selectorLocator, label));
		driver.findElement(selectByLocator).click();

		String optionLocator = "//div[@class='account_creation']//label[text()='%s']/..//option[text()='%s']";
		By optionByLocator = By.xpath(String.format(optionLocator, label, option));
		driver.findElement(optionByLocator).click();
	}
}
