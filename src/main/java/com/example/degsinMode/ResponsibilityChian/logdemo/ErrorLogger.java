package com.example.degsinMode.ResponsibilityChian.logdemo;

/**
 * @author yangyangl
 * @date 2019-01-31 13:26
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}