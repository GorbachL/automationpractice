package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

class GridChromeDriverManager extends DriverManager {

	@Override
	void createDriver() {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
