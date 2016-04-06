package ru.itis.inform.department.dao;

import ru.itis.inform.department.dao.models.Participants;

import java.util.List;

/**
 * Created by Moskieva on 06.04.16.
 */
public interface ParticipantsDao {
    /**
     * добавление участника в приложение к документу
     * @param userId id пользователя
     * @param documentId id документа
     */
    void newListOfParticipants(int userId, int documentId);

    /**
     * получение всех участников
     * @param documentId id пользователя
     * @return лист участников
     */
    List<Participants> getListOfParticipant(int documentId);


    /**
     * удаление участника
     * @param participantsId id участника
     */
    void removeParticipants(int participantsId);

}
