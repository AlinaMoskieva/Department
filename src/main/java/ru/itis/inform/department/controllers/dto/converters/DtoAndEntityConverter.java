package ru.itis.inform.department.controllers.dto.converters;

import ru.itis.inform.department.controllers.dto.*;
import ru.itis.inform.department.dao.models.Document;
import ru.itis.inform.department.dao.models.Participants;
import ru.itis.inform.department.dao.models.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Moskieva on 19.04.16.
 */
public interface DtoAndEntityConverter {
    // из модели делаем dto
    DocumentDto getDocumentDto(Document entity);
    DocumentsDto getDocumentsDto(List<Document> entities);
    ParticipantsDto getParticipantsDto(List<Participants> entities);
    //из dto модель
    Map<String, Integer> getIdsAsIntegerMap(); //  авторизационный токкен
    Document getDocumentDao(DocumentDto dto);
    Participants getParticipantDao(ParticipantDto dto);
    User getUserDao (UserDto dto);
}
