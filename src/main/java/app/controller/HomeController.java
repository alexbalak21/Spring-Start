package app.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public Map<String, String> home() {
        return Map.of("message", "Welcome to the home page!");
    }
    
}
