package ru.itis.inform.department.dao.models;

/**
 * Created by Moskieva on 29.03.16.
 */
public class Document {
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

    public String getTheTypeLaborArbitrators() {
        return theTypeLaborArbitrators;
    }

    public String getFormOfThePreparationOfLaborArbitrators() {
        return formOfThePreparationOfLaborArbitrators;
    }

    public String getTimeOfThePreparationOfLaborArbitrators() {
        return timeOfThePreparationOfLaborArbitrators;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public String getMailingAddressOfTheApplicant() {
        return mailingAddressOfTheApplicant;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContactPhoneNumbers() {
        return contactPhoneNumbers;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPositionApplicant() {
        return positionApplicant;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDenominationOfApplicant(String denominationOfApplicant) {
        this.denominationOfApplicant = denominationOfApplicant;
    }

    public void setLegalStatusOfTheApplicant(String legalStatusOfTheApplicant) {
        this.legalStatusOfTheApplicant = legalStatusOfTheApplicant;
    }

    public void setTheTypeLaborArbitrators(String theTypeLaborArbitrators) {
        this.theTypeLaborArbitrators = theTypeLaborArbitrators;
    }

    public void setFormOfThePreparationOfLaborArbitrators(String formOfThePreparationOfLaborArbitrators) {
        this.formOfThePreparationOfLaborArbitrators = formOfThePreparationOfLaborArbitrators;
    }

    public void setTimeOfThePreparationOfLaborArbitrators(String timeOfThePreparationOfLaborArbitrators) {
        this.timeOfThePreparationOfLaborArbitrators = timeOfThePreparationOfLaborArbitrators;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public void setMailingAddressOfTheApplicant(String mailingAddressOfTheApplicant) {
        this.mailingAddressOfTheApplicant = mailingAddressOfTheApplicant;
    }

    public void setContactPhoneNumbers(String contactPhoneNumbers) {
        this.contactPhoneNumbers = contactPhoneNumbers;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPositionApplicant(String positionApplicant) {
        this.positionApplicant = positionApplicant;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", userId=" + userId +
                ", denominationOfApplicant='" + denominationOfApplicant + '\'' +
                ", legalStatusOfTheApplicant='" + legalStatusOfTheApplicant + '\'' +
                ", theTypeLaborArbitrators='" + theTypeLaborArbitrators + '\'' +
                ", formOfThePreparationOfLaborArbitrators='" + formOfThePreparationOfLaborArbitrators + '\'' +
                ", timeOfThePreparationOfLaborArbitrators='" + timeOfThePreparationOfLaborArbitrators + '\'' +
                ", preferredLocation='" + preferredLocation + '\'' +
                ", mailingAddressOfTheApplicant='" + mailingAddressOfTheApplicant + '\'' +
                ", contactPhoneNumbers='" + contactPhoneNumbers + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", positionApplicant='" + positionApplicant + '\'' +
                ", fullName='" + fullName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
