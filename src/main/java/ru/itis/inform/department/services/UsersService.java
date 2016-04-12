package ru.itis.inform.department.services;

import ru.itis.inform.department.dao.models.User;

/**
 * Created by Moskieva on 29.03.16.
 */
public interface UsersService {
  User getUser(int userId);
}
