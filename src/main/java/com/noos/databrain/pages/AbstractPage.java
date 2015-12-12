package com.noos.databrain.pages;

import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class AbstractPage {

//    public WebDriver driver;
//
//    public void initDriver() {
//        driver = LocalDriver.getDriver();
//    }
    public static String s;

    public void setS(String s) {
        AbstractPage.s = s;
    }

}
