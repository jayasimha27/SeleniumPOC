/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.basic.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jayasimha <jayasimha.bj@gmail.com>
 */
public class BasicTest {

    @BeforeSuite
    public static void setUpSuite() throws Exception {
        System.out.println("The annotated method will be run only once "
                + "before all tests in this suite have run.");
    }

    @AfterSuite
    public static void tearDownSuite() throws Exception {
        System.out.println("The annotated method will be run only once after "
                + "all tests in this suite have run.");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("The annotated method will be run only once before the "
                + "first test method in the current class is invoked.");

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("The annotated method will be run only once after all the "
                + "test methods in the current class have run.");
    }

    @BeforeTest
    public static void setUpTests() throws Exception {
        System.out.println("The annotated method will be run before any test method "
                + "belonging to the classes inside the <test> tag is run.");
    }

    @AfterTest
    public static void tearDownTests() throws Exception {
        System.out.println("The annotated method will be run after all the test methods "
                + "belonging to the classes inside the <test> tag have run.");
    }

    @BeforeGroups
    public static void setUpGroup() throws Exception {
        System.out.println("The list of groups that this configuration method will run before. "
                + "This method is guaranteed to run shortly before the first test "
                + "method that belongs to any of these groups is invoked.");
    }

    @AfterGroups
    public static void tearDownGroups() throws Exception {
        System.out.println("The list of groups that this configuration method will run after. "
                + "This method is guaranteed to run shortly after the last test method "
                + "that belongs to any of these groups is invoked.");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.out.println("The annotated method will be run before each test method.");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        System.out.println("The annotated method will be run after each test method");
    }

    @Test
    public void testMe1() {
        System.out.println("Test1 Successfull");

    }
    
     @Test
    public void testMe2() {
        System.out.println("Test2 Successfull");

    }

}
