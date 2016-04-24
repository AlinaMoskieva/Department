package ru.itis.inform.department.dao.user;

import ru.itis.inform.department.controllers.dto.UserDto;
import ru.itis.inform.department.dao.models.User;

/**
 * Created by Moskieva on 29.03.16.
 */
public interface UsersDao {
    User getUser(int userId);
    void addUser(User user);



}
