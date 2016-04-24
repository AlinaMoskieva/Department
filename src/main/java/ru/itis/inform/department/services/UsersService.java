package ru.itis.inform.department.services;

import ru.itis.inform.department.dao.models.User;
import ru.itis.inform.department.dao.user.UsersDao;

/**
 * Created by Moskieva on 29.03.16.
 */
public interface UsersService {
  User getUser(int userId);
  void addUser(User user);
}
