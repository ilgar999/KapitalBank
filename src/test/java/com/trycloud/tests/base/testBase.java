package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class testBase {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser") );
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }
    public static void loginTryCloud(){
        driver.findElement(By.id("user")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.cssSelector("#password")).sendKeys(ConfigurationReader.getProperty("password"));
        driver.findElement(By.id("submit-form")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
