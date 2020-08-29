package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAccountPage extends BasePage {

	private By accountUserNameTile = By.cssSelector(".account");
	private By pageName = By.cssSelector(".page-heading");
	private By signOutButton = By.cssSelector(".logout");
	private By myWishListTile = By.cssSelector(".lnk_wishlist");
	private By womenTab = By.cssSelector(".sf-menu>li:nth-child(1)");

	@Override
	public MyAccountPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountUserNameTile));
		String openPage = driver.findElement(pageName).getText();
		String expectedResult = "MY ACCOUNT";
		assertEquals(expectedResult, openPage);
	}
	//TODO
	// It is bad idea to have assertion in page object

	public String accountUserName() {
		return driver.findElement(accountUserNameTile).getText();
	}

	public MyWishListPage openMyWishList() {
		driver.findElement(myWishListTile).click();
		return new MyWishListPage();
	}

	public WomenPage openWomenPage() {
		driver.findElement(womenTab).click();
		return new WomenPage();
	}

	public MyAccountPage backToAccountPage() {
		driver.findElement(accountUserNameTile).click();
		return new MyAccountPage();
	}

	public LoginPage signOut() {
		driver.findElement(signOutButton).click();
		return new LoginPage();
	}
}


