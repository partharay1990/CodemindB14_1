package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlyForTestingPage {

	// web elements
	WebDriver driver;
	WebElement firstNameTextField;
	WebElement lastNameTextField;

	// constructor
	public OnlyForTestingPage(WebDriver driver) {
		this.driver = driver;
	}

	// getters and setters
	public WebElement getFirstNameTextField() {
		setFirstNameTextField();
		return firstNameTextField;
	}

	public void setFirstNameTextField() {
		this.firstNameTextField = driver.findElement(By.cssSelector("#text1"));
	}

	public WebElement getLastNameTextField() {
		setLastNameTextField();
		return lastNameTextField;
	}

	public void setLastNameTextField() {
		this.lastNameTextField = driver.findElement(By.cssSelector("#text2"));
	}

	// methods
	public boolean verifyFirstNameTextField() {

		return getFirstNameTextField().isEnabled();
	}

	public boolean verifyLastNameTextField() {

		return getLastNameTextField().isEnabled();
	}

}
