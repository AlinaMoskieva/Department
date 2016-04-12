package ru.itis.inform.department.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.Exeptions.DocumentNotFoundExeption;
import ru.itis.inform.department.dao.Exeptions.ParticipantNotFoundExeption;
import ru.itis.inform.department.dao.Exeptions.UserNotFoundExeption;
import ru.itis.inform.department.dao.jdbc.ParamsMapper;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutor;

import java.util.Map;

import static java.util.Arrays.asList;


@Component
public class DaoArdumentVerifierImpl implements DaoArgumentsVerifier {
    //language=SQL
    private static final String SQL_COUNT_USER_BY_ID =
            "SELECT COUNT(*) FROM user WHERE (id = :userId)";
    //language=SQL
    private static final String SQL_COUNT_DOCUMENT_BY_ID =
            "SELECT COUNT(*) FROM document WHERE (id = :documentId)";
    //language=SQL
    private static final String SQL_COUNT_PARTICIPANTS_BY_ID =
            "SELECT COUNT(*) FROM user WHERE (id = :participantId)";

    @Autowired
    private SqlQueryExecutor sqlQueryExecutor;

    @Autowired
    private ParamsMapper paramsMapper;



    @Override
    public void verifyUser(int userId) {
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId"), asList(userId));
        int usersCount = sqlQueryExecutor.queryForInt(SQL_COUNT_USER_BY_ID, paramMap);
        if (usersCount != 1) {
            throw new UserNotFoundExeption(userId);
        }

    }

    @Override
    public void verifyDocument(int documentId) {
        Map<String, Object> paranMap = paramsMapper.asMap(asList("docuentId"), asList(documentId));
        int documentCount = sqlQueryExecutor.queryForInt(SQL_COUNT_DOCUMENT_BY_ID, paranMap);
        if (documentCount != 1){
            throw new DocumentNotFoundExeption(documentId);
        }

    }

    @Override
    public void verifyParticipants(int participantId) {
        Map<String, Object> paranMap = paramsMapper.asMap(asList("participantId"), asList(participantId));
        int participantCount = sqlQueryExecutor.queryForInt(SQL_COUNT_PARTICIPANTS_BY_ID, paranMap);
        if (participantCount != 1){
            throw new ParticipantNotFoundExeption(participantId);
        }


    }
}
