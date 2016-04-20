package ru.itis.inform.department.controllers.dto;

import ru.itis.inform.department.dao.models.Participants;

/**
 * Created by Moskieva on 20.04.16.
 */
public class ParticipantDto {
    private int id;
    private int documentId;
    private String fullName;
    private String education;
    private String placeOfWork;


    public ParticipantDto(Participants participants){
        this.id = participants.getId();
        this.documentId = participants.getDocumentId();
        this.fullName = participants.getFullName();
        this.education = participants.getEducation();
        this.placeOfWork = participants.getPlaceOfWork();
    }
}
