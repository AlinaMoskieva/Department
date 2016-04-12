package ru.itis.inform.department.dao.models;

import java.util.Objects;

/**
 * Created by Moskieva on 30.03.16.
 */
public class Participants {
    private int id;
    private int documentId;
    private String fullName;
    private String education;
    private String placeOfWork;

    public Participants(int id, int documentId, String fullName, String education, String placeOfWork, String positionAtWork) {
        this.id = id;
        this.documentId = documentId;
        this.fullName = fullName;
        this.education = education;
        this.placeOfWork = placeOfWork;
        this.positionAtWork = positionAtWork;
    }

    private String positionAtWork;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getEducation() {
        return education;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getPositionAtWork() {
        return positionAtWork;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public void setPositionAtWork(String positionAtWork) {
        this.positionAtWork = positionAtWork;
    }

    @Override
    public String toString() {
        return "Participants{" +
                "id=" + id +
                ", documentId=" + documentId +
                ", fullName='" + fullName + '\'' +
                ", education='" + education + '\'' +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", positionAtWork='" + positionAtWork + '\'' +
                '}';
    }

    @Override
    public  boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Participants that = (Participants) obj;
        return Objects.equals(this.getDocumentId(), that.getDocumentId()) &&
                Objects.equals(this.getEducation(), that.getEducation()) &&
                Objects.equals(this.getFullName(), that.getFullName()) &&
                Objects.equals(this.getPlaceOfWork(), that.getPlaceOfWork()) &&
                Objects.equals(this.getPositionAtWork(), that.getPositionAtWork());


    }
    @Override
    public int hashCode(){
        return Objects.hash(this.getDocumentId(), this.getEducation(),
                this.getFullName(), this.getPositionAtWork(),
                this.getId(), this.getPlaceOfWork());
    }
}
