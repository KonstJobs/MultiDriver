package com.noos.databrain.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public interface Browser {
    public DesiredCapabilities setCaps(String runOn);
    public WebDriver getDriver();
}
