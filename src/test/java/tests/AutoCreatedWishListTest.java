package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;
import pages.LoginPage;
import pages.MyWishListPage;
import pages.WomenPage;

import static org.junit.jupiter.api.Assertions.*;

@Feature("AP-3 Verify the ability to add to auto-created WishList")
class AutoCreatedWishListTest extends BaseTest {

	@Description("WishList must be created automatically")
	@Step("Go to any product detail page and click Add to Wishlist button")
	@Test
	void createWishListTest() {
		LoginPage loginPage = new LoginPage();
		loginPage
				.openPage()
				.loginAlreadyRegisteredUser(prop.get("username"), prop.get("password"));

		MyAccountPage myAccountPage = new MyAccountPage();
		MyWishListPage myWishListPage = new MyWishListPage();
		WomenPage womenPage = new WomenPage();

		myAccountPage
				.openMyWishList()
				.openWomenPage();
		womenPage
				.addItemToWishList()
				.closePopupThatItemAddedToWishList()
				.openAddedToWishListItem();
		String actualResult = womenPage.getItemName();
		womenPage
				.backToAccountPage();
		myAccountPage
				.openMyWishList()
				.verifyWishListAddedToAccount()
				.clickViewToSeeAddedItemInWishList()
				.getItemDetails();
		String expectedResult = myWishListPage.getNameOfItem();
		assertEquals(expectedResult, actualResult);
	}

	@AfterEach
	void clearData() {
		MyAccountPage myAccountPage = new MyAccountPage();
		myAccountPage
				.backToAccountPage()
				.openMyWishList()
				.deleteMyWishListFromAccount();
	}
}
