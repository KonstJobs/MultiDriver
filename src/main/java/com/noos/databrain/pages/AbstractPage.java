package com.noos.databrain.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class AbstractPage {

    public static WebDriver driver;

    public void initDriver(WebDriver driver) {
        AbstractPage.driver = driver;
    }

}
