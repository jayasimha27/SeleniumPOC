/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.synchronization;

import com.example.selenium.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class ImplicitWait {
    
    private final WebDriver driver;
    
    public ImplicitWait() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/SeleniumPOC/pages/login.html");
        
    }
    
    @Test
    public void isLogin() {
        
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLogin());
        
    }
    
}
