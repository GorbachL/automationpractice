package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

	private By accountUserNameTile = By.cssSelector(".account");
	private By signOutButton = By.cssSelector(".logout");
	private By myWishListTile = By.cssSelector(".lnk_wishlist");
	private By productWomenTile = By.cssSelector(".sf-menu>li:nth-child(1)");

	@Override
	public MyAccountPage openPage() {
		isPageOpened();
		return this;
	}

	@Override
	public void isPageOpened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountUserNameTile));
	}

	public String accountUserName() {
		return driver.findElement(accountUserNameTile).getText();
	}

	public MyWishListPage openMyWishList() {
		driver.findElement(myWishListTile).click();
		return new MyWishListPage();
	}

	public ProductWomenPage openProductWomenPage() {
		driver.findElement(productWomenTile).click();
		return new ProductWomenPage();
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


