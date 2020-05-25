package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyWishListPage;
import pages.WomenPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("AP-4 Verify the ability to add to your Wishlist")
class CustomWishListTest extends BaseTest {

	@Description("Selected Item must be added to custom WishList")
	@Step("Create custom WishList and add Item")
	@Test
	void createCustomWishListTest() {
		LoginPage loginPage = new LoginPage();
		loginPage
				.openPage()
				.loginAlreadyRegisteredUser(prop.get("username"), prop.get("password"));

		MyAccountPage myAccountPage = new MyAccountPage();
		MyWishListPage myWishListPage = new MyWishListPage();
		WomenPage womenPage = new WomenPage();

		myAccountPage
				.openMyWishList()
				.addCustomWishList(prop.get("name"));
		String myWishListName = myWishListPage.getMyWishListName();

		myWishListPage
				.openWomenPage();
		womenPage
				.addItemToWishList()
				.closePopupThatItemAddedToWishList()
				.openAddedToWishListItem();
		String actualItemName = womenPage.getItemName();

		womenPage
				.backToAccountPage();
		myAccountPage
				.openMyWishList()
				.verifyWishListAddedToAccount();

		myWishListPage
				.clickViewToSeeAddedItemInWishList()
				.getItemDetails();
		String expectedItemName = myWishListPage.getNameOfItem();

		assertEquals(prop.get("name"), myWishListName);
		assertEquals(expectedItemName, actualItemName);
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
