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

public class TestNgGroups {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ReadingPropertiesFile.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test(groups = {"smoke"},priority = 1, dataProvider ="userVerifyLogin" )
	public void B(String uname, String pass)  {

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);

		driver.findElement(By.xpath("//input[@name='submit']")).click();

		String actualLoginSuccessfullMsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"))
				.getText();

		Assert.assertEquals(actualLoginSuccessfullMsg, "Login Successfully");
	}

	@Test(groups = {"smoke"}, priority = 3 )
	public void C() {

		String homePageTitle = driver.getTitle();

		Assert.assertEquals(homePageTitle, "Welcome: Mercury Tours");
	}

	@Test(groups = {"sanity"}, priority = 2)
	public void A() {

		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://demo.guru99.com/test/newtours/");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}
	@DataProvider (name= "userVerifyLogin")
	public Object[][] userData(){
		
		String data[][]= {{"admin","admin@123"},{"user","user@123"},{"user1","user1@123"}};
		
		return data;
	}

}
