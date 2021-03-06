package ru.itis.inform.department.dao.passwords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.DaoArgumentsVerifier;
import ru.itis.inform.department.dao.jdbc.ParamsMapper;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutor;
import ru.itis.inform.department.dao.models.Participants;
import ru.itis.inform.department.dao.models.Passwords;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static java.util.Arrays.asList;

@Component
public class PasswordsDaoImpl implements PasswordsDao {
    @Autowired
    ParamsMapper paramsMapper;
    @Autowired
    SqlQueryExecutor sqlQueryExecutor;
    // language=SQL
    public static final String SQL_GET_PASSWORD_INFO_FROM_PASSWORDSS = "SELECT * FROM passwords WHERE (userid = :userid) ";
    // language=SQL
    public static final String SQL_INSERT_PASSWORDS_INTO_PASSWORDS = "INSERT INTO passwords VALUES (:userid, :login, :password)";

    static final RowMapper<Passwords> PASSWORDS_ROW_MAPPER = new RowMapper<Passwords>() {
        @Override
        public Passwords mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Passwords(resultSet.getInt("userid"), resultSet.getString("login"),
                        resultSet.getString("password"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };
    @Override
    public void addKey(Passwords keys) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userid", "login", "password"),
                asList(keys.getUserId(), keys.getLogin(), keys.getPassword()));
        sqlQueryExecutor.updateQuery(SQL_INSERT_PASSWORDS_INTO_PASSWORDS, paramMap);


    }

    @Override
    public Passwords getKeys(int userid) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userid"), asList(userid));
        return sqlQueryExecutor.queryForObject(SQL_GET_PASSWORD_INFO_FROM_PASSWORDSS,paramMap,PASSWORDS_ROW_MAPPER);
    }
}
