package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JavascriptUtilities;
import utils.ScreenshotUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyWishListPage extends BasePage {

	private By myWishListsTitle = By.cssSelector(".page-heading");
	private By myWishListInTheTable = By.xpath("//tr[contains(@id,'wishlist')]");
	private By accountUserNameTile = By.cssSelector(".account");
	private By productWomenTile = By.cssSelector(".sf-menu>li:nth-child(1)");
	private By viewItemInWishListTable = By.xpath("//td[@class='wishlist_delete']//preceding::td/a");
	private By wishListNameInTheTable = By.xpath("//td[@class='bold align_center']//preceding::td/a");
	private By itemDetail = By.cssSelector(".product_image>a");
	private By itemName = By.cssSelector("[itemprop='name']");
	private By deleteWishListButton = By.cssSelector(".wishlist_delete>a");
	private By saveWishListButton = By.cssSelector(".submit .btn");
	private By wishListNameInput = By.cssSelector(".inputTxt.form-control");
	private By signOutButton = By.cssSelector(".logout");

	@Override
	public MyWishListPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(myWishListsTitle));
	}

	public MyWishListPage verifyWishListAddedToAccount() {
		assertTrue(driver.findElement(myWishListInTheTable).isDisplayed());
		return this;
	}

	public MyWishListPage deleteMyWishListFromAccount() {
		driver.findElement(saveWishListButton).click();
		driver.findElement(deleteWishListButton).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().refresh();
		ScreenshotUtils.captureScreenshot();
		return this;
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
		driver.findElement(viewItemInWishListTable).click();
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public MyWishListPage getItemDetails() {
		new JavascriptUtilities().scrollToElement(driver, driver.findElement(itemDetail));
		driver.findElement(itemDetail).click();
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public String getNameOfItem() {
		return driver.findElement(itemName).getText();
	}

	public MyWishListPage addCustomWishList(String name) {
		driver.findElement(wishListNameInput).click();
		driver.findElement(wishListNameInput).sendKeys(name);
		driver.findElement(saveWishListButton).click();
		driver.navigate().refresh();
		ScreenshotUtils.captureScreenshot();
		return this;
	}

	public String getMyWishListName() {
		return driver.findElement(wishListNameInTheTable).getText();
	}

	public LoginPage signOut() {
		driver.findElement(signOutButton).click();
		return new LoginPage();
	}
}


