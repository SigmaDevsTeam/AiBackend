package com.sigmadevs.aiintegration.api;

import com.sigmadevs.aiintegration.entity.User;
import com.sigmadevs.aiintegration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/setMainToken")
    public String setMainToken(@RequestBody String token, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        user.setMainToken(token);
        userService.save(user);
        return "Token set successfully";
    }
}
