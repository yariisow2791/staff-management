package com.practice.StaffManage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
                .header("Custom-Header", "SuccessHeader")
                .body("Request was successful!");
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(404)
                .body("Resource not found.");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create() {
        return ResponseEntity.created(null)
                .header("Location", "/resource/123")
                .body("Resource created.");
    }
}
