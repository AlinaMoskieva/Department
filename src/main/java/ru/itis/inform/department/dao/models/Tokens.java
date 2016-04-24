package ru.itis.inform.department.dao.models;

import java.util.Objects;

/**
 * Created by Moskieva on 24.04.16.
 */
public class Tokens {
    private int userId;
    private String token;

    public Tokens(int userId, String token) {
        this.userId = userId;
        this.token = token;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Tokens that = (Tokens) obj;
        return Objects.equals(this.getUserId(), that.getUserId()) &&
                Objects.equals(this.getToken(), that.getToken());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId(), this.getToken());
    }

    @Override
    public String toString() {
        return "Tokens{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
