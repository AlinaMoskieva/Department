package ru.itis.inform.department.services;

import ru.itis.inform.department.dao.models.Passwords;

/**
 * Created by Moskieva on 24.04.16.
 */
public interface PasswordService {
    void addKey(Passwords keys);
    Passwords getKeys(int userId);
}
