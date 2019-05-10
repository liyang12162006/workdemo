package com.degsinMode.ResponsibilityChian.logdemo;

/**
 * @author yangyangl
 * @date 2019-01-31 13:26
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}