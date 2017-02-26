/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha B J <jayasimha.bj@gmail.com>
 */
public class SeleniumGridTest {

    private static WebDriver driver;

    @Parameters({"platform", "browser", "version", "url"})
    @BeforeTest(alwaysRun = true)
    public void setup(String platform, String browser, String version,
            String url) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Platforms
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        }

        if (platform.equalsIgnoreCase("MAC")) {
            caps.setPlatform(org.openqa.selenium.Platform.MAC);
        }

        // Browsers
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            caps.setCapability("requireWindowFocus", true);

        }

        if (browser.equalsIgnoreCase("Firefox")) {
            caps = DesiredCapabilities.firefox();
        }

        if (browser.equalsIgnoreCase("Chrome")) {
            caps = DesiredCapabilities.chrome();
            caps.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
            HashMap<String, String> chromePreferences = new HashMap<String, String>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            caps.setCapability("chrome.prefs", chromePreferences);

        }

        if (browser.equalsIgnoreCase("Safari")) {
            caps = DesiredCapabilities.safari();
        }

        // Version
        caps.setVersion(version);

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                caps);
        //driver.manage().window().maximize();
        // Open the BMI Calculator Application
        driver.get(url);

    }

    @Test
    public void testLogin() throws InterruptedException {

        WebElement userNameText = driver.findElement(By.name("email"));
        userNameText.sendKeys("jayasimha.bj@gmail.com");

        WebElement passwordText = driver.findElement(By.id("password"));
        passwordText.sendKeys("welcome123");

        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();
        if (driver.getTitle().equals("SB Admin 2 - Bootstrap Admin Theme")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
