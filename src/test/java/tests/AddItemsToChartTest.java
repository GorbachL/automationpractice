package tests;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import models.ItemPrice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ShoppingCartSummaryPage;
import pages.WomenPage;
import utils.JsonParser;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Feature("AP-5 Verify the ability to add to cart")
class AddItemsToChartTest extends BaseTest {

	@Description("All 3 products are in the cart and total is correct")
	@Step("Add 3 different products to cart")
	@Test
	void addItemToCartTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage
				.openPage()
				//TODO
				// Strange formatting, you do not need to move first method in new line, it is ok do it starting from the second one
				.loginAlreadyRegisteredUser(prop.get("username"), prop.get("password"));
		//TODO
		// This method return MyAccountPage instance, why are you not using returned value? The same comment for all other calls

		MyAccountPage myAccountPage = new MyAccountPage();
		WomenPage womenPage = new WomenPage();
		ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();

		myAccountPage
				.openWomenPage();

		womenPage
				.addFirstItemToCart();
		String firstPrice = womenPage.getPrice();
		String firstTotalPrice = womenPage.getTotalProductsPrice();
		womenPage
				.closePopupThatItemAddedToShoppingChart();
		womenPage
				.addSecondItemToCart();
		Thread.sleep(2000);
		//TODO
		// Forget about Thread.sleep for forever, use explicit waiters. Explicit waiter is the only correct code when you need to wait for some event
		String secondPrice = womenPage.getPrice();
		String secondTotalPrice = womenPage.getTotalProductsPrice();
		womenPage
				.closePopupThatItemAddedToShoppingChart();
		womenPage
				.addThirdItemToCart();
		Thread.sleep(2000);
		String thirdPrice = womenPage.getPrice();
		String thirdTotalPrice = womenPage.getTotalProductsPrice();
		womenPage
				.closePopupThatItemAddedToShoppingChart();

		Gson gson = new Gson();
		ItemPrice itemPrice1 = new ItemPrice(firstPrice, firstTotalPrice);
		ItemPrice itemPrice2 = new ItemPrice(secondPrice, secondTotalPrice);
		ItemPrice itemPrice3 = new ItemPrice(thirdPrice, thirdTotalPrice);
		JsonParser parser = new JsonParser();
		parser.writeToFile(itemPrice1, itemPrice2, itemPrice3);

		womenPage
				.openCart();

		List<String> result = shoppingCartSummaryPage.getCartItemsUnitPrice();
		String file = "src/test/resources/Price.json";
		ItemPrice[] totalPriceFromFile = parser.readFromFile(new File(file));
		String totalPriceResult = gson.toJson(totalPriceFromFile);

		assertAll("Total Price must match",
				() -> assertTrue(totalPriceResult.contains(shoppingCartSummaryPage.getTotalProducts()), "Total products must match total price")
		);

		assertAll("The prices from the list result must match the prices from the .json file",
				() -> assertEquals(firstPrice, result.get(0), "the first price from the file must match the first price from the list"),
				() -> assertEquals(secondPrice, result.get(1), "the second price from the file must match the second price from the list"),
				() -> assertEquals(thirdPrice, result.get(2), "the third price from the file must match the third price from the list")
		);
	}

	@AfterEach
	void clearData() {
		ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
		shoppingCartSummaryPage
				.deleteAllItemsFromCart();
	}
}
