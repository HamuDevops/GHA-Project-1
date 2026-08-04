package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping(value="/", produces="text/html")
    public String home() {
        return """
        <html>
        <body style='font-family:Arial;text-align:center;background:#f4f4f4'>
            <h1>🍔 Kastro Food Store</h1>
            <h2>Burger - ₹199</h2>
            <h2>Pizza - ₹299</h2>
            <h2>Biryani - ₹249</h2>
            <button>Order Now</button>
        </body>
        </html>
        """;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
