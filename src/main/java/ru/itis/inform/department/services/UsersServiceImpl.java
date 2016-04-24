package ru.itis.inform.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.models.User;
import ru.itis.inform.department.dao.user.UsersDao;

/**
 * Created by Moskieva on 12.04.16.
 */
@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    @Override
    public User getUser(int userId) {
        return usersDao.getUser(userId);
    }

    @Override
    public void addUser(User user) {
        usersDao.addUser(user);

    }
}
