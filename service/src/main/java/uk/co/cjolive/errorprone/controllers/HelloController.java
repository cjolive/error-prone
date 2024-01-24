package uk.co.cjolive.errorprone.controllers;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.cjolive.errorprone.services.HelloService;

@RestController
public class HelloController {

    private HelloService helloService;

    @Nullable private String lastName = null;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> sayHello(@PathVariable String name) {
        this.lastName = name;
        String hello = helloService.hello(name);
        return ResponseEntity.ok(hello);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        String hello = helloService.hello(lastName);
        return ResponseEntity.ok(hello);
    }
}
