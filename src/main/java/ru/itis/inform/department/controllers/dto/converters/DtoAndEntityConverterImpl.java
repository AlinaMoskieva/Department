package ru.itis.inform.department.controllers.dto.converters;

import org.springframework.stereotype.Component;
import ru.itis.inform.department.controllers.dto.*;
import ru.itis.inform.department.dao.models.*;
import sun.security.util.Password;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Moskieva on 19.04.16.
 */
@Component
public class DtoAndEntityConverterImpl implements DtoAndEntityConverter {

    @Override
    public DocumentDto getDocumentDto(Document entity) {
        DocumentDto dto = new DocumentDto(entity);
        return dto;
    }

    @Override
    public DocumentsDto getDocumentsDto(List<Document> entities) {
        DocumentsDto dto = new DocumentsDto();
        dto.setListDocuments(entities);
        return dto;
    }

    @Override
    public ParticipantsDto getParticipantsDto(List<Participants> entities) {
        ParticipantsDto dto = new ParticipantsDto();
        dto.setListParticipants(entities);
        return dto;
    }

    @Override
    public PasswordDto getPasswordDto(Passwords entity) {
        PasswordDto dto = new PasswordDto(entity);
        return dto;
    }

    @Override
    public TokenDto getTokenDto(Tokens entity) {
        TokenDto dto = new TokenDto(entity);
        return dto;
    }

    @Override
    public Map<String, Integer> getIdsAsIntegerMap() {
        return null;
    }

    @Override
    public Document getDocumentDao(DocumentDto dto) {
        Document document = new Document(dto.getId(), dto.getUserId(), dto.getDenominationOfApplicant(),
                dto.getLegalStatusOfTheApplicant(), dto.getTheTypeLaborArbitrators(),
                dto.getFormOfThePreparationOfLaborArbitrators(), dto.getTimeOfThePreparationOfLaborArbitrators(),
                dto.getPreferredLocation(), dto.getMailingAddressOfTheApplicant(), dto.getContactPhoneNumbers(),
                dto.getEmailAddress(), dto.getPositionApplicant(), dto.getFullName(), dto.getDate());
        return document;
    }

    @Override
    public Participants getParticipantDao(ParticipantDto dto) {
        Participants participants = new Participants(dto.getId(),dto.getDocumentId(), dto.getFullName(),
                dto.getEducation(), dto.getPlaceOfWork(), dto.getPositionAtWork());
        return participants;
    }

    @Override
    public User getUserDao(UserDto dto) {
        User user = new User(dto.getId(), dto.getUserName(), dto.getEmail(), dto.getCity(), dto.getAge(), dto.getGender(),
                dto.getPassportData(), dto.getSnils());
        return user;
    }

    @Override
    public Passwords getPasswordDao(PasswordDto dto) {
        Passwords password = new Passwords(dto.getUserId(), dto.getLogin(), dto.getPassword());
        return password;
    }

    @Override
    public Tokens getTokensDto(TokenDto dto) {
        Tokens token = new Tokens(dto.getUserId(), dto.getToken());
        return token;
    }
}
