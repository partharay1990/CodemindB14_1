package SeleniumPratices;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SynchronizationInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement text = driver.findElement(By.cssSelector("#delayedText"));

		WebElement nonvisibleText = driver.findElement(By.xpath("//div[@id='deletesuccess']"));

		// Thread.sleep(10000);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		wait.until(ExpectedConditions.visibilityOf(text));

//		System.out.println(text.isDisplayed());

		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);

		fluentWait.withTimeout(Duration.ofSeconds(30)).ignoring(TimeoutException.class)
				.pollingEvery(Duration.ofSeconds(10));

		fluentWait.until(ExpectedConditions.visibilityOf(text));

		System.out.println(text.isDisplayed());

		fluentWait.until(ExpectedConditions.invisibilityOf(nonvisibleText));

		System.out.println(nonvisibleText.isDisplayed());

		driver.findElement(By.xpath("//button[text()='Check this']")).click();

		WebElement mrCheckbox = driver.findElement(By.cssSelector("#dte"));

		System.out.println(mrCheckbox.isEnabled());

		fluentWait.until(ExpectedConditions.attributeToBe(mrCheckbox, "disabled", ""));

		System.out.println(mrCheckbox.isEnabled());

	}

}
