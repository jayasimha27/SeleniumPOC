/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.action;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class TableRowSelection {
    
    private static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
    }
    
    @Test
    public void testRowSelectionUsingControlKey() throws InterruptedException {

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='dataTables-example']/tbody/tr"));

        //Select second and fourth row from table using Control Key.
        //Row Index start at 0
        Actions builder = new Actions(driver);
        builder.click(tableRows.get(0))
                .keyDown(Keys.CONTROL)
                .click(tableRows.get(2))
                .keyUp(Keys.CONTROL)
                .build().perform();
        Thread.sleep(3000);
      
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    
}
