package ru.itis.inform.department.controllers.dto.converters;

import ru.itis.inform.department.controllers.dto.DocumentDto;
import ru.itis.inform.department.controllers.dto.DocumentsDto;
import ru.itis.inform.department.controllers.dto.ParticipantsDto;
import ru.itis.inform.department.dao.models.Document;
import ru.itis.inform.department.dao.models.Participants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Moskieva on 19.04.16.
 */
public class DtoAndEntityConverterImpl implements DtoAndEntityConverter {
    @Override
    public DocumentDto fromDocument(Document entity) {
        DocumentDto documentDto = new DocumentDto();
        Map<String, Object> adapters = new HashMap<String, Object>();

        return documentDto;
    }

    @Override
    public DocumentsDto fromDocuments(List<Document> entities) {
        return null;
    }

    @Override
    public ParticipantsDto fromParticipants(List<Participants> entities) {
        return null;
    }

    @Override
    public Map<String, Integer> getIdsAsIntegerMap() {
        return null;
    }
}
