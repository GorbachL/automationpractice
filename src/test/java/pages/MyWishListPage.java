package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JavascriptUtilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyWishListPage extends BasePage {

	private By myWishListsPage = By.id("#mywishlist");
	private By myWishListAdded = By.xpath("//tr[contains(@id,'wishlist')]");
	private By accountUserNameTile = By.cssSelector(".account");
	private By productWomenTile = By.cssSelector(".sf-menu>li:nth-child(1)");
	private By viewItemInWishList = By.xpath("//td[@class='wishlist_delete']//preceding::td/a");
	private By itemDetail = By.cssSelector(".product_image>a");
	private By itemName = By.cssSelector("[itemprop='name']");
	private By deleteWishList = By.cssSelector(".wishlist_delete>a");
	private By saveNewWishList = By.cssSelector(".submit");

	@Override
	public MyWishListPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(myWishListsPage));
	}

	public MyWishListPage verifyWishListAddedToAccount() {
		assertTrue(driver.findElement(myWishListAdded).isDisplayed());
		return this;
	}

	public MyWishListPage deleteMyWishListFromAccount() {
		new JavascriptUtilities().scrollToElement(driver, driver.findElement(saveNewWishList));
		driver.findElement(deleteWishList).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}

	public void verifyWishListExist() {
	}

	public MyAccountPage backToAccountPage() {
		driver.findElement(accountUserNameTile).click();
		return new MyAccountPage();
	}

	public ProductWomenPage openProductWomenPage() {
		driver.findElement(productWomenTile).click();
		return new ProductWomenPage();
	}

	public MyWishListPage clickViewToSeeAddedItemInWishList() {
		new JavascriptUtilities().clickJs(driver, driver.findElement(viewItemInWishList));
		return this;
	}

	public MyWishListPage getItemDetails() {
		new JavascriptUtilities().scrollToElement(driver, driver.findElement(itemDetail));
		driver.findElement(itemDetail).click();
		return this;
	}

	public String getNameOfItem() {
		return driver.findElement(itemName).getText();
	}
}


