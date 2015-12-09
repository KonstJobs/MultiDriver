package com.noos.databrain.browsers;

import com.noos.databrain.pages.AbstractPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverManager {

    @Autowired
    AbstractPage abstractPage;

    Browser browser;

    private DesiredCapabilities capabilities;

    public WebDriver initDriver() {
        WebDriver driver;

        String bro = System.getProperty("browser");

        switch (bro) {
            case "firefox":
                browser = new Firefox();
                break;
            case "chrome":
                browser = new Chrome();
                break;
            default:
                browser = new Firefox();
        }

        driver = browser.getInstance();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        abstractPage.initDriver(driver);
        LocalDriver.setWebDriver(driver);
        return driver;
    }

    public WebDriver getDriver() {
        return LocalDriver.getDriver();
    }

    public void quitDriver() {
        WebDriver driver = LocalDriver.getDriver();
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

   
}
