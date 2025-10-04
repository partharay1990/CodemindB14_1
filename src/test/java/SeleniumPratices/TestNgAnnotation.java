package SeleniumPratices;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotation {

	@BeforeSuite
	public void beforeSuit() {

		System.out.println("Before suit");
	}
	@BeforeTest
	public void beforeTestPlan() {
		
		System.out.println("Before TestPlan");
	}
	@BeforeClass
	public void beforeclass() {
		 
		System.out.println("Before class");
	}
	@BeforeMethod
	public void beforeTestCase() {
		System.out.println("Before test case");
	}
	@Test
	public void testcase() {
		System.out.println("Test case");
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After test case");
	}
	@AfterClass
	public void afterclass() {
		
		System.out.println("After class");
	}
		
	@AfterTest
	public void afterTestPlan() {
		
		System.out.println("after TestPlan");
	}
	
	@AfterSuite
	public void afterSuit() {

		System.out.println("After suit");

	}

}
