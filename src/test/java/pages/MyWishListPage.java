package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.JavascriptUtilities;
import utils.ScreenshotUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyWishListPage extends BasePage {

	private By myWishListInTheTable = By.xpath("//tr[contains(@id,'wishlist')]");
	private By accountUserNameTile = By.cssSelector(".account");
	private By productWomenTab = By.cssSelector(".sf-menu>li:nth-child(1)");
	private By viewItemInWishListTable = By.xpath("//td[@class='wishlist_delete']//preceding::td/a");
	private By wishListNameInTheTable = By.xpath("//td[@class='bold align_center']//preceding::td/a");
	private By itemDetail = By.cssSelector(".product_image>a");
	private By itemName = By.cssSelector("[itemprop='name']");
	private By deleteWishListButton = By.cssSelector(".wishlist_delete>a");
	private By saveWishListButton = By.cssSelector(".submit .btn");
	private By wishListNameInput = By.cssSelector(".inputTxt.form-control");

	@Override
	public MyWishListPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveWishListButton));
	}

	public MyWishListPage verifyWishListAddedToAccount() {
		assertTrue(driver.findElement(myWishListInTheTable).isDisplayed());
		return this;
	}

	public MyWishListPage deleteMyWishListFromAccount() {
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

	public WomenPage openWomenPage() {
		driver.findElement(productWomenTab).click();
		return new WomenPage();
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
}


