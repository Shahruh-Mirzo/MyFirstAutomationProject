package driver;
/**
 * 
 * @author Shahruh-Mirzo
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	public static WebDriver getDriver(String browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			break;
		default: System.out.println("Browser type " + browserType + " is invalid");
			break;
		}
		return driver;
	}
	
	
	
	private static ChromeDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Shahruh-Mirzo\\Downloads\\TechCenture Academy\\WebDrivers\\chromedriver_win32(76)\\chromedriver.exe");
		return new ChromeDriver();
	}

	private static FirefoxDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\Shahruh-Mirzo\\Downloads\\TechCenture Academy\\WebDrivers\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		return new FirefoxDriver();
	}
}
