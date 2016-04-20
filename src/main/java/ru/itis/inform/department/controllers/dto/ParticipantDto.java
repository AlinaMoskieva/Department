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
    private String positionAtWork;


    public ParticipantDto(Participants participants){
        this.id = participants.getId();
        this.documentId = participants.getDocumentId();
        this.fullName = participants.getFullName();
        this.education = participants.getEducation();
        this.placeOfWork = participants.getPlaceOfWork();
        this.positionAtWork = participants.getPositionAtWork();
    }

    public String getPositionAtWork() {
        return positionAtWork;
    }

    public void setPositionAtWork(String positionAtWork) {
        this.positionAtWork = positionAtWork;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }
}
