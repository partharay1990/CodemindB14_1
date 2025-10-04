package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownMultiSelectExmpl {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement multiSelectDropdown = driver.findElement(By.xpath("//select[@id='multiselect1']"));

		Select select = new Select(multiSelectDropdown);

		select.selectByIndex(0);

		Thread.sleep(2000);

		select.selectByValue("swiftx");

		Thread.sleep(2000);

		select.selectByContainsVisibleText("dai");

		Thread.sleep(2000);

		select.selectByVisibleText("Audi");

		System.out.println("#############################################");

		List<WebElement> allopt = select.getAllSelectedOptions();

		for (WebElement opt : allopt) {

			System.out.println(opt.getText());
		}

		System.out.println("#############################################");

		WebElement firstSelectOpt = select.getFirstSelectedOption();

		System.out.println("First select option = " + firstSelectOpt.getText());

		System.out.println("#############################################");

		List<WebElement> options = select.getOptions();

		for (WebElement opts : options) {

			System.out.println(opts.getText());
		}

		System.out.println("#############################################");

		boolean bol = select.isMultiple();

		System.out.println("ismultiple selection allowed = " + bol);

		System.out.println("#############################################");

		select.deSelectByContainsVisibleText("Audi");

		Thread.sleep(2000);

		select.deselectByIndex(0);

		Thread.sleep(2000);

		select.deselectByValue("swiftx");

		Thread.sleep(2000);

		select.deselectByVisibleText("Hyundai");

		Thread.sleep(2000);

		select.selectByIndex(2);

		Thread.sleep(2000);

		select.selectByValue("swiftx");

		Thread.sleep(2000);

		select.selectByVisibleText("Audi");

		Thread.sleep(2000);

		select.selectByContainsVisibleText("Vol");

		Thread.sleep(2000);

		select.deselectAll();

	}

}
