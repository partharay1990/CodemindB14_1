package SeleniumPratices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabularData {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));

		for (WebElement elm : tableData) {

			System.out.println(elm.getText());

		}

		System.out.println("#####################################");

		tableData.clear();

		tableData = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td[2]"));

		for (WebElement elm : tableData) {

			System.out.println(elm.getText());

		}

		System.out.println("#####################################");

		tableData.clear();

		tableData = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		for (WebElement elm : tableData) {

			System.out.println(elm.getText());

		}

		System.out.println("#####################################");
		
		tableData.clear();

		tableData = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		for (WebElement elm : tableData) {

			System.out.println(elm.getText());

		}

	}

}
