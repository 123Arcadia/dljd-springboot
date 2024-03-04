package com.zcw.demoslf4j;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SLF4j {
    @Test
    public void slf4j() {
        log.info("i = {}", 2);
    }
}
