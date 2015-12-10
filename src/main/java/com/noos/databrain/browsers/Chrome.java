package com.noos.databrain.browsers;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Chrome implements Browser {

    private final String local_chrome_dir = 
    private DesiredCapabilities caps;

    @Override
    public WebDriver getDriver() {
        String env = System.getProperty("runOn");
        caps = setCaps(env);

        return new ChromeDriver(caps);
    }

    @Override
    public DesiredCapabilities setCaps(String runOn) {

        caps = new DesiredCapabilities();

        switch (runOn) {

            case "local":
                File chromefile = new File(local_chrome_dir);
                ChromeOptions opt = new ChromeOptions();
                opt.setBinary(chromefile);

                caps.setCapability(ChromeOptions.CAPABILITY, opt);
                System.setProperty("webdriver.chrome.driver", ".\src\\main\\resources\\drivers\\chromedriver.exe");

                break;

            case "vm":

        }

        return caps;
    }

}
