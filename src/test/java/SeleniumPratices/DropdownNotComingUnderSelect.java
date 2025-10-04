package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownNotComingUnderSelect {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/vistara-airlines.html");
		driver.manage().window().maximize();

		selectDropdownList("Return Trip");

		Thread.sleep(2000);

		 selectDropdownList("One Way");

	}

	public static void selectDropdownList(String tripType) {

		// expand drop down
		driver.findElement(By.xpath("//input[@id='tripType']")).click();
		
		driver.findElement(By.xpath("//div[@class='tripTypeFilter']/ul/li/p[text()='"+ tripType +"']")).click();

//		// get all value from drop down
//		List<WebElement> tripOption = driver.findElements(By.xpath("//div[@class='tripTypeFilter']/ul/li/p"));
//
//		// logic for selecting value from drop down
//		for (WebElement elm : tripOption) {
//
//			if (elm.getText().equalsIgnoreCase(tripType)) {
//
//				elm.click();
//				break;
//			}
//		}

	}

}
