package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ShareWithTwitterSignUpPage;
import utility.Util;

public class VerifyLoginFirstMsg extends BaseTest {

	HomePage homepage;
	ShareWithTwitterSignUpPage shareWithTwitterSignUpPage;

	@Test
	public void verifyLoginFirstMsg() {

		homepage = new HomePage(driver);
		Util.switchToFrame(driver, homepage.getNavFrame());
		Util.selectOptionFromSelectDropdow(homepage.getMoreOptionDropdown(), "Share with Twitter");
		Util.switchToDefaultContent(driver);
		String parentWindow = Util.switchToChildWindow(driver);
		
		shareWithTwitterSignUpPage = new ShareWithTwitterSignUpPage(driver);
		assertEquals(shareWithTwitterSignUpPage.getSetWantToLogInFirstText(), "Want to log in first?","Text is not matching");
		
		driver.close();
		
		Util.switchToWindow(driver, parentWindow);
		
		System.out.println(driver.getTitle());
	}

}
