package pl.coderslab.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class FakerResource {

    @GetMapping(path= "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}