package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDatepickerInSelenium {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");
		driver.manage().window().maximize();

		selectDatePicker("2025", "September", "08");

		Thread.sleep(4000);

		selectDatePicker("2025", "January", "12");

		datePicker1("2025", "January", "10");

		datePicker1("2025", "September", "8");

	}

	public static void selectDatePicker(String year, String month, String dateSelect) {

		driver.findElement(By.xpath("//input[@id='datetimepicker1']")).click();

		WebElement monthDropdown = driver
				.findElement(By.xpath("(//select[@class='flatpickr-monthDropdown-months'])[1]"));

		Select select = new Select(monthDropdown);

		select.selectByVisibleText(month);

		driver.findElement(By.xpath("(//input[@class='numInput cur-year'])[1]")).clear();

		driver.findElement(By.xpath("(//input[@class='numInput cur-year'])[1]")).sendKeys(year);

		List<WebElement> dates = driver.findElements(By.xpath(
				"(//div[@class='dayContainer'])[1]//span[not(@class='flatpickr-day prevMonthDay') and not(@class='flatpickr-day nextMonthDay')]"));

		for (WebElement data : dates) {

			if (data.getText().equals(dateSelect)) {

				data.click();

				break;
			}
		}

		driver.findElement(By.xpath("//h1[text()='Date Picker']")).click();

	}

	public static void datePicker1(String year1, String month1, String dateSelect1) {

		driver.findElement(By.xpath("//input[@id='datetimepicker2']")).click();

		driver.findElement(By.xpath("(//input[@class='numInput cur-year'])[2]")).clear();

		driver.findElement(By.xpath("(//input[@class='numInput cur-year'])[2]")).sendKeys(year1);

		WebElement monthDrop1 = driver.findElement(By.xpath("(//select[@class='flatpickr-monthDropdown-months'])[2]"));

		Select select = new Select(monthDrop1);

		select.selectByVisibleText(month1);

		List<WebElement> dates1 = driver.findElements(By.xpath(
				"(//div[@class='dayContainer'])[2]//span[not(@class='flatpickr-day prevMonthDay') and not(@class='flatpickr-day nextMonthDay')]"));

		for (WebElement date1 : dates1) {

			if (date1.getText().equals(dateSelect1)) {

				date1.click();
				break;
			}
		}

		driver.findElement(By.xpath("(//input[@class='numInput flatpickr-hour'])[2]")).sendKeys("9");

		driver.findElement(By.xpath("(//input[@class='numInput flatpickr-minute'])[2]")).sendKeys("30");

		driver.findElement(By.xpath("(//span[@class='flatpickr-am-pm'])[2]")).click();

		driver.findElement(By.xpath("//h1[text()='Date Picker']")).click();

	}

}
