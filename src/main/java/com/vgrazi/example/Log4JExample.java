package com.vgrazi.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LogLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Log4JExample {
    private static final Logger logger=Logger.getLogger(Log4JExample.class);
    //    private static final Logger logger = Logger.getLogger(Log4JLoggingExample.class.getName());
    private static boolean running=true;
//    private static final Logger logger = Logger.getLogger("this.is.my.awesome.Logger");

    public static void main(String[] args) {
        if(logger.isTraceEnabled()) {
            logger.trace(someComplexOperation("TRACE"));
        }
        if(logger.isEnabledFor(Level.FATAL)) {
            logger.fatal(someComplexOperation("FATAL"));
        }
        if(logger.isEnabledFor(Level.ERROR)) {
            logger.error(someComplexOperation("ERROR"));
        }
        if(logger.isEnabledFor(Level.WARN)) {
            logger.warn(someComplexOperation("WARN"));
        }
        if(logger.isInfoEnabled()) {
            logger.info(someComplexOperation("INFO"));
        }
        if(logger.isDebugEnabled()) {
            logger.debug(someComplexOperation("DEBUG"));
        }
//        logger.debug("Logging in user {} with birthday {}", "Victor", LocalDate.of(1984, 4, 2));

        boolean isNull=checkForNull();
        logger.debug("IsNull:" + isNull);
    }

    private static String someComplexOperation(String level) {
        return "This message is %s".formatted(level);
    }

    public static boolean checkForNull() {
//        while(running)
        try {
            String name=null;
            if(!name.equals("null")) {
                return true;
            }
        } catch(Exception e) {
            logger.warn("Caught an exception", e);
        }
        return false;
    }
}