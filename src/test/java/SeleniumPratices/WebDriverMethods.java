package SeleniumPratices;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("current url = " + currentUrl);

		System.out.println("####################################");

		String title = driver.getTitle();

		System.out.println("page title = " + title);

		System.out.println("####################################");

		// String pageSource = driver.getPageSource();

		// System.out.println("page source = \n" + pageSource);

		String currentFocusedWindowHandle = driver.getWindowHandle();

		System.out.println("current focused window handle = " + currentFocusedWindowHandle);

		driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.in/");

		System.out.println("####################################");

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			System.out.println(handle);
		}

		driver.navigate().to("https://www.flipkart.com/");

		Thread.sleep(3000);

		driver.navigate().forward();

		Thread.sleep(3000);

		driver.navigate().back();

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.close();

	}

}
