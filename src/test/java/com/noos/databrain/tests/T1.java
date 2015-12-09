package com.noos.databrain.tests;

import com.noos.databrain.browsers.DriverManager;
import com.noos.databrain.pages.BrowserThread;
import com.noos.databrain.steps.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class T1 extends AbstractTestNGSpringContextTests {

    @Autowired
    DriverManager man;

    @Autowired
    Steps step;

    @Test(invocationCount = 1)
    public void tsdfest() throws InterruptedException {

        System.out.println("START MAIN");

        BrowserThread b = new BrowserThread("firefox");
        BrowserThread b1 = new BrowserThread("chrome");
        
        b.getThread().join();
        b1.getThread().join();

        System.out.println("FINISH MAIN");

    }

    @AfterClass
    public void quitDriver() {
        step.openPage("https://www.google.com.ua/");
        System.out.println("get in main");
        man.quitDriver();
    }

    @BeforeClass
    public void initDriver() {
        man.initDriver();
    }

}
