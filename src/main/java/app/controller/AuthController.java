package app.controller;

import app.dto.UserLoginRequest;
import app.dto.UserRegisterRequest;
import app.model.User;
import app.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterRequest registerRequest) {
        logger.info("Registration attempt for user: {}", registerRequest.getEmail());
        try {
            User user = authService.registerUser(registerRequest);
            logger.info("User registered successfully with ID: {}", user.getId());
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "User registered successfully");
            response.put("userId", user.getId());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Registration failed for user: {}", registerRequest.getEmail(), e);
            
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Registration failed: " + e.getMessage());
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginRequest loginRequest) {
        String token = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(token);
    }
}
