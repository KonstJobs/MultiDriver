package com.noos.databrain.steps;

import com.noos.databrain.pages.TestPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Steps {

    @Autowired
    TestPage page;

    public void openPage(String url) {
        page.openPage(url);
    }

}
