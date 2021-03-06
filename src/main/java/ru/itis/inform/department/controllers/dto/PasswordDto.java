package ru.itis.inform.department.controllers.dto;

import ru.itis.inform.department.dao.models.Passwords;

/**
 * Created by Moskieva on 24.04.16.
 */
public class PasswordDto {
    private int userId;
    private String login;
    private String password;

    public PasswordDto(Passwords passwords) {
        this.userId = passwords.getUserId();
        this.login = passwords.getLogin();
        this.password = passwords.getPassword();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
