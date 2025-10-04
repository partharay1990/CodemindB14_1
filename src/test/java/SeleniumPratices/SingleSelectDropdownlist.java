package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelectDropdownlist {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement singleSelectDropdown = driver.findElement(By.xpath("//select[@id='drop1']"));

		Select select = new Select(singleSelectDropdown);

		List<WebElement> allSelectOption = select.getAllSelectedOptions();

		for (WebElement allopt : allSelectOption) {

			System.out.println(allopt.getText());
		}
		
		System.out.println("##############################################");


		WebElement firstSelectOption = select.getFirstSelectedOption();

		System.out.println("first select option = " + firstSelectOption.getText());
		
		System.out.println("##############################################");

		List<WebElement> getOption = select.getOptions();

		for (WebElement option : getOption) {

			System.out.println("Dropdown option = " + option.getText());
		}
		
		System.out.println("##############################################");

		Boolean ismult = select.isMultiple();

		System.out.println("multiselection is allowed = " + ismult);
		
		System.out.println("##############################################");
		
		select.selectByIndex(2); //doc 2
		
		Thread.sleep(2000);
		
		select.selectByValue("def"); //doc 1
		
		Thread.sleep(2000);
		
		select.selectByVisibleText("doc 4"); //doc 4
		
		Thread.sleep(2000);
		
		select.selectByContainsVisibleText("Older ");


	}

}
