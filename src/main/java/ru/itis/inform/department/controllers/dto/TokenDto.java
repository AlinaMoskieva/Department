package ru.itis.inform.department.controllers.dto;

import ru.itis.inform.department.dao.models.Tokens;

/**
 * Created by Moskieva on 24.04.16.
 */
public class TokenDto {
    private int userId;
    private String token;

    public TokenDto(Tokens token) {
        this.userId = token.getUserId();
        this.token = token.getToken();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
