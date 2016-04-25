package ru.itis.inform.department.services;


import ru.itis.inform.department.dao.models.Participants;

import java.util.List;

public interface ParticipantService {
    /**
     * получение списка участников
     * @param documentId
     */
    List<Participants> getListOfPArticipants(int documentId);
    void addParticipants(Participants participants);
}
