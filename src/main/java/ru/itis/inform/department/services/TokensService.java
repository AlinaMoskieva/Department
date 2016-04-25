package ru.itis.inform.department.services;

import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.models.Tokens;
import ru.itis.inform.department.dao.models.User;

/**
 * Created by Moskieva on 24.04.16.
 */
public interface TokensService {
    void setToken(User user, Passwords password);
    String getToken(int userId);
    String getToken(User user);
    void vefifyToken(String token);
}
