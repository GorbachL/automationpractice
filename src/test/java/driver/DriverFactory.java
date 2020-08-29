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
				//TODO
				// And if I need to run using firefox browser on grid?)
				break;
			default:
				driverManager = null;
				//TODO
				// It makes sense to create some implementation in default block or to throw exception, but do not return null - you will have NPE
				break;
		}
		return driverManager;
	}
}
