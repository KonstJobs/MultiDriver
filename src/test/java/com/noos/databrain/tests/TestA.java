package com.noos.databrain.tests;

import com.noos.databrain.pages.AbstractPage;
import com.noos.databrain.pages.TestPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestA extends AbstractTestNGSpringContextTests {

    @Autowired
    @Qualifier("abstractPage")
    AbstractPage ab;

    @Autowired
    TestPage testPage;

    @Test
    public void test() {
        ab.setS("ololo");
        testPage.openPage("");
    }

}
