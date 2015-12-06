package com.noos.databrain.browsers;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

@Component
public class Chrome implements Browser {

   
    private DesiredCapabilities caps;

    @Override
    public WebDriver getInstance() {
        String env = System.getProperty("runOn");
        caps = setCaps(env);

        return new ChromeDriver(caps);
    }

    @Override
    public DesiredCapabilities setCaps(String env) {

        caps = new DesiredCapabilities();

        switch (env) {

            case "local":
                File chromefile = new File("");
                ChromeOptions opt = new ChromeOptions();
                opt.setBinary(chromefile);

                caps.setCapability(ChromeOptions.CAPABILITY, opt);
                caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                System.setProperty("webdriver.chrome.driver", "Z:\\soft\\AutotestRepo\\BigTesty\\src\\main\\resources\\drivers\\chromedriver.exe");

                break;

            case "vm":

        }

        return caps;
    }

}
