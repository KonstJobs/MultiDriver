package com.noos.databrain.browsers;

import com.noos.databrain.pages.AbstractPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DriverManager {

    @Autowired
    AbstractPage abstractPage;

    @Autowired
    private ApplicationContext appContext;

    Browser browser;

    public WebDriver initDefDriver() {
        String bro = System.getProperty("browser");

        WebDriver driver = initBrowser(bro);

        abstractPage.initDriver(driver);
        return driver;

    }

    public WebDriver initDriver(String bro) {
        WebDriver driver = initBrowser(bro);
        return LocalDriver.getDriver();
    }

    private WebDriver initBrowser(String bro) {

        WebDriver driver;
        browser = (Browser) appContext.getBean(bro);

        driver = browser.getDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        LocalDriver.setWebDriver(driver);
        return LocalDriver.getDriver();

    }

//    public WebDriver getDriver() {
//        return dr//LocalDriver.getDriver();
//    }
    public void quitDriver() {
        WebDriver driver = LocalDriver.getDriver();
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

}
