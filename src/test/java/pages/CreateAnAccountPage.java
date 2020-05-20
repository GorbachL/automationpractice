package pages;

import elements.APInput;
import elements.APSelector;
import models.CreateAnAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAnAccountPage extends BasePage {

	private String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private By createAnAccountEmailInput = By.id("email_create");
	private By createAnAccountButton = By.id("SubmitCreate");
	private By registerButton = By.id("submitAccount");
	private By accountUserName = By.cssSelector(".header_user_info .account");

	@Override
	public BasePage openPage() {
		driver.get(URL);
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(createAnAccountButton));
		} catch (TimeoutException ex) {
			throw new TimeoutException("CREATE AN ACCOUNT Page is not opened");
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

	public void fillInRequiredInputFields(CreateAnAccountModel accountModel) {
		new APInput().write(driver, "First name ", accountModel.getFirstName());
		new APInput().write(driver, "Last name ", accountModel.getLastName());
		new APInput().write(driver, "Password ", accountModel.getPassword());
		new APInput().write(driver, "Address ", accountModel.getAddress());
		new APInput().write(driver, "City ", accountModel.getCity());
		new APInput().write(driver, "Zip/Postal Code ", accountModel.getPostalCode());
		new APInput().write(driver, "Mobile phone ", accountModel.getMobilePhone());
		new APInput().write(driver, "Assign an address alias for future reference. ", accountModel.getAddressAlias());
	}

	public void selectRequiredDropdownOption(CreateAnAccountModel accountModel) {
		new APSelector().write(driver, "State ", accountModel.getState());
	}

	public void clickRegisterButton() {
		driver.findElement(registerButton).click();
	}

	public String accountWasCreated() {
		return driver.findElement(accountUserName).getText();
	}
}
