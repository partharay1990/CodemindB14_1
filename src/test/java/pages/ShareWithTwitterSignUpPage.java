package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShareWithTwitterSignUpPage {
	
	//WebElement
	
	WebElement WantToLogInFirst;
	
	WebDriver driver; 
	
	public ShareWithTwitterSignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWantToLogInFirst() {
		this.setWantToLogInFirst();
		return WantToLogInFirst;
	}

	public void setWantToLogInFirst() {
		WantToLogInFirst = driver.findElement(By.xpath("//span[text()='Want to log in first?']"));
	}
	
	public String getSetWantToLogInFirstText() {
		
		return getWantToLogInFirst().getText();
	}

}
