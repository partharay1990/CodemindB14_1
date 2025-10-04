package testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import pages.HomePage;

public class VerifyTableData extends BaseTest {

	HomePage homePage;

	@Test(groups = {"sanity"} )
	public void verifyTableData() {

		homePage = new HomePage(driver);

		List<String> expectedTableData = Arrays.asList("Kishore", "22", "Delhi", "Manish", "25", "Pune", "Praveen",
				"29", "Bangalore", "Dheepthi", "31", "Mumbai");

		List<String> data = homePage.getTableData();

		verify.assertEquals(data, expectedTableData, "Table data not matched");
	}

}
