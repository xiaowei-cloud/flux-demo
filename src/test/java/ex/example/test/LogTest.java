package ex.example.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LogTest {

    public static final Logger logger = LogManager.getLogger(LogTest.class);

    @Test
    public void testQuick(){
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");
    }
}
