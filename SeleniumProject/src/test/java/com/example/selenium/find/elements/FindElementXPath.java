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
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class FindElementXPath {

    private final WebDriver driver;

    public FindElementXPath() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/forms.html");
    }

    @Test
    public void findByRelativePath() {

        WebElement element = driver.findElement(By.xpath("//input"));
        element.sendKeys("Jayasimha");
    }

    @Test
    public void findByPredicates() {

        WebElement element = driver.findElement(By.xpath("//form/div[1]/input"));
        element.sendKeys("I have found you");
    }

    @Test
    public void findByAttibutes() {
        WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println("Element Value =" + element.getText());
    }

    @Test
    public void findByOperatorAnd() {
        WebElement element = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Username']"));
        System.out.println("Element Value =" + element.getAttribute("placeholder"));
    }

    @Test
    public void findByOperatorOr() {
        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio' or @name='optionsRadios']"));
        System.out.println("Radio Elements Count =" + elements.size());
    }

    @Test
    public void findByStarts() {
        List<WebElement> elements = driver.findElements(By.xpath("//input[starts-with(@type,'check')]"));
        System.out.println("Check Elements Count =" + elements.size());
    }

    @Test
    public void findUsingDynamicAttribute1() {
        List<WebElement> elements = driver.findElements(By.xpath("//input[@*='form-control']"));
        System.out.println("DynamicAttribute =" + elements.size());
    }

    @Test
    public void findUsingDynamicAttribute2() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@*='form-control']"));
        System.out.println("DynamicElementAttribute =" + elements.size());
    }

    @Test
    public void getTabelAllRows() {
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='dataTables-example']/tbody/tr"));
        
        System.out.println("Table Total Rows =" + elements.size());
    }

    @Test
    public void getTabelOddRows() {
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
        List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr[@class='gradeA odd']"));
        System.out.println("Table Odd Rows =" + elements.size());
    }

    @Test
    public void getTabelEvenRows() {
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
        List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr[@class='gradeA even']"));
        System.out.println("Table even Rows =" + elements.size());
    }

    @Test
    public void getElementContainsText() {
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
        List<WebElement> elements = driver.findElements(By.xpath("//td[contains(text(),'Firefox')]"));
        System.out.println("Elements contains Text =" + elements.size());
    }

    @Test
    public void getElementwithText() {
        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
        WebElement element = driver.findElement(By.xpath("//td[.='Firefox 3.0']"));
        System.out.println("Elements matching Text =" + element.getText());
    }
    
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
