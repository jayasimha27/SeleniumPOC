/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallel.independent;

import org.testng.annotations.Test;

public class IndependentTest {

    @Test(threadPoolSize = 3, invocationCount = 10, timeOut = 1000)
    public void testMethod() {
        Long id = Thread.currentThread().getId();
        System.out.println("Test method executing IndependentTest id: " + id);
    }
}
