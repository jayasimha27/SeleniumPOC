/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.data.driven;

import com.example.selenium.util.MetaModelReader;
import com.example.selenium.FormPage;
import com.google.common.base.Joiner;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.apache.metamodel.query.SelectItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class CSVDataReader {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\workspace\\TechnicalConsultent\\Selenium\\software\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/WebApplication/pages/forms.html");
       
    }

    @DataProvider(name = "csvTest")
    public Object[][] testDataCSV() throws Exception {
        File file = new File("src/test/resources/data/Test.csv");
        return MetaModelReader.getCsvData(file);

    }

    @Test(dataProvider = "csvTest")
    public void testCsv(SelectItem[] cols, Object[] data) {

        String aRow = Joiner.on("&").join(data);
        System.out.println("Row data ========" + aRow);
        List<String> columns = Arrays.asList(aRow.split("&"));
        List<String> mutiselect = Arrays.asList((columns.get(columns.size() - 1)).split(","));
        UserForm formBean = new UserForm();
        formBean.setText1(columns.get(1));
        formBean.setText2(columns.get(2));
        formBean.setTextArea(columns.get(3));
        formBean.setFilePath(columns.get(4));
        formBean.setCheckBox1(Boolean.parseBoolean(columns.get(5)));
        formBean.setCheckBox2(Boolean.parseBoolean(columns.get(6)));
        formBean.setCheckBox3(Boolean.parseBoolean(columns.get(7)));
        formBean.setRadio1(Boolean.parseBoolean(columns.get(8)));
        formBean.setRadio2(Boolean.parseBoolean(columns.get(9)));
        formBean.setRadio3(Boolean.parseBoolean(columns.get(10)));
        formBean.setDropDownSelect(columns.get(11));
        formBean.setDropMultiSelect(mutiselect);
        FormPage formPage = new FormPage(driver);
        Assert.assertTrue(formPage.validateFormPage(formBean));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
