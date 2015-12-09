package com.noos.databrain.pages;

import com.noos.databrain.browsers.Chrome;
import com.noos.databrain.browsers.Firefox;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class BrowserThread implements Runnable {

    Thread t;
    WebDriver driver;
    String name;

    public BrowserThread(String name) {
        t = new Thread(this, name);
        this.name = name;
        System.out.println("BRO STARTED");
        t.start();
    }

    public Thread getThread() {
        return t;
    }

    @Override
    public void run() {

        switch (name) {
            case "chrome":
                driver = new Chrome().getInstance();
                break;
            case "firefox":
                driver = new Firefox().getInstance();
                break;
        }

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
