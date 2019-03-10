package com.qa.crm.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;


public class HomePageTest extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;	
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super(); //Calling super class constructor.
	}	
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws Exception{
		String actualHomePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(actualHomePageTitle,"CRMPRO","Home page title not matched");
	}
	//NOTE:: TOMORROW I HAVE TO FIX REST OF THE TEST CASES. UNTIL NOW IT IS WORKING FINE.....
/*	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	*/
	/*@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}*/
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();		
	}
	
}