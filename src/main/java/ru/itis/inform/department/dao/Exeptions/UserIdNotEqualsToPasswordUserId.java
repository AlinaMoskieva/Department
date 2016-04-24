package ru.itis.inform.department.dao.exeptions;

import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.models.User;

/**
 * Created by Moskieva on 24.04.16.
 */
public class UserIdNotEqualsToPasswordUserId extends RuntimeException {
    private String message = "";

    public UserIdNotEqualsToPasswordUserId(User user, Passwords passwords ){
        this.message = "User id is  "+ user.getId() +", password's userId is "+passwords.getUserId();
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
