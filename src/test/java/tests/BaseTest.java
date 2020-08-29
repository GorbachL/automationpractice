package tests;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import utils.MyTestWatcher;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

@ExtendWith(MyTestWatcher.class)
public class BaseTest {

	private static DriverManager driverManager;
	protected WebDriver driver;
	static PropertyManager prop;

	@BeforeEach
	public void setUp() {
		driverManager = DriverFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeAll
	static void loadProperties() {
		prop = new PropertyManager();
	}

	@AfterAll
	static void afterTest() {
		driverManager.quiteDriver();
	}
}
