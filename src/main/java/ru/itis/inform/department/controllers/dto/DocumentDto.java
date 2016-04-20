package ru.itis.inform.department.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import ru.itis.inform.department.dao.models.Document;

/**
 * Created by Moskieva on 19.04.16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentDto{

    private int id;
    private int userId;
    private String denominationOfApplicant; // наименование заявителя
    private String legalStatusOfTheApplicant; // правовой статус заявителя)
    private String theTypeLaborArbitrators; //Вид подготовки трудовых арбитров
    private String formOfThePreparationOfLaborArbitrators; // форма подготовки трудовых арбитров
    private String timeOfThePreparationOfLaborArbitrators; // Время прохождения подготовки трудовых арбитров
    private String preferredLocation; // место прохождения подготовки
    private String mailingAddressOfTheApplicant; // Почтовый адрес заявителя
    private String contactPhoneNumbers;// Контактный телефоны
    private String emailAddress; //  адрес электронной почты заявителя
    private String positionApplicant;//Должность представителя заявителя
    private String fullName; //
    private String date;

    public DocumentDto(Document document){
        this.id = document.getId();
        this.userId = document.getUserId();
        this.denominationOfApplicant = document.getDenominationOfApplicant();
        this.legalStatusOfTheApplicant = document.getLegalStatusOfTheApplicant();
        this.theTypeLaborArbitrators = document.getTheTypeLaborArbitrators();
        this.formOfThePreparationOfLaborArbitrators = document.getFormOfThePreparationOfLaborArbitrators();
        this.timeOfThePreparationOfLaborArbitrators = document.getTimeOfThePreparationOfLaborArbitrators();
        this.preferredLocation = document.getPreferredLocation();
        this.mailingAddressOfTheApplicant = document.getMailingAddressOfTheApplicant();
        this.contactPhoneNumbers = document.getContactPhoneNumbers();
        this.emailAddress = document.getEmailAddress();
        this.positionApplicant = document.getPositionApplicant();
        this.fullName = document.getFullName();
        this.date = document.getFullName();

    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDenominationOfApplicant() {
        return denominationOfApplicant;
    }

    public String getLegalStatusOfTheApplicant() {
        return legalStatusOfTheApplicant;
    }

    public String getFormOfThePreparationOfLaborArbitrators() {
        return formOfThePreparationOfLaborArbitrators;
    }

    public String getTheTypeLaborArbitrators() {
        return theTypeLaborArbitrators;
    }

    public String getTimeOfThePreparationOfLaborArbitrators() {
        return timeOfThePreparationOfLaborArbitrators;
    }

    public String getMailingAddressOfTheApplicant() {
        return mailingAddressOfTheApplicant;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public String getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }

    public String getPositionApplicant() {
        return positionApplicant;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDate() {
        return date;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}