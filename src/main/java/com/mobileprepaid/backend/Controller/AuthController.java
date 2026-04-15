package com.mobileprepaid.backend.Controller;

import com.mobileprepaid.backend.Model.User;
import com.mobileprepaid.backend.Repository.UserRepository;
import com.mobileprepaid.backend.Util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existingUser = userRepository.findByPhone(user.getPhone());

        if (existingUser != null) {
            return "User already exists ❌";
        }

        userRepository.save(user);
        return "Registration Successful ✅";
    }

    // ✅ LOGIN (FIXED)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {

        User dbUser = userRepository.findByPhone(user.getPhone());

        Map<String, Object> res = new HashMap<>();

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {

            String token = jwtUtil.generateToken(dbUser.getPhone());

            res.put("token", token);
            res.put("message", "Login successful ✅");

        } else {
            res.put("message", "Invalid credentials ❌");
        }

        return res;
    }
}