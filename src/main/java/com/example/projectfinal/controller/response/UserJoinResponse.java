package com.example.projectfinal.controller.response;

import com.example.projectfinal.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinResponse {
    private int id;
    private String name;

    public static UserJoinResponse fromUser(User user) {
        return new UserJoinResponse(
                user.getID(),
                user.getUsername()
        );
    }
}
