package test_leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.Driver;

/**
 * 
 * @author Shahruh-Mirzo
 *
 */
public class HyperLink {

	public static void main(String[] args) {

		WebDriver driver = Driver.getDriver("chrome");
		driver.get("http://testleaf.herokuapp.com/");
		driver.findElement(By.linkText("HyperLink")).click();
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();
		String hrefValue = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println(hrefValue);
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String verifyText = driver.findElement(By.tagName("h1")).getText();
		if(verifyText.equals("Not Found")) {
			System.out.println("Broken is VERIFIED");
		} else {
			System.out.println("Broken is NOT VERIFIED");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		driver.navigate().back();
		
		
	}

}
