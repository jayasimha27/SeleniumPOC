/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.capabilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class IETest {

    private static WebDriver driver;

    @Test
    public void IETest() {

        System.setProperty("webdriver.ie.driver", "D:\\workspace\\TechnicalConsultent\\Selenium\\software\\IEDriverServer.exe");
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        dc.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        dc.setCapability("requireWindowFocus", true);
        driver = new InternetExplorerDriver(dc);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/WebApplication/pages/login.html");

    }

}
