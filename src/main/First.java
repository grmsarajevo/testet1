package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class First {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Create a new instance of the Firefox driver
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();

		// Launch the Online Store Website
		driver.get("http://deveurotunnelfreight2.eurotunnel.org/uk/home/");
		
		driver.findElement(By.id("search")).sendKeys("trucks");
		driver.findElement(By.className("searchIcon")).click();
		
		Thread.sleep(2000);

		String text = driver.findElement(By.id("carbon-count")).getText();
		
		System.out.println("Text is " + text);

		Assert.assertEquals(text, "trucks");
		// Print a Log In message to the screen
		System.out.println("Successfully opened the website www.Store.Demoqa.com");

		// Wait for 5 Sec
		Thread.sleep(5000);

		// Close the driver
		driver.quit();
		

	}

}
