package com.logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : liyangyang
 * @date 2019-05-11 17:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoggerTest.class)
public class LoggerTest {
      Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void TestLogger(){

        logger.trace("这个是trace日志");
        logger.debug("这个是debug日志");
        logger.info("这个是info日志");
        logger.warn("这个是warn日志");
        logger.error("这个是error日志");



    }

}
