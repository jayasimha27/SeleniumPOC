/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium;

import com.example.selenium.data.driven.UserForm;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class FormPage {

    private final WebDriver selenium;

    @FindBy(id = "text-input")
    private WebElement textInput;

    @FindBy(id = "text-holder")
    private WebElement placeHolder;

    @FindBy(id = "text-area")
    private WebElement textArea;

    @FindBy(id = "check-box1")
    private WebElement checkBox1;

    @FindBy(id = "check-box2")
    private WebElement checkBox2;

    @FindBy(id = "check-box3")
    private WebElement checkBox3;

    @FindBy(id = "line-check")
    private WebElement inlineCheckBox;

    @FindBy(id = "radio1")
    private WebElement radioButton1;

    @FindBy(id = "radio2")
    private WebElement radioButton2;

    @FindBy(id = "radio3")
    private WebElement radioButton3;

    @FindBy(id = "radio-inline")
    private WebElement radioInline;

    @FindBy(id = "drop-down")
    private WebElement dropDown;

    @FindBy(id = "multi-drop-down")
    private WebElement multidropDown;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id = "file")
    private WebElement file;

    public FormPage(WebDriver pSelenium) {
        this.selenium = pSelenium;
        PageFactory.initElements(selenium, this);

    }

    public boolean validateFormPage(UserForm bean) {
        try {
            textInput.sendKeys(bean.getText1());
            Thread.sleep(1000);
            placeHolder.sendKeys(bean.getText2());
            Thread.sleep(1000);

            //File Upload
            file.click();
            Thread.sleep(2000);
            StringSelection ss = new StringSelection(bean.getFilePath());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            //imitate mouse events like ENTER, CTRL+C, CTRL+V
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);

            textArea.sendKeys(bean.getTextArea());
            Thread.sleep(1000);
            if (bean.isCheckBox1()) {
                checkBox1.click();
            } else if (bean.isCheckBox2()) {
                checkBox2.click();
            } else if (bean.isCheckBox3()) {
                checkBox3.click();
            }
            Thread.sleep(1000);
            inlineCheckBox.click();

            if (bean.isRadio1()) {
                radioButton1.click();
            } else if (bean.isRadio2()) {
                radioButton2.click();
            } else if (bean.isRadio3()) {
                radioButton3.click();
            }
            radioButton1.click();
            Thread.sleep(1000);
            radioInline.click();

            dropDown.click();
            Select dropSelect = new Select(dropDown);
            dropSelect.selectByIndex(Integer.parseInt(bean.getDropDownSelect()));
            Thread.sleep(1000);

            multidropDown.click();
            Select multidropSelect = new Select(multidropDown);
            for (String str : bean.getDropMultiSelect()) {
                multidropSelect.selectByIndex(Integer.parseInt(str));
            }
            Thread.sleep(1000);
            submit.click();
            new WebDriverWait(selenium, 10)
                    .until(ExpectedConditions.alertIsPresent());
            // Get the Alert
            Alert alert = selenium.switchTo().alert();
            alert.accept();
        } catch (Exception ex) {
            Logger.getLogger(FormPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean validateFormPage() {
        try {
            textInput.sendKeys("Selenium Automated Text ...");
            Thread.sleep(1000);
            placeHolder.sendKeys("Selenium Automated Text ...");
            Thread.sleep(1000);

            //File Upload
            file.click();
            Thread.sleep(1000);
            StringSelection ss = new StringSelection("D:\\workspace\\TechnicalConsultent\\Selenium\\docs\\ppt\\WorkingWithElements.ppt");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            //imitate mouse events like ENTER, CTRL+C, CTRL+V
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);

            textArea.sendKeys("What's Selenium ? \n Selenium is a portable software testing framework for web applications. "
                    + "Selenium provides a record/playback tool for authoring tests without learning a test scripting language (Selenium IDE).");
            Thread.sleep(1000);
            checkBox1.click();
            Thread.sleep(1000);
            inlineCheckBox.click();
            Thread.sleep(1000);
            radioButton1.click();
            Thread.sleep(1000);
            radioInline.click();
            Thread.sleep(1000);
            dropDown.click();
            Select dropSelect = new Select(dropDown);
            dropSelect.selectByIndex(4);
            Thread.sleep(1000);
            multidropDown.click();
            Select multidropSelect = new Select(multidropDown);
            multidropSelect.selectByIndex(2);
            multidropSelect.selectByIndex(3);
            multidropSelect.selectByIndex(4);
            Thread.sleep(1000);
            submit.click();
            selenium.switchTo().alert().accept();
        } catch (Exception ex) {
            Logger.getLogger(FormPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
