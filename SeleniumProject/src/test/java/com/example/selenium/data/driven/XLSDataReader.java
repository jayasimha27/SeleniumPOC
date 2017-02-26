/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.data.driven;

import com.example.selenium.util.ApachePOIXLSReader;
import com.example.selenium.FormPage;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class XLSDataReader {
    
    private WebDriver driver;
    
    @BeforeTest
    public void setup() {
        
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/WebApplication/pages/forms.html");
    }
    
    @DataProvider(name = "xlsTest")
    public Object[][] testDataXLS() throws Exception {
        return ApachePOIXLSReader.excelRead("src/test/resources/data/test.xls");

    }
    
    @Test(dataProvider = "xlsTest")
    public void testme(String text1, String text2, String textArea, String filePath, boolean checkBox1, boolean checkBox2, boolean checkBox3,
            boolean radio1, boolean radio2, boolean radio3, String selectIndex, String multiSelect) {

        System.out.println("Multiselect Value ====="+multiSelect);
        String dropDownIndex = selectIndex.replace("\"", "");
        List<String> multiSelectList = Arrays.asList((multiSelect.replace("\"", "")).split(","));

        UserForm formBean = new UserForm(text1, text2, textArea, filePath, checkBox1,
                checkBox2, checkBox3, radio1, radio2, radio3, dropDownIndex, multiSelectList);
        FormPage formPage = new FormPage(driver);
        Assert.assertTrue(formPage.validateFormPage(formBean));

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    
}
