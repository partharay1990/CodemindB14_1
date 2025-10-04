package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocaterStrategiesInSelenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.id("ta1"));

		textAreaField.sendKeys("Welcome to India");

		WebElement searchThisBlog = driver.findElement(By.name("q"));

		searchThisBlog.sendKeys("India");
		
		WebElement textH1 = driver.findElement(By.className("title"));

		System.out.println(textH1.getText());

		driver.navigate().to("https://demo.guru99.com/test/newtours");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Number of a tag = " + links.size());

		driver.findElement(By.linkText("Flights")).click();

		driver.findElement(By.partialLinkText("Hote")).click();

	

	}

}
