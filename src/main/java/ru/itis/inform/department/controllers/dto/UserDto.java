package ru.itis.inform.department.controllers.dto;

import ru.itis.inform.department.dao.models.Passwords;
import ru.itis.inform.department.dao.models.User;

/**
 * Created by Moskieva on 20.04.16.
 */
public class UserDto {
    private int id;
    private String userName;
    private String email;
    private String city;
    private String age;
    private String gender;
    private String passportData;
    private int snils;
    private String login;
    private String password;

    public UserDto(){

    }

    public UserDto (User user, Passwords passwords){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.city = user.getCity();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.passportData = user.getPassportData();
        this.password = passwords.getPassword();
        this.login = passwords.getLogin();
        this.snils = user.getSnils();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public int getSnils() {
        return snils;
    }

    public void setSnils(int snils) {
        this.snils = snils;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
