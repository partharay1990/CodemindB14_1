package SeleniumPratices;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.xpath("//textarea[@id='ta1']"));

		textAreaField.sendKeys("Welcome to Codemind Technology");

		Thread.sleep(2000);

		textAreaField.clear();

		System.out.println("####################################");

		String accessName = textAreaField.getAccessibleName();

		System.out.println("Accessable Name = " + accessName);

		System.out.println("####################################");

		String ariaRole = textAreaField.getAriaRole();

		System.out.println("Aria Role = " + ariaRole);

		System.out.println("####################################");

		String attributeValue = textAreaField.getAttribute("rows");

		System.out.println(attributeValue);

		System.out.println("####################################");

		Point p = textAreaField.getLocation();

		System.out.println("X = " + p.getX() + "  " + "Y = " + p.getY());

		System.out.println("####################################");

		Rectangle r = textAreaField.getRect();

		System.out.println("height = " + r.height + "  " + "Width =" + r.width);

		System.out.println("####################################");

		Dimension d = textAreaField.getSize();

		System.out.println("height = " + d.height + "  " + "Width =" + d.width);

		System.out.println("####################################");

		String tagName = textAreaField.getTagName();

		System.out.println("tag name = " + tagName);

		System.out.println("####################################");

		System.out.println("search text field is displayed = " + textAreaField.isDisplayed());

		System.out.println("####################################");

		WebElement dissappearText = driver.findElement(By.cssSelector("#deletesuccess"));

		System.out.println("dissapper text is displayed = " + dissappearText.isDisplayed());

		// Thread.sleep(25000);

		System.out.println("dissapper text is displayed = " + dissappearText.isDisplayed());

		System.out.println("####################################");

		WebElement btnEnabled = driver.findElement(By.cssSelector("#but1"));

		System.out.println("Button1 is enabled = " + btnEnabled.isEnabled());

		System.out.println("####################################");

		WebElement btn2 = driver.findElement(By.xpath("//button[@id='but2']"));

		System.out.println("Button2 is enabled = " + btn2.isEnabled());

		System.out.println("####################################");

		WebElement maleRadio = driver.findElement(By.xpath("//input[@id='radio1']"));

		System.out.println("male radio button is selected = " + maleRadio.isSelected());

		System.out.println("####################################");

		WebElement femaleRadio = driver.findElement(By.cssSelector("input#radio2"));

		femaleRadio.click();

		System.out.println("female radio button is selected = " + femaleRadio.isSelected());

		System.out.println("####################################");

		WebElement alertTextButton = driver.findElement(By.cssSelector("input#alert1"));

		File file = alertTextButton.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("src/test/resources/searchbar.png"));

		WebElement dropdownBtn = driver.findElement(By.cssSelector("button.dropbtn"));

		System.out.println(dropdownBtn.getText());

		System.out.println("Backgrount color = " + dropdownBtn.getCssValue("background-color"));

	}

}
