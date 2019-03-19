
package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;


public class ContactsPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;    
    TestUtil testUtil;
    ContactsPage contactsPage;
    
    String sheetName = "Contact_Sheet";
    public ContactsPageTest(){
        super();
    }    

    @BeforeMethod
    public void setUp() throws Exception{
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(4000);
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }
    
    @Test(priority=1)
    public void verifyContactsPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is missing on the Page");
    }
    
    @Test(priority=2)
    public void selectSingleContactsTest(){
        contactsPage.selectContactsByName("David Chris");
    }
    
    @Test(priority=3)
    public void selectMultipleContactsTest(){
        contactsPage.selectContactsByName("ABCD EFGH");
        contactsPage.selectContactsByName("David Chris");
    }

    @Test(priority=4, dataProvider="getCRMTestData")
    public void validateCreateNewContact(String title, String fName, String lName, String company){
	    homePage.clickOnNewContactLink();
	    contactsPage.createNewContacts(title, fName, lName, company);
	    homePage.clickOnContactsLink();    
	   //Assert.assertTrue(contactsPage.verifyContactsByName("David Chris")); //I HAVE TO CHECK IT LATER   
    }    

    
    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }
    
    @AfterMethod
    public void tearDown(){
      driver.quit();
  
    }
    
}

