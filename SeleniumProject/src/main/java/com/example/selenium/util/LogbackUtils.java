/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.selenium.util;

/**
 *
 * @author jjagadee
 */
public class LogbackUtils {

    /*private static final Set<String> LOG_CONFIGS = new HashSet<>();

     public synchronized static void setupLoggingConfig(final String LOG_CONFIG) {
     if (LOG_CONFIGS.contains(LOG_CONFIG)) {
     return;
     }
     if ((new File(LOG_CONFIG)).exists()) {
     LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
     JoranConfigurator configurator = new JoranConfigurator();
     configurator.setContext(loggerContext);

     // Don't reset as we have a multi-step(more logback files) configuration
     // loggerContext.reset();
     LOG_CONFIGS.add(LOG_CONFIG);
     try {
     configurator.doConfigure(LOG_CONFIG);
     } catch (JoranException ex) {
     ex.printStackTrace();
     }
     StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
     Logger logger = LoggerFactory.getLogger("logback-init");
     logger.info("Loaded logback....{}", LOG_CONFIG);
     } else {
     System.out.println(MessageFormat
     .format("Could not find Common log configuration file: {0}", LOG_CONFIG));
     }
     }*/
}
