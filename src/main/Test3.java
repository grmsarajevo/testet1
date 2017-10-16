package main;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {

	WebDriver driver;

	@Parameters("browser")

	@BeforeClass(alwaysRun = true)
	public void setUp(String browser) {

		// If the browser is Firefox, then do this
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			// If browser is IE, then do this
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\drivers\\MicrosoftWebDriver.exe");
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
	public void openHomePage() {

		System.out.println(driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "Umbraco - www.uat.akdmc.com"); // Check is it right page
	}

	@AfterClass(alwaysRun = true)
	private void tearDown() {
		driver.quit();
		
	}

	@Test(enabled = false)
	public void searchTest() throws InterruptedException {

		driver.get("http://uateurotunnel2.eurotunnel.org/uk/holiday-ideas/category/restaurants/");
		
		Select select = new Select(driver.findElement(By.id("selectCategories")));
		select.selectByVisibleText("Cities");
		Thread.sleep(1000);
		
		Select select1 = new Select(driver.findElement(By.id("selectRegions")));
		select1.selectByVisibleText("Paris");
		


		// Wait for 5 Sec
		Thread.sleep(5000);

	}
	@Test(enabled = true)
	public void test1() throws InterruptedException {

		driver.get("http://www.uat.akdmc.com");
		
		driver.findElement(By.linkText("Guest Information Form")).click();
		
		Select dmc = new Select(driver.findElement(By.id("ee8b701b-5356-45c1-acfe-442ee1764410")));
		dmc.selectByValue("Chile");
		
		driver.findElement(By.id("ab121366-6ba3-49fb-e6f4-d8d1e67906b1")).sendKeys("tt1234");
		driver.findElement(By.id("44f668ac-6b37-4709-ef46-9a0141fff374")).sendKeys("t1234");
		driver.findElement(By.id("d140dee6-b1e3-4d56-bc14-e2d2929bec73")).sendKeys("t1234");
		driver.findElement(By.id("78d313f9-6a46-46bf-db48-69baa21fe2d9")).sendKeys("t1234@asdf.com");
		
		driver.findElement(By.id("db51fe53-5b47-4ab0-cfc3-cb7864de8273")).sendKeys("t1234");
		driver.findElement(By.id("7e42b1dc-0233-4bce-a581-999478fc5685")).sendKeys("t1234");
		driver.findElement(By.id("c9ba21b4-eb30-4997-ad0b-10b377be51f0")).sendKeys("asdf@asas.com");
		driver.findElement(By.id("4d27014f-ebe6-4ed1-fa99-effd40214e85")).sendKeys("t1234");
		driver.findElement(By.id("f2f100ae-1142-432e-8d1f-2790f3798868")).sendKeys("31/03/2017");
		driver.findElement(By.id("6c3d2ac2-4173-479f-dc1c-071ec082b3cc")).sendKeys("t1234");
		driver.findElement(By.id("cd8e4497-dc90-4397-9813-d50e0428ccc4")).sendKeys("31/03/2017");
		driver.findElement(By.id("74febdd8-3315-43af-ffb9-afe679927fae")).sendKeys("13/02/2010");
		driver.findElement(By.id("556d2eed-0136-4de4-b27b-08aadfdaa9be")).sendKeys("t1234");
		driver.findElement(By.id("5d1df71b-09d2-4a51-859d-e8ed7ab7ca90")).sendKeys("t1234");
		driver.findElement(By.id("af240aa3-9de1-495d-ee13-f751d2fe7d14")).sendKeys("t123456@asdf.com");
		driver.findElement(By.id("85088650-4ead-4ba5-cdd7-b89453dee25a")).sendKeys("t1234");
		
		Select nog = new Select(driver.findElement(By.id("7c8984a5-8b35-437e-e03a-d40de906acb8")));
		nog.selectByValue("1");
		
		Thread.sleep(2000);
		driver.findElement(By.name("__next")).click();
		
		
		
		
		

		

		// Wait for 5 Sec
		Thread.sleep(5000);

	}
	
	
	@Test(enabled = true)
	public void test2() throws InterruptedException {

		driver.get("http://www.uat.akdmc.com/umbraco");
		
		driver.findElement(By.name("username")).sendKeys("NedimO");
		driver.findElement(By.name("password")).sendKeys("Nedim12345");
		driver.findElement(By.className("btn-success")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("icon-umb-contour")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/ul/li/ul/li[1]/div/ins")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/ul/li/ul/li[1]/ul/li[1]/div/ins")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Entries1")).click();
		Thread.sleep(2000);
		
		
		String countryString = driver.findElement(By.xpath("/html/body/div/section/div/div/div/form/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/a")).getText().toString();
		Thread.sleep(2000);

		if(countryString.contains("Chile")) {
			driver.findElement(By.xpath("/html/body/div/section/div/div/div/form/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/a")).click();
			
		} else {
			System.out.println(countryString);
		}
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("/html/body/div/section/div/div/div/form/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/div/section/div/div/div/form/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/span")).getText());
		assertEquals(driver.findElement(By.xpath("/html/body/div/section/div/div/div/form/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/span")).getText(), "tt1234");
		

		// Wait for 5 Sec
		Thread.sleep(3000);

	}

}
