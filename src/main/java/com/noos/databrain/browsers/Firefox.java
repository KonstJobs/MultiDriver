package com.noos.databrain.browsers;

import java.io.File;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Firefox implements Browser {

    @Value("${local_ff_dir}")
    private String local_ff_dir;

    private DesiredCapabilities caps;
    private FirefoxProfile firefoxProfile;
    private File firefoxfile;

    @Override
    public WebDriver getDriver() {
        String env = System.getProperty("runOn");
        caps = setCaps(env);

        return new FirefoxDriver(caps);
    }

    @Override
    public DesiredCapabilities setCaps(String runOn) {

        caps = new DesiredCapabilities();
        switch (runOn) {

            case "local":
                
                firefoxfile = new File(local_ff_dir);
                firefoxProfile = new FirefoxProfile(firefoxfile);
                caps.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
                caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                break;

            case "vm":
                break;
            default:
                caps = null;
        }
        return caps;
    }

}
