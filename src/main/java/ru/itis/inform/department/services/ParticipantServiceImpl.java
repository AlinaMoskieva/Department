package ru.itis.inform.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.inform.department.dao.models.Participants;
import ru.itis.inform.department.dao.participants.ParticipantsDao;

import java.util.List;

/**
 * Created by Moskieva on 12.04.16.
 */
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantsDao participantsDao;

    @Override
    public List<Participants> getListOfPArticipants(int documentId) {
        return participantsDao.getListOfParticipant(documentId);
    }
}
