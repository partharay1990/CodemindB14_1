package SeleniumPratices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJavaScriptAlert {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='alert1']")).click();

		Alert alt = driver.switchTo().alert();

		System.out.println(alt.getText());

		alt.accept();

		driver.findElement(By.xpath("//input[@id='prompt']")).click();
		
		//Alert alt1 = driver.switchTo().alert();

		System.out.println(alt.getText());
		
		alt.sendKeys("Codemind");

		alt.accept(); 	

		driver.findElement(By.xpath("//input[@id='confirm']")).click();

	//	Alert alt2 = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();

	}

}
