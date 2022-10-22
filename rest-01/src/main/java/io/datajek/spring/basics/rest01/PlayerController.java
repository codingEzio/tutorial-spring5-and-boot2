package io.datajek.spring.basics.rest01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @GetMapping("/welcome")
    public String welcome() {
        return "This is Houston.";
    }
}
