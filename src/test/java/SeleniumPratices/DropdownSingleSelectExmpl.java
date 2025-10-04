package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSingleSelectExmpl {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement singleDropdown = driver.findElement(By.xpath("//select[@id='drop1']"));

		Select select = new Select(singleDropdown);

		WebElement firstSelect = select.getFirstSelectedOption();

		System.out.println("First select option = " + firstSelect.getText());

		System.out.println("#######################################################");

		List<WebElement> allOption = select.getAllSelectedOptions();

		for (WebElement option : allOption) {

			System.out.println(option.getText());
		}

		System.out.println("#######################################################");

		List<WebElement> option1 = select.getOptions();

		for (WebElement opt : option1) {

			System.out.println("Dropdown option = " + opt.getText());
		}
		System.out.println("#######################################################");

		Boolean isMult = select.isMultiple();

		System.out.println("multiselection is allowed = " + isMult);

		System.out.println("#######################################################");

		select.selectByContainsVisibleText("2"); // doc2

		select.selectByValue("def"); // doc1

		select.selectByIndex(3); // doc 4

		select.selectByVisibleText("doc 3"); //doc3

	}

}
