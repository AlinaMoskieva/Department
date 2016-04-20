package ru.itis.inform.department.controllers.dto.converters;

import ru.itis.inform.department.controllers.dto.DocumentDto;
import ru.itis.inform.department.controllers.dto.DocumentsDto;
import ru.itis.inform.department.controllers.dto.ParticipantsDto;
import ru.itis.inform.department.dao.models.Document;
import ru.itis.inform.department.dao.models.Participants;

import java.util.List;
import java.util.Map;

/**
 * Created by Moskieva on 19.04.16.
 */
public interface DtoAndEntityConverter {
    // из модели делаем dto
    DocumentDto fromDocument(Document entity);
    DocumentsDto fromDocuments(List<Document> entities);
    ParticipantsDto fromParticipants(List<Participants> entities);
    //из dto модель
    Map<String, Integer> getIdsAsIntegerMap(); //  авторизационный токкен
}
