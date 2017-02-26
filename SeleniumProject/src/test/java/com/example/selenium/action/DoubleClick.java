/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class DoubleClick {

    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/doubleclick.html");
    }

    @Test
    public void testDoubleClick() throws Exception {

        WebElement element = driver.findElement(By.id("div"));

        // Verify color is Blue
        Assert.assertEquals("rgba(0, 0, 255, 1)",
                element.getCssValue("background-color"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.doubleClick(element).perform();

        Thread.sleep(2000);

        //Verify Color is Yellow
        Assert.assertEquals("rgba(255, 255, 0, 1)",
                element.getCssValue("background-color"));
    }

    

}
