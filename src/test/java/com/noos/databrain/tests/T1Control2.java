package com.noos.databrain.tests;

import com.noos.databrain.browsers.DriverManager;
import com.noos.databrain.pages.BrowserThread;
import com.noos.databrain.steps.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class T1Control2 extends AbstractTestNGSpringContextTests {

    @Autowired
    DriverManager man;

    @Autowired
    Steps step;

    @Test(invocationCount = 1)
    public void test2() throws InterruptedException {

        System.out.println("START MAIN 2");
        
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) applicationContext.getBean("taskExecutor2");

        String[] bros = {"chrome"};
        broExecutor(bros, taskExecutor);
        taskExecutor.shutdown();
        
        System.out.println("FINISH MAIN");

    }

    public void broExecutor(String[] bros, ThreadPoolTaskExecutor task) {
        for (String bro : bros) {
            BrowserThread bt = (BrowserThread) applicationContext.getBean("browserThread");
            bt.setName(bro);
            task.execute(bt);
        }
    }

    @AfterClass
    public void quitDriver2() {
        step.openPage("https://www.google.com.ua/");
        System.out.println("get in main");
        man.quitDriver();
    }

    @BeforeClass
    public void initDriver() {
        man.initDefDriver();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
}
