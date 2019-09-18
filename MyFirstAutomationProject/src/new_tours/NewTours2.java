package new_tours;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**
 * @author Shahruh-Mirzo
 */
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTours2 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Locators:
		 * id
		 * name
		 * className
		 * sccSelector
		 * tagName
		 * linkText
		 * partialLinkText
		 * xpath
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your first name:");
		String firstName = scanner.nextLine();
		System.out.print("Enter your last name:");
		String lastName = scanner.nextLine();
		System.out.print("Enter your phone number:");
		String phoneNumber = scanner.nextLine();
		String email = getEmail(firstName, lastName);
		System.out.print("Enter your adress1:");
		String address1 = scanner.nextLine();
		System.out.print("Enter your adress2:");
		String address2 = scanner.nextLine();
		System.out.print("Enter your city:");
		String city = scanner.nextLine();
		System.out.print("Enter your state:");
		String state = scanner.nextLine();
		System.out.print("Enter your postal code:");
		String postalCode = scanner.nextLine();
		System.out.print("Enter your country:");
		String country = scanner.nextLine();
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\\\Users\\\\Shahruh-Mirzo\\\\Downloads\\\\TechCenture Academy\\\\WebDrivers\\\\chromedriver_win32(76)\\chromedriver.exe");
		
		ChromeDriver chromedriver = new ChromeDriver(); 
		
		chromedriver.get("http://newtours.demoaut.com/");
		chromedriver.findElement(By.linkText("REGISTER")).click();
		chromedriver.findElement(By.name("firstName")).sendKeys(firstName);
		chromedriver.findElement(By.name("lastName")).sendKeys(lastName);
		chromedriver.findElement(By.name("phone")).sendKeys(phoneNumber);
		chromedriver.findElement(By.name("userName")).sendKeys(email);
		chromedriver.findElement(By.name("address1")).sendKeys(address1);
		chromedriver.findElement(By.name("address2")).sendKeys(address2);
		chromedriver.findElement(By.name("city")).sendKeys(city);
		chromedriver.findElement(By.name("state")).sendKeys(state);
		chromedriver.findElement(By.name("postalCode")).sendKeys(postalCode);
		
		WebElement countryDropDown = chromedriver.findElement(By.name("country"));
		/*
		 * findElement method return webElement datat type;
		 * that's why we are assigning it to WebElement object 'countryDropDown'
		 */
		
		Select select = new Select(countryDropDown);
		select.selectByVisibleText(country.toUpperCase());
		
		String userName = generateUserName(firstName, lastName);
		String password = generatePassword(firstName, lastName);
		
		chromedriver.findElement(By.name("email")).sendKeys(userName);
		chromedriver.findElement(By.name("password")).sendKeys(password);
		chromedriver.findElement(By.name("confirmPassword")).sendKeys(password);
		chromedriver.findElement(By.name("register")).click();
		
		String actualConfirmationText = chromedriver.findElement(By.tagName("b")).getText(); // getText method returns String
		String expectedConfirmationText = "Dear " + firstName + " " + lastName + ",";
		
		if(actualConfirmationText.equals(expectedConfirmationText)) {
			System.out.println("You are registered at Mercury successfully");
		} else {
			System.out.println("Sorry, something went wrong...");
		}
		
		String actualConfirmationText2 = chromedriver.findElement(By.xpath("(//b)[2]")).getText();
		String expectedConfirmationText2 = " Note: Your user name is " + userName + ".";
		
		if(actualConfirmationText2.equals(expectedConfirmationText2)) {
			System.out.println("You are registered at Mercury successfully");
		} else {
			System.out.println("Sorry, something went wrong...");
		}
		
		
//		Thread.sleep(5000);
//		chromedriver.quit();

	}
	
	private static String getEmail(String firstName, String lastName) {
		//return (firstName + "." + lastName + "@gmail.com").toLowerCase();
		StringBuilder stb = new StringBuilder();
		stb.append(firstName).append(".").append(lastName).append("@gmail.com");
		return stb.toString().toLowerCase();
	}
	
	private static String generateUserName (String firstName, String lastName) {
		StringBuilder stb1 = new StringBuilder();
		stb1.append(firstName).append("_").append(lastName);
		return stb1.toString().toLowerCase();
	}
	
	private static String generatePassword (String firstName, String lastName) {
		StringBuilder stb1 = new StringBuilder();
		stb1.append(firstName).append(".").append(lastName).append(123);
		return stb1.toString().toLowerCase();
	}

}
