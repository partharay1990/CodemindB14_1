package SeleniumPratices;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.cssSelector("textarea#ta1"));

		textAreaField.sendKeys("Welcome to Pune");

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("a#selenium143")).click();

		String currentFocusedWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			if (! handle.equals(currentFocusedWindow) ) {

				driver.switchTo().window(handle);
			}
		}

		driver.findElement(By.xpath("//a[text()='What is Selenium?']")).click();

		driver.switchTo().window(currentFocusedWindow);

		textAreaField.clear();

	}

}
