package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver driver;

	@Test(description = "Launches the ET site")
	public void launchSite() throws InterruptedException {

		WebDriver driver;
		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","D:\\newWorkspaceEclipse\\TestET\\DRIVERS\\geckodriver.exe");
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\newWorkspaceEclipse\\TestET\\DRIVERS\\chromedriver.exe");
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
	}

}
