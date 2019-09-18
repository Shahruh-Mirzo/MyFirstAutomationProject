package new_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driver.Driver;
// import static driver.Driver.*; or import static driver.Driver.getDriver;

/**
 * 
 * @author Shahruh-Mirzo
 *
 */
public class Cruises {

	public static void main(String[] args) {
		
		WebDriver chrome = Driver.getDriver("chrome");   // ChromeDriver chrome = getDriver();
		chrome.get("http://newtours.demoaut.com/");
		//chrome.navigate().to("http://newtours.demoaut.com/");
		sleep(2);
		
		chrome.findElement(By.xpath("(//a)[5]")).click();
		//chrome.findElement(By.linkText("Cruises")).click();
		sleep(3);
		
		String actualURL = chrome.getCurrentUrl();
		String expectedURL = "http://newtours.demoaut.com/mercurycruise.php";
		
		String actualTitle = chrome.getTitle();
		String expectedTitle = "Cruises: Mercury Tours";
		
		if (actualURL.contains(expectedURL)) {
			System.out.println("URL check: pass");
		} else {
			System.out.println("URL check: fail! Actual URL is: " + actualURL);
		}
		
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title check: pass");
		} else {
			System.out.println("Title check: fail! Actual Title is: " + actualTitle);
		}
		
		sleep(5);
		chrome.quit();
		
		
	}
	
	public static void sleep(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
