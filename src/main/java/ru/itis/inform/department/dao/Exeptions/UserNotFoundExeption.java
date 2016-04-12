package ru.itis.inform.department.dao.Exeptions;

/**
 * Created by Moskieva on 12.04.16.
 */
public class UserNotFoundExeption extends RuntimeException {
    private String message ="";

    public UserNotFoundExeption(int userId) {
        this.message = "User with id " + userId + " not found.";
    }
    @Override
    public String toString(){
        return message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
