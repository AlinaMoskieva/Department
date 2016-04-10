package ru.itis.inform.department.dao;

/**
 * Created by Moskieva on 09.04.16.
 */
public interface DaoArgumentsVerifier {
    void verifyUser(int userId);
    void verifyDocument(int documentId);
    void verifyParticipants(int participantId);
}
