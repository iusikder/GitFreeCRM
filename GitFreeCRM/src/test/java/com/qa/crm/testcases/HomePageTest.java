package com.qa.crm.testcases;

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
	
	
	@Test(priority=2)
	public void verifyUserNameTest() throws Exception{
        testUtil.wait(4);
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws Exception{
        testUtil.wait(4);
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();		
	}
	
}