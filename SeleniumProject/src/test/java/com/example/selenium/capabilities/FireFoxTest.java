/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.capabilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 *
 * @author jjagadee
 */
public class FireFoxTest {
    private static WebDriver driver;
    @Test
    public void FireFoxTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/WebApplication/pages/login.html");

    }
    
}
