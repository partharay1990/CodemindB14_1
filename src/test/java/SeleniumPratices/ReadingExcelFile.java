package SeleniumPratices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingExcelFile {

	public static void main(String[] args) throws IOException, InvalidFormatException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(ReadingPropertiesFile.getProperty("rurl"));

		List<Object> list = ReadingExcelFile.reaxExcel();

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(list.get(0).toString());
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(list.get(1).toString());
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(list.get(2).toString());
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(list.get(3).toString());
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(list.get(4).toString());
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(list.get(5).toString());
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(list.get(6).toString());
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(list.get(7).toString());
		WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropdown);
		select.selectByVisibleText("INDIA");

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(list.get(8).toString());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(list.get(9).toString());
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(list.get(10).toString());
		
	//	driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

	public static List<Object> reaxExcel() throws InvalidFormatException, IOException {

		List<Object> lst = new ArrayList<Object>();

		File file = new File("src/test/resources/registrationdetails.xlsx");

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);

		XSSFSheet sheet = xssfWorkbook.getSheet("registrationdata");

		int lastRowNum = sheet.getLastRowNum();

		for (int i = 1; i <= lastRowNum; i++) {

			XSSFRow row = sheet.getRow(i);

			int lastCellNum = row.getLastCellNum();

			for (int j = 0; j < lastCellNum; j++) {

				XSSFCell cell = row.getCell(j);

				if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {

					lst.add(cell.getNumericCellValue());
				}

				if (cell.getCellType() == cell.CELL_TYPE_STRING) {

					lst.add(cell.getStringCellValue());
				}

			}
		}

		xssfWorkbook.close();

		return lst;
	}
}
