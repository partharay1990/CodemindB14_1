package SeleniumPratices;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(ReadingPropertiesFile.getProperty("url"));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(ReadingPropertiesFile.getProperty("uname"));
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ReadingPropertiesFile.getProperty("password"));
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

	public static String getProperty(String Key) throws IOException {

		File file = new File("src/test/resources/data.properties");

		FileInputStream fileInputStream = new FileInputStream(file);

		Properties property = new Properties();

		property.load(fileInputStream);

		return property.getProperty(Key);

	}

}
