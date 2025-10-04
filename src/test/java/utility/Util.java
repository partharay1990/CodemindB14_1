package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

	public static String getProperty(String Key) throws IOException {

		File file = new File("src/test/resources/data.properties");

		FileInputStream fileInputStream = new FileInputStream(file);

		Properties property = new Properties();

		property.load(fileInputStream);

		return property.getProperty(Key);

	}

	public static void selectOptionFromSelectDropdow( WebElement selectTagElement,String option) {

		Select select = new Select(selectTagElement);
		select.selectByVisibleText(option);
	}

	public static void switchToFrame(WebDriver driver, WebElement frame) {

		driver.switchTo().frame(frame);
	}

	public static void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	public static String switchToChildWindow(WebDriver driver) {

		String parentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			if (!(handle.equals(parentWindowHandle))) {

				driver.switchTo().window(handle);
			}
		}

		return parentWindowHandle;

	}

	public static void switchToWindow(WebDriver driver, String handle) {

		driver.switchTo().window(handle);
	}

}
