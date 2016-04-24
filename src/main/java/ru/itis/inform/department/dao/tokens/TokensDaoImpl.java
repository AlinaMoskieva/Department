package ru.itis.inform.department.dao.tokens;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.department.dao.exeptions.UserIdNotEqualsToPasswordUserId;
import ru.itis.inform.department.dao.jdbc.ParamsMapper;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutor;
import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.models.Tokens;
import ru.itis.inform.department.dao.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by Moskieva on 24.04.16.
 */
public class TokensDaoImpl implements TokensDao {
    @Autowired
    ParamsMapper paramsMapper;
    @Autowired
    SqlQueryExecutor sqlQueryExecutor;

    // language=SQL
    public static final String SQL_INSERT_TOKENS_INFO_INTO_TOKENS = "INSERT INTO tokens VALUES (:userId, :token)";
    // language=SQL
    public static  final String SQL_SELECT_TOKEN_FROM_TOKENS = "SELECT token FROM tokens WHERE (userid = :userId)";

    static final RowMapper<Tokens> TOKENS_ROW_MAPPER = new RowMapper<Tokens>() {
        @Override
        public Tokens mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Tokens(resultSet.getInt("userId"), resultSet.getString("token"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };
    @Override
    public void setToken(User user, Passwords password) {
        String token = "";
        if (user.getId() == password.getUserId()) {
            token = String.valueOf(user.hashCode() + password.hashCode());

            Map<String, Object> paramMap = paramsMapper.asMap(asList("userId", "token"),
                    asList(password.getUserId(), token));

            sqlQueryExecutor.updateQuery(SQL_INSERT_TOKENS_INFO_INTO_TOKENS,paramMap);
        } else  throw new UserIdNotEqualsToPasswordUserId(user, password);

    }

    @Override
    public Tokens getToken(int userId) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId"), asList(userId));
        return sqlQueryExecutor.queryForObject(SQL_SELECT_TOKEN_FROM_TOKENS,paramMap,TOKENS_ROW_MAPPER);
    }
}
