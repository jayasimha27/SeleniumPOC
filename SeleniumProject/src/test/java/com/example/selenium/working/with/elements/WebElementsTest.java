/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.working.with.elements;

import com.example.selenium.DashBoard;
import com.example.selenium.FormPage;
import com.example.selenium.LoginPage;
import com.example.selenium.Table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class WebElementsTest {

    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void validateApplication() {

        assertTrue(validateLoginPage());
        //assertTrue(validateDashBoardPage());
        //assertTrue(validateTablePage());
        //assertTrue(validateFormPage());
    }

    /**
     *
     * @return
     */
    private boolean validateLoginPage() {

        boolean result;
        driver.get("http://localhost:8080/WebApplication/pages/login.html");
        LoginPage loginPage = new LoginPage(driver);
        result = loginPage.isValidPage();
        result = loginPage.isLogin();
        return result;
    }
    
    /**
     *
     * @return
     */
    private boolean validateDashBoardPage() {

        boolean result;
        driver.get("http://localhost:8080/WebApplication/pages/index.html");
        DashBoard dashBoard = new DashBoard(driver);
        result = (dashBoard.validateMenu() == 7);
        result = (dashBoard.validateToolBar() == 4);
        driver.get("http://localhost:8080/WebApplication/pages/index.html");
        result = dashBoard.validateGraf();
        return result;

    }

    /**
     *
     * @return
     */
    private boolean validateTablePage() {

        driver.get("http://localhost:8080/WebApplication/pages/tables.html");
        Table table = new Table(driver);
        return (table.validateTable());
    }

    private boolean validateFormPage() {

        driver.get("http://localhost:8080/WebApplication/pages/forms.html");
        FormPage formPage = new FormPage(driver);
        return (formPage.validateFormPage());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
