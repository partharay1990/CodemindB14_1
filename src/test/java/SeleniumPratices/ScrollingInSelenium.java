package SeleniumPratices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingInSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		
		// vertically  & horizontal scroll
		
		javascriptExecutor.executeScript("window.scrollBy(0,1000)"); 
		
		Thread.sleep(2000);
		
		javascriptExecutor.executeAsyncScript("window.scrollBy(0,-1000)");
		
		Thread.sleep(2000);
		
		javascriptExecutor.executeScript("window.scrollBy(100,0)");
		
		Thread.sleep(2000);
		
		javascriptExecutor.executeScript("window.scrollBy(-100,0)");
		
		// scroll complete page width
		
		javascriptExecutor.executeScript("window.scrollBy(document.body.scrollWidth,0)");
		
		// scroll complete page height
		
		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		WebElement userNameTextField = driver.findElement(By.xpath("//input[@name='userid']"));
		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", userNameTextField);
		
		Thread.sleep(3000);
		
		userNameTextField.sendKeys("Codemind");
		
		// click with javascript code
		
		WebElement link =driver.findElement(By.xpath("//a[text()='Blogger']"));
		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", link);
		
		Thread.sleep(3000);
	
		javascriptExecutor.executeScript("arguments[0].click();", link);
		
		// mouse wheel scroller  
		
		Actions action = new Actions(driver);
		
		action.scrollByAmount(0, 1000).build().perform();
		
		

	}

}
