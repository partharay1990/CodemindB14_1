package SeleniumPratices;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderInTestNg {

	public class VerifyValidLogin {

		WebDriver driver;

		@BeforeMethod
		public void setup() throws IOException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(ReadingPropertiesFile.getProperty("url"));
			driver.manage().window().maximize();
		}

		@Test(dataProvider = "userValidLoginData")
		public void verifyValidLogin(String uname, String pass) {

			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);

			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);

			driver.findElement(By.xpath("//input[@name='submit']")).click();

			String actualLoginSuccessfullMsg = driver
					.findElement(By.xpath("//h3[normalize-space()='Login Successfully']")).getText();

			Assert.assertEquals(actualLoginSuccessfullMsg, "Login Successfully");
		}

		@AfterMethod
		public void tearDown() {

			driver.quit();
		}
		
		@DataProvider(name="userValidLoginData")
		public Object[][] userData(){
			
			String data [][] = {{"admin","admin@123"},{"user","user@123"},{"user1","user1@123"}};
			
			return data;
		}

	}
}
