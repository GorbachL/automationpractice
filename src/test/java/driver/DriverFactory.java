package driver;

public class DriverFactory {

	public static DriverManager getManager(DriverType driverType) {

		DriverManager driverManager;

		switch (driverType) {
			case CHROME:
				driverManager = new ChromeDriverManager();
				break;
			case FIREFOX:
				driverManager = new FirefoxDriverManager();
				break;
			case GRID:
				driverManager = new GridChromeDriverManager();
				break;
			default:
				driverManager = null;
				break;
		}
		return driverManager;
	}
}
