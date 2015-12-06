package com.noos.databrain.tests;

import com.noos.databrain.browsers.DriverManager;
import com.noos.databrain.multidriver.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class T2 extends AbstractTestNGSpringContextTests {

    @Autowired
    DriverManager man;

    @Test
    public void tsdfest() {
        man.initDriver();
        for (int i = 0; i < 10; i++) {
            System.out.println("test 1");
            sleep(Times.ms);
        }
    }

    @AfterClass
    public void quitDriver() {
        man.quitDriver();
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            System.out.println("ololo");
        }
    }
}
