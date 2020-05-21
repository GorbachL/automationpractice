package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JavascriptUtilities;

public class ProductWomenPage extends BasePage {

	private By navigationPage = By.cssSelector(".navigation_page");
	private By firstItemFromPresentedProduct = By.cssSelector(".product_list >li:nth-child(1)");
	private By addToWishList = By.cssSelector(".addToWishlist ");
	private By closePopupAfterAddedItemToWishList = By.cssSelector("a.fancybox-item.fancybox-close");
	private By backToHomePage = By.cssSelector(".home");
	private By accountUserNameTile = By.cssSelector(".account");
	private By itemName = By.cssSelector("[itemprop='name']");

	@Override
	public ProductWomenPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(navigationPage));
	}

	public ProductWomenPage addItemToWishList() {
		new JavascriptUtilities().scrollToElement(driver, driver.findElement(firstItemFromPresentedProduct));
		driver.findElement(firstItemFromPresentedProduct).click();
		driver.findElement(addToWishList).click();
		return this;
	}

	public ProductWomenPage closePopupThatItemAddedToWishList() {
		driver.findElement(closePopupAfterAddedItemToWishList).click();
		return this;
	}

	public ProductWomenPage openAddedToWishListItem() {
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
}
