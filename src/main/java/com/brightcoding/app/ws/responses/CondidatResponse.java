package com.brightcoding.app.ws.responses;

import com.brightcoding.app.ws.entities.*;
import com.brightcoding.app.ws.shared.dto.*;

import java.util.Date;
import java.util.List;

public class CondidatResponse {
    private long id;

    private String firstName;

    private String phone;

    private String lastName;

    private String gender;

    private Date date_birthday;

    private String nationality;

    private AuthProvider authProvider;


    private String userId;

    private String familyPhone ;

    private String email;

    private Role role;

    private String resetToken;

    private String encryptedPassword;


    private String photo;

    private   Application application;

    private List<EducationDto> education;

    private List<ExperienceDto> experience;

    private List<SkillsDto> skills;

    List<CondidatOffreDto> condidatoffre;


    private List<QuestionDto> question;

    private List<DocumentDto> document;

    private List<Hobbies> hobbies ;




    public long getId() {
        return id;
    }


    public List<ExperienceDto> getExperience() {
        return experience;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public List<CondidatOffreDto> getCondidatoffre() {
        return condidatoffre;
    }

    public void setCondidatoffre(List<CondidatOffreDto> condidatoffre) {
        this.condidatoffre = condidatoffre;
    }

    public void setExperience(List<ExperienceDto> experience) {
        this.experience = experience;
    }

    public List<SkillsDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsDto> skills) {
        this.skills = skills;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public List<QuestionDto> getQuestion() {
        return question;
    }

    public void setQuestion(List<QuestionDto> question) {
        this.question = question;
    }

    public List<DocumentDto> getDocument() {
        return document;
    }

    public void setDocument(List<DocumentDto> document) {
        this.document = document;
    }




    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<EducationDto> getEducation() {
        return education;
    }

    public void setEducation(List<EducationDto> education) {
        this.education = education;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDate_birthday() {
        return date_birthday;
    }
    public void setDate_birthday(Date date_birthday) {
        this.date_birthday = date_birthday;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public void setId(long id) {
        this.id = id;
    }



    public AuthProvider getAuthProvider() {
        return authProvider;
    }


    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }


}
