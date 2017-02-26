/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.find.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class FindlElementCSS {

    private final WebDriver driver;

    public FindlElementCSS() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/forms.html");
    }

    @Test
    public void findByRelativePath() {

        WebElement element = driver.findElement(By.cssSelector("input"));
        element.sendKeys("Jayasimha");
    }

    @Test
    public void findByClassSelector() {

        List<WebElement> elements = driver.findElements(By.cssSelector("input.form-control"));
        System.out.println("findByClassSeletore Elements Count = " + elements.size());
    }

    @Test
    public void findByIDSelector() {

        WebElement elements = driver.findElement(By.cssSelector("input#text-holder"));
        Assert.assertNotNull(elements);
    }

    @Test
    public void findByAttibutes() {
        WebElement element = driver.findElement(By.cssSelector("input[type='text'][placeholder='Username']"));
        Assert.assertNotNull(element);
    }

}
