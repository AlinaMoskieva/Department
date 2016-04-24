package ru.itis.inform.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.passwords.PasswordsDao;

/**
 * Created by Moskieva on 24.04.16.
 */
@Component
public class PasswordServiceImpl implements  PasswordService {
    @Autowired
    PasswordsDao passwordsDao;


    @Override
    public void addKey(Passwords keys) {
        passwordsDao.addKey(keys);
    }

    @Override
    public Passwords getKeys(int userId) {
        return passwordsDao.getKeys(userId);
    }
}
