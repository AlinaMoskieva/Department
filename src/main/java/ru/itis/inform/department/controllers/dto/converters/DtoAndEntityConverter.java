package ru.itis.inform.department.controllers.dto.converters;

import ru.itis.inform.department.controllers.dto.*;
import ru.itis.inform.department.dao.models.*;

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
    PasswordDto getPasswordDto(Passwords entity);
    TokenDto getTokenDto(Tokens entity);
    //из dto модель
    Map<String, Integer> getIdsAsIntegerMap(); //  авторизационный токкен
    Document getDocumentDao(DocumentDto dto);
    Participants getParticipantDao(ParticipantDto dto);
    User getUserDao (UserDto dto);
    Passwords getPasswordDao(PasswordDto dto);
    Tokens getTokensDto(TokenDto dto);
}
