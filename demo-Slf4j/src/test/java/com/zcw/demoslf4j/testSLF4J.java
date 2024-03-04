package com.zcw.demoslf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 默认日志点等级：
 *      TRACE < DEBUG < INFO（默认） < WARN < ERROR
 */
@SpringBootTest
public class testSLF4J {
    static Logger logger = LoggerFactory.getLogger(testSLF4J.class);

    @Test
    public void test() {
        logger.info("i = {}", 2);
        //2023-05-01 02:06:20.149 [main] INFO  com.zcw.demoslf4j.testSLF4J - i = 2
    }
}
