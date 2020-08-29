package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartSummaryPage extends BasePage {

	private By proceedToCheckoutButton = By.cssSelector(".standard-checkout");
	private By cartItem = By.cssSelector(".cart_item");
	private By itemPrice = By.cssSelector(".cart_unit .price .price");
	private By totalProducts = By.cssSelector(".cart_total_price >td:nth-child(3)");
	private By iconTrash = By.cssSelector(".cart_quantity_delete");

	@Override
	public ShoppingCartSummaryPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton));
	}

	public List<String> getCartItemsUnitPrice() {
		return driver.findElements(cartItem).stream()
				.map(result -> result.findElement(itemPrice).getText())
				.collect(Collectors.toList());
	}

	public String getTotalProducts() {
		return driver.findElement(totalProducts).getText();
	}

	public ShoppingCartSummaryPage deleteItemFromCart() {
		driver.findElement(iconTrash).click();
		return this;
	}

	public ShoppingCartSummaryPage deleteAllItemsFromCart() {
		driver.findElements(cartItem)
				.forEach(result -> result.findElement(iconTrash).click());
		driver.navigate().refresh();
		ScreenshotUtils.captureScreenshot();
		return this;
	}
}
