package SeleniumPratices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrameInSelenium {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();
		
		WebElement frame =driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));
		
		driver.switchTo().frame(frame);
		
//		driver.switchTo().frame(0);
		
//		driver.switchTo().frame("navbar-iframe'");
		
		WebElement textField = driver.findElement(By.xpath("//input[@name='q' and not(@title='search')]"));
		
		textField.sendKeys("Codemind Technology");
		
		driver.switchTo().defaultContent();
		
		WebElement textArea = driver.findElement(By.xpath("//textarea[@id='ta1']"));
		
		textArea.sendKeys("Come back to frame");
		
		driver.switchTo().frame(frame);
		
		textField.clear();
		
		driver.switchTo().defaultContent();

		textArea.clear();
		


	}

}
