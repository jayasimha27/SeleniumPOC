/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class DashBoard {

    private final WebDriver selenium;
    @FindBy(id = "side-menu")
    private WebElement menuElements;

    @FindBy(className = "dropdown-toggle")
    private List<WebElement> toolBarElements;
    
    @FindBy(id = "area-chart")
    private WebElement areaChartButton;
    
    @FindBy(id = "area-chart-menu")
    private WebElement areaChartMenu;
    
    @FindBy(id = "bar-chart")
    private WebElement barChartButton;
    
    @FindBy(id = "bar-chart-menu")
    private WebElement barChartMenu;

    public DashBoard(WebDriver pSelenium) {
        this.selenium = pSelenium;
        PageFactory.initElements(selenium, this);

    }

    /**
     *
     * @return
     */
    public int validateMenu() {

        String menu = menuElements.getText();
        System.out.println("#### Menu Elements ####"+menu);
        List<String> menuElementList = Arrays.asList(menu.split("\n"));
        for (String menuElement : menuElementList) {
            try {
                selenium.findElement(By.linkText(menuElement)).click();
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return menuElementList.size();
    }

    /**
     *
     * @return
     */
    public int validateToolBar() {

        for (WebElement element : toolBarElements) {
            try {
                element.click();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return toolBarElements.size();
    }

    public boolean validateGraf() {
        
        try {
            areaChartButton.click();
            Thread.sleep(1000);
            barChartButton.click();
            Thread.sleep(2000);
            return true;    
        } catch (InterruptedException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
