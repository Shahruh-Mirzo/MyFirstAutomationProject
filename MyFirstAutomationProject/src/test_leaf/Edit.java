package test_leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import new_tours.Cruises;

import driver.Driver;

/**
 * 
 * @author Shahruh-Mirzo
 *
 */
public class Edit {

	public static void main(String[] args) {

		WebDriver chrome = Driver.getDriver("firefox");
		
		chrome.navigate().to("http://testleaf.herokuapp.com/");
		Cruises.sleep(2);
		
		chrome.findElement(By.linkText("Edit")).click();
		// chrome.findElement(By.xpath("//h5")).click(); always try other locators than Xpath first, because they are faster
		
		String header = chrome.findElement(By.tagName("h1")).getText();
		
		if (header.equals("Work with Edit Fields")) {
			System.out.println("Header validation : pass");
		} else {
			System.out.println("Header validation : fail");
		}
		
		chrome.findElement(By.id("email")).sendKeys("snurmirzayev@gmail.com");
		Cruises.sleep(2);
		chrome.findElement(By.cssSelector("[value='Append ']")).sendKeys(" appending text");
		Cruises.sleep(2);
		String value = chrome.findElement(By.name("username")).getAttribute("value");
		Cruises.sleep(2);
		/*
		 * To get text out of text box, you should use getAttribute("value") method
		 */
		System.out.println(value);
		chrome.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		Cruises.sleep(2);
		boolean isDisabled = !chrome.findElement(By.cssSelector("[disabled='true']")).isEnabled();
		System.out.println(isDisabled);
		Cruises.sleep(3);
		
		chrome.quit();
		
	}

}
