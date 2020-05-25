package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("AP-2 Verify the ability to login in account")
class LogInAsRegisteredUserTest extends BaseTest {

	@Description("User must be able to login")
	@Step("Fill in Email and Password and click the Sign In button")
	@Test
	void loginRegisteredUserTest() {
		LoginPage loginPage = new LoginPage();
		loginPage
				.openPage()
				.loginAlreadyRegisteredUser(prop.get("username"), prop.get("password"));
		MyAccountPage myAccountPage = new MyAccountPage();
		String actualResult = myAccountPage.accountUserName();
		String expectedResult = prop.get("userFullName");
		assertEquals(expectedResult, actualResult);
	}
}
