/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.group.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author jayasimha <jayasimha.bj@gmai.com>
 */
public class GroupTestExample {

    String message = "example.com";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = {"functest", "checkintest"})
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "example.com";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(groups = {"checkintest"})
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
         message = "example" + ".com";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

    @Test(groups = {"functest"})
    public void testingExitMessage() {
        System.out.println("Inside testExitMessage()");
        message = "www." + "example" + ".com";
        Assert.assertEquals(message, messageUtil.exitMessage());
    }
}
