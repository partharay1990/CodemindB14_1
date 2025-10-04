package SeleniumPratices;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertInTestNg {
	
	public class AssertionInTestNg {

		WebDriver driver;

		@BeforeMethod
		public void setup() throws IOException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(ReadingPropertiesFile.getProperty("url"));
			driver.manage().window().maximize();
		}

		@Test
		public void verifyHomepageFunctionality() {

		

			// verify current page url
			String currentUrl = driver.getCurrentUrl();

			assertEquals(currentUrl, "https://demo.guru99.com/test/newtours/");
			assertEquals(currentUrl, "https://demo.guru99.com/test/newtours/", "page url not matching");

			assertNotEquals(currentUrl, "https://www.google.com/");
			assertNotEquals(currentUrl, "https://www.google.com/", "page url not matching");

			WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));

			assertTrue(submitBtn.isDisplayed());
			assertTrue(submitBtn.isDisplayed(), "submit button is not displayed");

			assertFalse(!(submitBtn.isDisplayed()));
			assertFalse(!(submitBtn.isDisplayed()), "submit button is not displayed");

			// verify current page title
			String homePageTitle = driver.getTitle();
			assertEquals(homePageTitle, "Welcome: Mercury Tours");

			// verify login details
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin@123");
			submitBtn.click();

			String actualLoginSuccessfullMsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"))
					.getText();
			assertEquals(actualLoginSuccessfullMsg, "Login Successfully");

			
		}

		@AfterMethod
		public void tearDown() {

			driver.quit();
		}

		
	}

}
