/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallel.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {

    @Parameters({"browser"})
    @Test
    public void testCaseOne(String browser) {
        System.out.println("browser passed as :- " + browser);
    }

    @Parameters({"username", "password"})
    @Test
    public void testCaseTwo(String username, String password) {
        System.out.println("Parameter for User Name passed as :- " + username);
        System.out.println("Parameter for Password passed as :- " + password);
    }
}
