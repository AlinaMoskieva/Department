package ru.itis.inform.department.dao.participants;

import ru.itis.inform.department.dao.models.Participants;

import java.util.List;

/**
 * Created by Moskieva on 06.04.16.
 */
public interface ParticipantsDao {

     void newParticipant(Participants participants);

    /**
     * получение всех участников
     * @param documentId id пользователя
     * @return лист участников
     */
    List<Participants> getListOfParticipant(int documentId);

}
