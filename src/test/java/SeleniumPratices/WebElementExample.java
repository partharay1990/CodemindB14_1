package SeleniumPratices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExample {

	public static void main(String[] args) {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");

		// Initialize a new WebDriver instance (in this case, ChromeDriver)
		WebDriver driver = new ChromeDriver();

		// get(String url) command
		driver.get("https://www.example.com/");

		// getTitle() Command
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);

		// getCurrentUrl() Command
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		// getPageSource() Command
		String pageSource = driver.getPageSource();
		System.out.println("Page Source: " + pageSource);

		// sendKeys() command
		WebElement textBox = driver.findElement(By.id("TextBox"));
		textBox.sendKeys("GeeksForGeeks");

		// isDisplayed() command
		WebElement element = driver.findElement(By.id("gfg"));
		boolean isDisplayed = element.isDisplayed();
		System.out.println("Element is displayed: " + isDisplayed);

		// isSelected() command (for checkboxes, radio buttons, etc.)
		WebElement checkbox = driver.findElement(By.id("software-testing"));
		boolean isSelected = checkbox.isSelected();
		System.out.println("Checkbox is selected: " + isSelected);

		// submit() command
		WebElement submitButton = driver.findElement(By.id("SubmitButton"));
		submitButton.submit();

		// isEnabled() command
		WebElement isEnabledElement = driver.findElement(By.id("GFG"));
		boolean isEnabled = isEnabledElement.isEnabled();
		System.out.println("Element is enabled: " + isEnabled);

		// getLocation() command
		WebElement locationElement = driver.findElement(By.id("Selenium"));
		int xCoordinate = locationElement.getLocation().getX();
		int yCoordinate = locationElement.getLocation().getY();
		System.out.println("X Coordinate: " + xCoordinate);
		System.out.println("Y Coordinate: " + yCoordinate);

		// clear() command
		WebElement clearElement = driver.findElement(By.id("edittext"));
		clearElement.clear();

		// getSize() command
		WebElement sizeElement = driver.findElement(By.id("SubmitButton"));
		int elementHeight = sizeElement.getSize().getHeight();
		int elementWidth = sizeElement.getSize().getWidth();
		System.out.println("Element Height: " + elementHeight);
		System.out.println("Element Width: " + elementWidth);

		// getAttribute() command
		WebElement attributeElement = driver.findElement(By.id("Submit"));
		String attributeValue = attributeElement.getAttribute("id");
		System.out.println("Attribute Value: " + attributeValue);

		// click() command
		WebElement clickElement = driver.findElement(By.id("GeeksForGeeks"));
		clickElement.click();

		// Close the current browser window/tab
		driver.close();

		// Quit the WebDriver session
		driver.quit();

	}

}
