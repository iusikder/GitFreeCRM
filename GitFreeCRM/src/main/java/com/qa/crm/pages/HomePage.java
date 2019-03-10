package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.base.BaseTest;
import com.qa.crm.util.TestUtil;


public class HomePage extends BaseTest {
    @FindBy(xpath="//td[@class='headertext']")
    WebElement userNameLabel;
    
    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
    
    @FindBy(xpath="//a[contains(text(),'New Contact')]")
    WebElement newContactLink;
    
    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement dealsLink;
    
    @FindBy(xpath="//a[contains(text(),'Tesks')]")
    WebElement tasksLink;
    
    //Initializing the Page Objects....
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    
    
    
    //Methods
    public String verifyHomePageTitle() throws Exception{
        ////////////
        TestUtil testUtil = new TestUtil();
        testUtil.waitForPageToLoad();
        testUtil.wait(4);
        return driver.getTitle();        
    }
    
    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }
    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }
    
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();        
    }
    
    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
    
    public void clickOnNewContactLink(){ //Clicking on New Contact Link
        Actions action = new Actions(driver);  //This code is to Mouse Hover on Contact Button
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }    
    
}

