package test_leaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Common;
import driver.Driver;

/**
 * 
 * @author Shahruh-Mirzo
 *
 */
public class Button {
	
	public static void main(String[] args) {
		
		WebDriver driver = Driver.getDriver("chrome");
		
		driver.navigate().to("http://testleaf.herokuapp.com/");
		//driver.findElement(By.xpath("(//h5)[2]")).click();
		driver.findElement(By.linkText("Button")).click();
		Common.sleep(2);
		//driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.findElement(By.id("home")).click();
		Common.sleep(2);
//		String actualText = driver.findElement(By.xpath("//h1[@class='wp-heading']")).getText();
		String actualText = driver.findElement(By.tagName("h1")).getText();
		Common.sleep(2);
		if (actualText.equals("Locators and Selenium Interactions")) {
			System.out.println("Header check: pass");
		} else {
			System.out.println("Header check: fail");
		}
		driver.navigate().back();
		
		int x = driver.findElement(By.id("position")).getLocation().getX();
		int y = driver.findElement(By.id("position")).getLocation().getY();
		System.out.println("x is " + x + " y is " + y);
		
		String color1 = driver.findElement(By.id("color")).getAttribute("style");
		String color2 = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println(color1);
		System.out.println(color2);
		int height = driver.findElement(By.id("size")).getSize().getHeight();
		int width = driver.findElement(By.id("size")).getSize().getWidth();
		System.out.println("height is " + height + " width is " + width);
		
		driver.quit();
	}

}
