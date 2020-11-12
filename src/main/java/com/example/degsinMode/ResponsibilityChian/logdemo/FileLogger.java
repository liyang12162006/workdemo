package com.example.degsinMode.ResponsibilityChian.logdemo;

/**
 * @author yangyangl
 * @date 2019-01-31 13:27
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}