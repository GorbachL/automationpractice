package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtilities {

	public void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickJs(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
}
