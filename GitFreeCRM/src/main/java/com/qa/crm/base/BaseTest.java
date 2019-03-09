package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.crm.util.TestUtil;
import com.qa.crm.util.WebEventListener;


public class BaseTest {    
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    
    public BaseTest(){    //Constructor of BaseTest Class to Initialize the Properties file.
        try{
            prop = new Properties();
            //FileInputStream ip = new FileInputStream("/Proj_FreeCRMTest/src/main/java/com/crm/config/config.properties");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/crm/config/config.properties");
            prop.load(ip);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void initialization(){
        String browserName = prop.getProperty("browser");            
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:/AllDrivers/LatestChrome/chromedriver.exe");
            driver = new ChromeDriver();                
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "C:/AllDrivers/NewGeckoDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        
        //WebDriver FiringEvent
        e_driver= new EventFiringWebDriver(driver);
        //Now Create object of EventListenerHandler to register it EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;            
        
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    }

    }
