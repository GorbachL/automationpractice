package utils;

import driver.DriverFactory;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static driver.DriverType.CHROME;

@Log4j2
public class MyTestWatcher implements TestWatcher {

	@Override
	public void testSuccessful(ExtensionContext context) {
		log.info(String.format("==== SUCCESSFUL TEST %s ====", context.getDisplayName()));
		makeScreenshot();
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		log.info(String.format("==== FAILED TEST %s ====", context.getDisplayName()));
		log.info(cause.getMessage());
		makeScreenshot();
	}

	@Attachment(value = "Last screen state from MyTestWatcher", type = "image/png")
	private static byte[] makeScreenshot() {
		WebDriver driver = DriverFactory.getManager(CHROME).getDriver();
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
