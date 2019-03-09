package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BaseTest;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;


public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;    
    
    public LoginPageTest(){
        super();
    }
    
    
    
    @BeforeMethod
    public void setUp(){
        initialization();            
        loginPage = new LoginPage();
    }
    
    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
    }
    
/*
    @Test(priority=2)
    public void crmLogoImgTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }
    */

    @Test(priority=2)
    public void loginTest() throws Exception{
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    
    
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
