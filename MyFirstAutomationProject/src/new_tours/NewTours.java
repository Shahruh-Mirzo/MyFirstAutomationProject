package new_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Shahruh-Mirzo
 *
 */
public class NewTours {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shahruh-Mirzo\\Downloads\\WebDrivers\\chromedriver_win32(76)\\chromedriver.exe");
		ChromeDriver chrome = new ChromeDriver(); 
		chrome.get("http://newtours.demoaut.com/");
		chrome.findElement(By.name("userName")).sendKeys("Shohruh Mirzo");
		chrome.findElement(By.name("password")).sendKeys("12345");
		chrome.findElement(By.name("login")).click();
		// By.name("userName") --> locator
		
		Thread.sleep(5000);
		
		
		chrome.quit();

	}

}
