package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	List<WebElement> tableCellElement;

	WebDriver driver;

	WebElement onlyTestingBlogLink;
	WebElement navFrame;
	WebElement moreOptionDropdown;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getTableCellElement() {
		setTableCellElement();
		return tableCellElement;
	}

	public void setTableCellElement() {
		this.tableCellElement = driver.findElements(By.xpath("//table[@id='table1']//tr//td"));
	}


	public WebElement getOnlyTestingBlogLink() {
		setOnlyTestingBlogLink();
		return onlyTestingBlogLink;
	}

	public void setOnlyTestingBlogLink() {
		this.onlyTestingBlogLink = driver.findElement(By.xpath("//a[text()='onlytestingblog']"));
	}

	public WebElement getNavFrame() {
		this.setNavFrame();
		return navFrame;
	}

	public void setNavFrame() {
		this.navFrame = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));
	}

	public WebElement getMoreOptionDropdown() {
		this.setMoreOptionDropdown();
		return moreOptionDropdown;
	}

	public void setMoreOptionDropdown() {
		this.moreOptionDropdown = driver.findElement(By.xpath("//select[@aria-label='More options']"));
	}

	public List<String> getTableData() {

		List<String> data = new ArrayList<String>();

		List<WebElement> tableData = getTableCellElement();

		for (WebElement td : tableData) {

			data.add(td.getText());
		}

		return data;
	}
}
