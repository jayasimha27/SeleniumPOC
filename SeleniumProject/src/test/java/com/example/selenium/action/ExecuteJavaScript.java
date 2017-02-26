/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class ExecuteJavaScript {

    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/forms.html");
    }

    @Test
    public void testJavaScriptCalls() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("sendgetreq()");
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.alertIsPresent());
            // Get the Alert
            Alert alert = driver.switchTo().alert();
            String response = alert.getText();
            Thread.sleep(1000);
            alert.accept();
            Assert.assertEquals("HTTP Respose Success", response);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
