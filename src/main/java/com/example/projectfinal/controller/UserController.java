package com.example.projectfinal.controller;

import com.example.projectfinal.controller.request.UserJoinRequest;
import com.example.projectfinal.controller.request.UserLoginRequest;
import com.example.projectfinal.controller.response.UserJoinResponse;
import com.example.projectfinal.controller.response.UserLoginResponse;
import com.example.projectfinal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public ResponseEntity<Object> join(@RequestBody UserJoinRequest request){
        return ResponseEntity.ok().body(UserJoinResponse.fromUser(userService.join(request.getName(), request.getPassword())));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginRequest request){
        String token = userService.login(request.getName(), request.getPassword());
        return ResponseEntity.ok().body(new UserLoginResponse(token));
    }
}
