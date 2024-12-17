package com.testbed.testbed.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    public String giveDummyResponse(){
        return "Hi now you are in AWS";
    }
}
