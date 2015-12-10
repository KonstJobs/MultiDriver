package com.noos.databrain.pages;

import com.noos.databrain.browsers.DriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BrowserThread implements Runnable {

    @Autowired
    DriverManager driverman;

    WebDriver driver;
    String browser;

    public void setName(String browser) {
        this.browser = browser;
    }

    @Override
    public void run() {

        System.out.println("BRO START");
        
        driver = driverman.initDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        driver.get("https://www.google.com.ua/");
        System.out.println("get in bro");

        //driver.close();
        closeDriver();
        System.out.println("BRO FINISH");
    }

    private void closeDriver() {
        driver.close();
    }

}
