package com.noos.databrain.browsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrowserManager {

    @Autowired
    Firefox ff;

    @Autowired
    Chrome chrome;

    private Browser browser;

    public Browser getBrowser(String bro) {

        switch (bro) {
            case "firefox":
                browser = ff;
                break;
            case "chrome":
                browser = chrome;
                break;

            default:
                browser = ff;
        }

        return browser;
    }

}
