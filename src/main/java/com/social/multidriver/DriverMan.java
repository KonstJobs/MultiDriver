package com.social.multidriver;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.stereotype.Component;

@Component
public class DriverMan {

    public void openDriver() {

        FirefoxProfile profile = new FirefoxProfile(new File("E:\\ffprofile"));
        WebDriver driver = new FirefoxDriver(profile);
        LocalDriverManager.setWebDriver(driver);

    }

    public void closeDriver() {
        WebDriver driver = LocalDriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

}
