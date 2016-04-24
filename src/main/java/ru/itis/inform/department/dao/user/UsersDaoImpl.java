package ru.itis.inform.department.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.controllers.dto.UserDto;
import ru.itis.inform.department.dao.DaoArgumentsVerifier;
import ru.itis.inform.department.dao.jdbc.ParamsMapper;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutor;
import ru.itis.inform.department.dao.models.Participants;
import ru.itis.inform.department.dao.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by Moskieva on 01.04.16.
 */
@Component
public class UsersDaoImpl implements UsersDao {
    @Autowired
    DaoArgumentsVerifier daoArgumentsVerifier;
    @Autowired
    ParamsMapper paramsMapper;
    @Autowired
    SqlQueryExecutor sqlQueryExecutor;

    // language=SQL
    public static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE (id = :userId) ";
    // language=SQL
    public static final String SQL_INSERT_USER_INTO_USERS="INSERT INTO users VALUES (:id, :userName, :email, :city, :age, :gender, :passportData, :snils)";

    static final RowMapper<User> USER_ROW_MAPPER = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new User(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("email"), resultSet.getString("city"),
                        resultSet.getString("age"), resultSet.getString("gender"),
                        resultSet.getString("passportData"), resultSet.getInt("snils"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };
    @Override
    public User getUser(int userId) {
        daoArgumentsVerifier.verifyUser(userId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId"), asList(userId));
        return sqlQueryExecutor.queryForObject(SQL_GET_USER_BY_ID, paramMap, USER_ROW_MAPPER);

    }

    @Override
    public void addUser(User user) {
        daoArgumentsVerifier.verifyUser(user.getId());
        Map<String, Object> paramMap = paramsMapper.asMap(asList("id", "userName", "email", "city", "age", "gender", "passportData", "snils"),
                asList(user.getId(),user.getUserName(), user.getEmail(),user.getCity(),user.getAge(),user.getGender(),user.getPassportData(),user.getSnils()));
        sqlQueryExecutor.updateQuery(SQL_INSERT_USER_INTO_USERS, paramMap);


    }
}
