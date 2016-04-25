package ru.itis.inform.department.dao.exeptions;

/**
 * Created by Moskieva on 25.04.16.
 */
public class TokenNotFoundExeption extends RuntimeException {
    private String message = "";

    public TokenNotFoundExeption(String token) {
        this.message = "Token with " + token + " id is not found";
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
