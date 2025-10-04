package SeleniumPratices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotInSelenium {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;

		File src = takescreenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("src/test/resources/" + System.currentTimeMillis() + ".png"));
	}

}
