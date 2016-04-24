package ru.itis.inform.department.dao.tokens;

import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.models.Tokens;
import ru.itis.inform.department.dao.models.User;

/**
 * Created by Moskieva on 24.04.16.
 */
public interface TokensDao {
    void setToken(User user, Passwords password);
    Tokens getToken(int userId);
}
