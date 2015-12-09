
package com.noos.databrain.pages;

import org.springframework.stereotype.Component;

@Component
public class TestPage extends AbstractPage{

    public void openPage(String url) {
        driver.get(url);
    }
    
}
