package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {
	
	WebDriver driver;
	
	@Parameters("browser")
	
	@BeforeClass(alwaysRun = true)
	public void setUp(String browser){
		
		
		  // If the browser is Firefox, then do this
		 if(browser.equalsIgnoreCase("firefox")) {
			  System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
			  driver = new FirefoxDriver();
		  // If browser is IE, then do this	  
		  } else if (browser.equalsIgnoreCase("ie")) { 
			  System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
			// If browser is Chrome, then do this
		  } else if (browser.equalsIgnoreCase("chrome")) { 
	  			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	  		    driver = new ChromeDriver();
	  		}
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

	}
	
	@BeforeMethod(alwaysRun = true)
	public void openHomePage(){

		//Assert.assertEquals(driver.getTitle(), ""); // Check is it right page
	}
	
	@AfterClass(alwaysRun = true)
	private void tearDown(){
		driver.quit();
	}
	
	@Test(enabled = true)
	public void searchTest() throws InterruptedException{
		
		
		driver.get("http://www.uat.akdmc.com/");

		Thread.sleep(2000);
		
		//WebElement element = driver.findElement(By.id("searchTerm"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementById('searchTerm').setAttribute('value', 'africa')");
		executor.executeScript("document.getElementById('btn_search2').click();");
		Thread.sleep(2000);

		
		//WebElement ss = driver.findElement(By.id("searchTerm"));
		//ss.clear();
		//ss.sendKeys("test");

		Thread.sleep(2000);
		// Wait for 5 Sec
		Thread.sleep(5000);
		
	}
	
	
	

}
