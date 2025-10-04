package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDropdownlist {

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

		System.out.println("##############################################");

		List<WebElement> allsSelectedOption = select.getAllSelectedOptions();

		for (WebElement option : allsSelectedOption) {

			System.out.println(option.getText());
		}

		System.out.println("##############################################");

		WebElement firstSelect = select.getFirstSelectedOption();

		System.out.println("First select option = " + firstSelect.getText());

		System.out.println("##############################################");

		List<WebElement> allOption = select.getOptions();

		for (WebElement aption : allOption) {

			System.out.println("Dropdown option" + aption.getText());
		}

		System.out.println("##############################################");

		Boolean multiselect = select.isMultiple();

		System.out.println("Multi select allowed = " + multiselect);

		System.out.println("##############################################");

		select.deselectByIndex(3);

		Thread.sleep(2000);

		select.deselectByValue("Hyundaix");

		Thread.sleep(2000);

		select.deselectByVisibleText("Volvo");

		Thread.sleep(2000);

		select.deSelectByContainsVisibleText("Swi");

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
