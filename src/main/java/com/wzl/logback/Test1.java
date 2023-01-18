package com.wzl.logback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {
    public static final Logger logger = LoggerFactory.getLogger("gg");
    public static void main(String[] args) {
        logger.debug("program begin...");
    }
}
