package elements;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class APInput {

	public void write(WebDriver driver, String label, String text) {
		System.out.println(String.format("Writing text %s into input with label %s", text, label));
		if (null != text) {
			try {
				String inputLocator = "//div[@class='account_creation']//label[text()='%s']/..//input";
				By inputByLocator = By.xpath(String.format(inputLocator, label));
				driver.findElement(inputByLocator).sendKeys(text);
			} catch (Exception e) {
				Assertions.fail(String.format("Cannot write text %s into input with label %s", text, label));
			}
		}
	}
}
