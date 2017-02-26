/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.action;

import org.openqa.selenium.By;
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
public class DragDrop {

    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/droppable1.html");
    }

    @Test
    public void testDragDrop() throws InterruptedException {

        WebElement source = driver.findElement(By.id("d1"));
        WebElement target = driver.findElement(By.id("target"));

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).perform();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//div[2]/div"));
        Assert.assertNotNull(element);
        
       
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
