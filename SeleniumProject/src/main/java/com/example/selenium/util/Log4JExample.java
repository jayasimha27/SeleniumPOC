/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.util;

import org.apache.log4j.Logger;

/**
 *
 * @author jjagadee
 */
public class Log4JExample {

    final static Logger logger = Logger.getLogger(Log4JExample.class);

    public static void main(String[] args) {

        Log4JExample obj = new Log4JExample();
        obj.runMe("SeleniumWebDriverPOC");

    }

    private void runMe(String parameter) {

        logger.debug("This is debug : " + parameter);
        logger.info("This is info : " + parameter);
        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

}
