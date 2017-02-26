/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.find.elements;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha<jayasimha.bj@gmail.com>
 */
public class FindElementsTest {

    private WebDriver selenium;

    @BeforeTest
    public void setupTest() {
        selenium = new FirefoxDriver();
        selenium.get("http://localhost:8080/WebApplication/pages/login.html");

    }

    @Test
    public void findByName() {

        try {
            WebElement element = selenium.findElement(By.name("email"));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void findById() {

        try {
            WebElement element = selenium.findElement(By.id("password"));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void findByClassName() {

        try {
            WebElement element = selenium.findElement(By.className("panel-title"));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void findByLinkTest() {

        try {
            WebElement element = selenium.findElement(By.linkText("Login"));
            System.out.println("Element Attrbutes =" + element.getAttribute("href"));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void findByPartialLinkTest() {

        try {
            WebElement element = selenium.findElement(By.partialLinkText("Log"));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void findByTagName() {

        try {
            List<WebElement> elements = selenium.findElements(By.tagName("input"));
            Assert.assertEquals(elements.size(), 3);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void findByNestedElement() {
        try {
            WebElement element = selenium.findElement(By.id("div1")).findElement(By.name("email"));
            Assert.assertNotNull(element);
        } catch (NoSuchElementException ex) {
            Logger.getLogger(FindElementsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @AfterTest
    public void tearDownTests(){
        selenium.quit();
    }

}
