package uk.co.cjolive.errorprone.services;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements HelloServices {

    @Override
    public String hello(@Nullable String name) {
        log(name);
        return "Hello " + name;
    }

    static void log(@Nullable String x) {
        if (x != null)
            System.out.println(x);
    }
}
