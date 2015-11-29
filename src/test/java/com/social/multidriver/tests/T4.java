package com.social.multidriver.tests;

import com.social.multidriver.DriverMan;
import com.social.multidriver.Times;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class T4 extends AbstractTestNGSpringContextTests {

    @Autowired
    DriverMan man;

    @Test
    public void tsdfest() {
        man.openDriver();
        sleep(300000);
        for (int i = 0; i < 44; i++) {
            System.out.println("test 4");
            sleep(Times.ms);
        }
    }

    @AfterClass
    public void closeDriver() {
        man.closeDriver();
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(T2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
