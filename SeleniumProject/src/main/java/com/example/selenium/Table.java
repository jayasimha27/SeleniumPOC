/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class Table {

    private final WebDriver selenium;
    @FindBy(name = "dataTables-example_length")
    private WebElement tableDropDown;

    @FindBy(className = "sorting")
    private List<WebElement> tableColumnsList;

    @FindBy(xpath = "//input[@class='form-control input-sm']")
    private WebElement tableSearch;

    public Table(WebDriver pSelenium) {
        this.selenium = pSelenium;
        PageFactory.initElements(selenium, this);
    }

    public boolean validateTable() {

        boolean flag = true;
        List<WebElement> tablesRows;
        try {

            Select selectRows = new Select(tableDropDown);
            tableDropDown.click();
            Thread.sleep(2000);

            selectRows.selectByValue("10");
            tableDropDown.click();
            WebDriverWait wait = new WebDriverWait(selenium, 10);
            tablesRows = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='dataTables-example']/tbody/tr"), 10));
            if (tablesRows.size() != 10) {
                flag = false;
            }
            
            Thread.sleep(1000);
            selectRows.selectByValue("25");
            tableDropDown.click();
            tablesRows = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='dataTables-example']/tbody/tr"), 25));
            if (tablesRows.size() != 25) {
                flag = false;
            }
            
            Thread.sleep(1000);
            selectRows.selectByValue("50");
            tableDropDown.click();
            tablesRows = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='dataTables-example']/tbody/tr"), 50));
            if (tablesRows.size() != 50) {
                flag = false;
            }
            
            Thread.sleep(2000);
            tableSearch.sendKeys("Presto");
            Thread.sleep(1000);
            WebElement element = new WebDriverWait(selenium, 5)
                    .until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver d) {
                            return d.findElement(By.xpath("//td[contains(text(),'Presto')]"));
                        }
                    });
            if (!element.getText().equals("Presto")) {
                flag = false;
            }

            return flag;
        } catch (InterruptedException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

}
