/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.grid;

import com.example.selenium.util.ApachePOIXLSReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class SeleniumGridIE {
    
    private static WebDriver driver;
    
    @BeforeTest
    public void setup() throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        caps = DesiredCapabilities.internetExplorer();
        caps.setVersion("11.0.33");
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                caps);
        //driver.manage().window().maximize();
    }
    
    
    @DataProvider(name = "xlsTest")
    public Object[][] testDataXLS() throws Exception {
        return ApachePOIXLSReader.excelRead("src/test/resources/data/login.xls");
        
    }
    
    @Test(dataProvider = "xlsTest")
    public void testLogin(String useName, String password) throws InterruptedException {
        
        driver.get("http://localhost:8080/WebApplication/pages/login.html");
        Thread.sleep(2000);
        WebElement userNameText = driver.findElement(By.name("email"));
        userNameText.sendKeys(useName);
        
        WebElement passwordText = driver.findElement(By.id("password"));
        passwordText.sendKeys(password);
        
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();
        if (driver.getTitle().equals("SB Admin 2 - Bootstrap Admin Theme")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    
}
