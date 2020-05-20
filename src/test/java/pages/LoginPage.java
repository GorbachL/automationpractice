package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private By emailInput = By.id("email");
	private By passwordInput = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");

	@Override
	public LoginPage openPage() {
		driver.get(URL);
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
		} catch (TimeoutException ex) {
			throw new TimeoutException("Login Page is not opened");
		}
	}

	public MyAccountPage loginAlreadyRegisteredUser(String email, String password) {
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(signInButton).click();
		return new MyAccountPage();
	}
}
