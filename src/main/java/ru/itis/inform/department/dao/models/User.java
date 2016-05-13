package ru.itis.inform.department.dao.models;

import java.util.Objects;


/**
 * Created by Moskieva on 29.03.16.
 */
public class User {
    private int id;
    private String userName;
    private String email;
    private String city;
    private String age;
    private String gender;
    private String passportData;
    private String snils;

    public User(int id, String userName, String email, String city, String age, String gender, String passportData, String snils) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.passportData = passportData;
        this.snils = snils;
    }




    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPassportData() {
        return passportData;
    }

    public String getSnils() {
        return snils;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        User that = (User) obj;
        return Objects.equals(this.getUserName(), that.getUserName()) &&
                Objects.equals(this.getEmail(), that.getEmail()) &&
                Objects.equals(this.getAge(), that.getAge()) &&
                Objects.equals(this.getCity(), that.getCity()) &&
                Objects.equals(this.getGender(), that.getGender()) &&
                Objects.equals(this.getPassportData(), that.getPassportData()) &&
                Objects.equals(this.getSnils(), that.getSnils());

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUserName(), this.getAge(),
                this.getCity(), this.getEmail(), this.getGender(),
                this.getPassportData(), this.getSnils());
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", passportData='" + passportData + '\'' +
                ", snils=" + snils +
                '}';
    }
}