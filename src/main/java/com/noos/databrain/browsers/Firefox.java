
package com.noos.databrain.browsers;

import java.io.File;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements Browser {

 
    private DesiredCapabilities caps;
    private FirefoxProfile firefoxProfile;
    private File firefoxfile;

    @Override
    public DesiredCapabilities setCaps(String env) {
        
        caps = new DesiredCapabilities();
        switch (env) {

            case "local":
                firefoxfile = new File("E:\\ffprofile");
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

    @Override
    public WebDriver getInstance() {
        String env = System.getProperty("env");
        caps = setCaps(env);
        
        return new FirefoxDriver(caps);
    }

}
