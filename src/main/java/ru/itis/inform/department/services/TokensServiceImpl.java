package ru.itis.inform.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.models.Tokens;
import ru.itis.inform.department.dao.models.User;
import ru.itis.inform.department.dao.tokens.TokensDao;

/**
 * Created by Moskieva on 24.04.16.
 */
@Component
public class TokensServiceImpl implements TokensService {
    @Autowired
    TokensDao tokensDao;

    @Override
    public void setToken(User user, Passwords password) {
        tokensDao.setToken(user, password);
    }

    @Override
    public String getToken(int userId) {
        Tokens token = tokensDao.getToken(userId);
        return token.getToken();
    }

    @Override
    public String getToken(User user) {
        Tokens token = tokensDao.getToken(user.getId());
        return token.getToken();
    }
}
