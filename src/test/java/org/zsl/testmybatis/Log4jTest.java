package org.zsl.testmybatis;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        //获取log4j配置文件
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        logger.error("ERROR!!!!!");//输出error级别的日志
        logger.debug("DEBUG~");//输出debug级别的日志
    }
}
