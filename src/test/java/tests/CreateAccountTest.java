package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import models.CreateAnAccountModel;
import org.junit.jupiter.api.Test;
import pages.CreateAnAccountPage;
import utils.RandomUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Verify the ability to create an account")
class CreateAccountTest extends BaseTest {

	@Description("Account must be created")
	@Step("Fill in all the required fields and click the Register button")
	@Test
	void completeRegistrationTest() {
		CreateAnAccountModel accountModel = CreateAnAccountModel.builder()
				.FirstName("Elena")
				.LastName("G")
				.Password("12345@qwerty")
				.Address("Odo, 115, 111")
				.City("Minsk")
				.State("Arizona")
				.PostalCode("10020")
				.MobilePhone("100500200")
				.AddressAlias("lenag1@mailinator.com")
				.build();

		RandomUtil randomUtil = new RandomUtil();

		CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
		createAnAccountPage
				.openPage()
				.enterEmail(prop.get("userEmail") + randomUtil.usernameAffix() + prop.get("emailAffix"))
				.clickCreateAnAccountButton()
				.clearAliasAddress()
				.fillInRequiredInputFields(accountModel)
				.selectRequiredDropdownOption(accountModel)
				.clickRegisterButton();

		String actualResult = createAnAccountPage.accountWasCreated();
		String expectedResult = accountModel.getFirstName() + " " + accountModel.getLastName();
		assertEquals(expectedResult, actualResult);
	}
}
