/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class LoginPage {

    final static Logger logger = Logger.getLogger(LoginPage.class);
    private static final String LOG_CONFIG = "src/main/resources/logback.xml";
    private final WebDriver selenium;

    @FindBy(className = "panel-title")
    private WebElement loginTitle;

    @FindBy(name = "email")
    private WebElement emailText;

    @FindBy(id = "password")
    private WebElement passwordText;

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    /**
     *
     * @param pselenium
     */
    public LoginPage(WebDriver pselenium) {
        this.selenium = pselenium;
        PageFactory.initElements(selenium, this);
    }

    /**
     *
     * @return
     */
    public boolean isValidPage() {
        if ((loginTitle.getText().equalsIgnoreCase("Please Sign In"))) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean isLogin() {

        try {
            emailText.sendKeys("robert@gmail.com");
            Thread.sleep(1000);
            passwordText.sendKeys("welcome123");
            loginButton.click();

            // Set the implicit wait time out to 10 Seconds
            selenium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (selenium.getTitle().equals("SB Admin 2 - Bootstrap Admin Theme")) {
                logger.debug("SucessFull");
                return true;
            }
        } catch (InterruptedException ex) {

        }
        return false;
    }

}
