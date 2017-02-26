/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.capabilities;

import java.util.Arrays;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class ChromeTest {

    private static WebDriver driver;

    @Test
    public void ChromeTest() {

        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\TechnicalConsultent\\Selenium\\software\\chromedriver.exe");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        //dc.setVersion("56.0.2924.87");
        dc.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check", "--disable-extensions"));
        HashMap<String, String> chromePreferences = new HashMap<String, String>();
        chromePreferences.put("profile.password_manager_enabled", "false");
        dc.setCapability("chrome.prefs", chromePreferences);
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://localhost:8080/WebApplication/pages/login.html");

    }

}
