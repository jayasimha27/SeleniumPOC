/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.synchronization;

import com.example.selenium.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class ExplicitWait {

    private final WebDriver driver;

    public ExplicitWait() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");

    }

    @Test
    public void validateTable() {
        Table table = new Table(driver);
        Assert.assertTrue(table.validateTable());
        driver.quit();
    }

    /*@Test
    public void testExplicitWaitTitleContains() {
        //Go to the Google Home Page
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        //Enter a term to search and submit
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("selenium");
        query.click();

        //Create Wait using WebDriverWait.
        //This will wait for 10 seconds for timeout before title is updated with search term
        //If title is updated in specified time limit test will move to the text step
        //instead of waiting for 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("selenium"));

        //Verify Title
        assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));

        driver.quit();
    }*/

}
