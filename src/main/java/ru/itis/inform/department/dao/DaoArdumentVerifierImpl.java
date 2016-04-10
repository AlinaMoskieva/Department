package ru.itis.inform.department.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Moskieva on 09.04.16.
 */
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



    @Override
    public void verifyUser(int userId) {

    }

    @Override
    public void verifyDocument(int documentId) {

    }

    @Override
    public void verifyParticipants(int participantId) {

    }
}
