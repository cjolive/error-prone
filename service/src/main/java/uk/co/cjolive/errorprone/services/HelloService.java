package uk.co.cjolive.errorprone.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }
}