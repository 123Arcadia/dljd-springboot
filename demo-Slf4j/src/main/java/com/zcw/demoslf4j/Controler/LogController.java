package com.zcw.demoslf4j.Controler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class LogController {

    private Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/log")
    @ResponseBody
    public String testLOg() {
        int x = 1, y = 2;
        int res = (x + y) >> 1;
        logger.info("x = " + x);
        logger.info("y = " + y);

        /**
         * debug没有显示在控制台，因为springboot内部集成了slf4j，默认是info级别(error也可以显示)
         */
        logger.debug("[debug-log] res = " + res);

        try {
            int e = 1 / 0;
        } catch (Exception e) {
            logger.error("There is an error[1 / 0]");
            return "error!";
        }
        return "res = " + res;
    }
}
