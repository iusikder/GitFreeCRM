package com.qa.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.BaseTest;
import com.qa.crm.util.TestUtil;

public class LoginPage extends BaseTest {
    TestUtil testUtil;/////////    
    
    //Page Factory/OR
    @FindBy(name="username")
    public WebElement username;
    
    @FindBy(name="password")
    public WebElement password;
    
    //@FindBy(xpath="//input[@type='submit']")
    @FindBy(xpath="//input[@class='btn btn-small' and @type='submit']")
    WebElement loginBtn;
    
    @FindBy(xpath="//img[@class='img-responsive']")
    WebElement crmLogo; //I HAVE TO CHECK IT LATER HOW NAVEEN DID IT. IF HE USED CONTAINS OR NOT
    
    //Initializing the Page Objects
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    
    
    
   // Methods
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    
    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();        
    }
    
     public HomePage login(String uName, String pWord){
        TestUtil testUtil = new TestUtil();////// I'm just checking
       username.sendKeys(uName);
        password.sendKeys(pWord);       
           
        //loginBtn.click();
        testUtil.wait(4);
    /*  Actions actions = new Actions(driver);
        actions.click(loginBtn).perform();*/
        
        //Solution 2
        //THIS JAVASCRIPT WORKED for the Radio Button also !!!!!
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);",(loginBtn));
        return new HomePage();  //After Login it will return HomePage Object.
    }
        
    
}


