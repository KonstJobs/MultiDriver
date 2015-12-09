package com.noos.databrain.browsers;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Chrome implements Browser {

   
    private DesiredCapabilities caps;

    @Override
    public WebDriver getInstance() {
        String env = System.getProperty("env");
        caps = setCaps(env);

        return new ChromeDriver(caps);
    }

    @Override
    public DesiredCapabilities setCaps(String env) {

        caps = new DesiredCapabilities();

        switch (env) {

            case "local":
                File chromefile = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                ChromeOptions opt = new ChromeOptions();
                opt.setBinary(chromefile);

                caps.setCapability(ChromeOptions.CAPABILITY, opt);
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
                break;

            case "vm":

        }

        return caps;
    }

}
