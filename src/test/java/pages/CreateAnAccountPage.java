package pages;

import elements.APInput;
import elements.APSelector;
import models.CreateAnAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtils;

public class CreateAnAccountPage extends BasePage {

	private String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private By createAnAccountEmailInput = By.id("email_create");
	private By createAnAccountButton = By.id("SubmitCreate");
	private By registerButton = By.id("submitAccount");
	private By accountUserName = By.cssSelector(".header_user_info .account");
	private By aliasAddress = By.id("alias");

	@Override
	public CreateAnAccountPage openPage() {
		driver.get(URL);
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(createAnAccountButton));
		} catch (TimeoutException ex) {
			throw new TimeoutException("AUTHENTICATION Page is not opened");
		}
	}

	public CreateAnAccountPage enterEmail(String email) {
		driver.findElement(createAnAccountEmailInput).sendKeys(email);
		return this;
	}

	public CreateAnAccountPage clickCreateAnAccountButton() {
		driver.findElement(createAnAccountButton).click();
		return this;
	}

	public CreateAnAccountPage fillInRequiredInputFields(CreateAnAccountModel accountModel) {
		new APInput().write(driver, "First name ", accountModel.getFirstName());
		new APInput().write(driver, "Last name ", accountModel.getLastName());
		new APInput().write(driver, "Password ", accountModel.getPassword());
		new APInput().write(driver, "Address ", accountModel.getAddress());
		new APInput().write(driver, "City ", accountModel.getCity());
		new APInput().write(driver, "Zip/Postal Code ", accountModel.getPostalCode());
		new APInput().write(driver, "Mobile phone ", accountModel.getMobilePhone());
		new APInput().write(driver, "Assign an address alias for future reference. ", accountModel.getAddressAlias());
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public CreateAnAccountPage selectRequiredDropdownOption(CreateAnAccountModel accountModel) {
		new APSelector().write(driver, "State ", accountModel.getState());
		return this;
	}

	public CreateAnAccountPage clearAliasAddress() {
		driver.findElement(aliasAddress).clear();
		return this;
	}

	public MyAccountPage clickRegisterButton() {
		driver.findElement(registerButton).click();
		return new MyAccountPage();
	}

	public String accountWasCreated() {
		return driver.findElement(accountUserName).getText();
	}
}
