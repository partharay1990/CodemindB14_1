package SeleniumPratices;

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

public class AssertionInTestNg {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ReadingPropertiesFile.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "userVerifylLogin")
	public void verifyHomepageFunctionality(String uname, String pass) {

		SoftAssert verify = new SoftAssert();

		// verify current page url
		String currentUrl = driver.getCurrentUrl();

		verify.assertEquals(currentUrl, "https://demo.guru99.com/test/newtours/");
		verify.assertEquals(currentUrl, "https://demo.guru99.com/test/newtours/", "page url not matching");

		verify.assertNotEquals(currentUrl, "https://www.google.com/");
		verify.assertNotEquals(currentUrl, "https://www.google.com/", "page url not matching");

		WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));

		verify.assertTrue(submitBtn.isDisplayed());
		verify.assertTrue(submitBtn.isDisplayed(), "submit button is not displayed");

		verify.assertFalse(!(submitBtn.isDisplayed()));
		verify.assertFalse(!(submitBtn.isDisplayed()), "submit button is not displayed");

		// verify current page title
		String homePageTitle = driver.getTitle();
		verify.assertEquals(homePageTitle, "Welcome: Mercury Tours");

		// verify login details
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		submitBtn.click();

		String actualLoginSuccessfullMsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"))
				.getText();
		verify.assertEquals(actualLoginSuccessfullMsg, "Login Successfully");

		verify.assertAll();
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@DataProvider(name = "userVerifylLogin")
	public Object[][] userData() {

		String data[][] = { { "admin", "admin@123" }, { "user", "user@123" }, { "user1", "user1@123" } };

		return data;
	}

}
