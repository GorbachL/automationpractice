package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JavascriptUtilities;
import utils.ScreenshotUtils;

public class WomenPage extends BasePage {

	private By navigationWomenPage = By.cssSelector(".navigation_page");
	private By firstItemFromPresentedProduct = By.cssSelector(".product_list >li:nth-child(1)");
	private By secondItemFromPresentedProduct = By.cssSelector(".product_list >li:nth-child(2)");
	private By thirdItemFromPresentedProduct = By.cssSelector(".product_list >li:nth-child(3)");
	private By addToWishList = By.cssSelector(".addToWishlist ");
	private By closePopupAfterAddingItemToWishList = By.cssSelector("a.fancybox-item.fancybox-close");
	private By accountUserNameTile = By.cssSelector(".account");
	private By itemName = By.cssSelector("[itemprop='name']");
	private By itemOnWomenPage = By.cssSelector(".product_list >li");
	private By addToCartButton = By.cssSelector(".ajax_add_to_cart_button");
	private By closePopupAfterAddingItemToShoppingCart = By.cssSelector(".cross");
	private By viewMyShoppingCart = By.cssSelector("[title='View my shopping cart']");
	private By productPriceAddedToCart = By.cssSelector("[id=layer_cart_product_price]");
	private By totalProductsPrice = By.cssSelector(".ajax_block_products_total");

	@Override
	public WomenPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(navigationWomenPage));
	}

	public WomenPage addItemToWishList() {
		new JavascriptUtilities().scrollToElement(driver, driver.findElement(firstItemFromPresentedProduct));
		driver.findElement(firstItemFromPresentedProduct).click();
		driver.findElement(addToWishList).click();
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public WomenPage closePopupThatItemAddedToWishList() {
		driver.findElement(closePopupAfterAddingItemToWishList).click();
		return this;
	}

	public WomenPage openAddedToWishListItem() {
		driver.findElement(firstItemFromPresentedProduct).click();
		return this;
	}

	public String getItemName() {
		return driver.findElement(itemName).getText();
	}

	public MyAccountPage backToAccountPage() {
		new JavascriptUtilities().scrollToElement(driver, driver.findElement(accountUserNameTile));
		driver.findElement(accountUserNameTile).click();
		return new MyAccountPage();
	}

	public WomenPage addFirstItemToCart() {
		driver.findElement(firstItemFromPresentedProduct).click();
		driver.findElements(addToCartButton).get(0).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPriceAddedToCart));
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public WomenPage addSecondItemToCart() {
		driver.findElement(secondItemFromPresentedProduct).click();
		driver.findElements(addToCartButton).get(1).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPriceAddedToCart));
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public WomenPage addThirdItemToCart() {
		driver.findElement(thirdItemFromPresentedProduct).click();
		driver.findElements(addToCartButton).get(2).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPriceAddedToCart));
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public WomenPage closePopupThatItemAddedToShoppingChart() {
		driver.findElement(closePopupAfterAddingItemToShoppingCart).click();
		return this;
	}

	public String getPrice() {
		return driver.findElement(productPriceAddedToCart).getText();
	}

	public String getTotalProductsPrice() {
		return driver.findElement(totalProductsPrice).getText();
	}

	public ShoppingCartSummaryPage openCart() {
		driver.findElement(viewMyShoppingCart).click();
		return new ShoppingCartSummaryPage();
	}
}
