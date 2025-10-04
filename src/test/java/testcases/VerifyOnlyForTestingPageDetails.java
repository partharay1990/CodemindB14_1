package testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.OnlyForTestingPage;

public class VerifyOnlyForTestingPageDetails extends BaseTest {

	HomePage homepage;
	 
	OnlyForTestingPage testingPage;
    @Test
	public void verifyOnlyForTestingPageDetails() {

		homepage = new HomePage(driver);
		homepage.getOnlyTestingBlogLink().click();
		
		testingPage = new OnlyForTestingPage(driver);
		
		assertTrue(testingPage.verifyFirstNameTextField(),"Firstname textfiels is enabled ");
		assertFalse(testingPage.verifyLastNameTextField(),"Lastname textfield is enabled");
		
		
	}

}
