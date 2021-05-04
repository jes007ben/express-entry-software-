package com.hylston.eecalculator.model;

import com.hylston.eecalculator.enums.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Transient
    private AgeFactorEnum age;

    private boolean spouseWillApplyTogether;

    private boolean certificateOfQualification;

    @Enumerated(EnumType.STRING)
    private EducationFactorEnum education;

    @Enumerated(EnumType.STRING)
    private AdditionalPointsFactorEnum educationInCanada;

    @Enumerated(EnumType.STRING)
    private LanguageTestTypeEnum firstLanguageTest;

    @Enumerated(EnumType.STRING)
    private LanguageTestTypeEnum secondLanguageTest;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum firstLangTestSpeakingScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum firstLangTestListeningScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum firstLangTestReadingScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum firstLangTestWritingScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum secondLangTestSpeakingScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum secondLangTestListeningScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum secondLangTestReadingScore;

    @Enumerated(EnumType.STRING)
    private LanguageFactorEnum secondLangTestWritingScore;

    @Enumerated(EnumType.STRING)
    private ForeignWorkExpFactorEnum foreignWorkExp;

    @Enumerated(EnumType.STRING)
    private CanadianWorkExpFactorEnum canadianWorkExp;

    @Enumerated(EnumType.STRING)
    private ArrangedEmploymentFactorEnum arrangedEmployment;

    @Enumerated(EnumType.STRING)
    private AdditionalPointsFactorEnum provinceNomination;

    @Enumerated(EnumType.STRING)
    private AdditionalPointsFactorEnum siblingWhoIsPr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public AgeFactorEnum getAge() {
        return age;
    }

    public void setAge(AgeFactorEnum age) {
        this.age = age;
    }

    public EducationFactorEnum getEducation() {
        return education;
    }

    public void setEducation(EducationFactorEnum education) {
        this.education = education;
    }


    public boolean isSpouseWillApplyTogether() {
        return spouseWillApplyTogether;
    }

    public void setSpouseWillApplyTogether(boolean spouseWillApplyTogether) {
        this.spouseWillApplyTogether = spouseWillApplyTogether;
    }

    public boolean isCertificateOfQualification() {
        return certificateOfQualification;
    }

    public void setCertificateOfQualification(boolean certificateOfQualification) {
        this.certificateOfQualification = certificateOfQualification;
    }

    public AdditionalPointsFactorEnum getEducationInCanada() {
        return educationInCanada;
    }

    public void setEducationInCanada(AdditionalPointsFactorEnum educationInCanada) {
        this.educationInCanada = educationInCanada;
    }

    public LanguageTestTypeEnum getFirstLanguageTest() {
        return firstLanguageTest;
    }

    public void setFirstLanguageTest(LanguageTestTypeEnum firstLanguageTest) {
        this.firstLanguageTest = firstLanguageTest;
    }

    public LanguageTestTypeEnum getSecondLanguageTest() {
        return secondLanguageTest;
    }

    public void setSecondLanguageTest(LanguageTestTypeEnum secondLanguageTest) {
        this.secondLanguageTest = secondLanguageTest;
    }

    public LanguageFactorEnum getFirstLangTestSpeakingScore() {
        return firstLangTestSpeakingScore;
    }

    public void setFirstLangTestSpeakingScore(LanguageFactorEnum firstLangTestSpeakingScore) {
        this.firstLangTestSpeakingScore = firstLangTestSpeakingScore;
    }

    public LanguageFactorEnum getFirstLangTestListeningScore() {
        return firstLangTestListeningScore;
    }

    public void setFirstLangTestListeningScore(LanguageFactorEnum firstLangTestListeningScore) {
        this.firstLangTestListeningScore = firstLangTestListeningScore;
    }

    public LanguageFactorEnum getFirstLangTestReadingScore() {
        return firstLangTestReadingScore;
    }

    public void setFirstLangTestReadingScore(LanguageFactorEnum firstLangTestReadingScore) {
        this.firstLangTestReadingScore = firstLangTestReadingScore;
    }

    public LanguageFactorEnum getFirstLangTestWritingScore() {
        return firstLangTestWritingScore;
    }

    public void setFirstLangTestWritingScore(LanguageFactorEnum firstLangTestWritingScore) {
        this.firstLangTestWritingScore = firstLangTestWritingScore;
    }

    public LanguageFactorEnum getSecondLangTestSpeakingScore() {
        return secondLangTestSpeakingScore;
    }

    public void setSecondLangTestSpeakingScore(LanguageFactorEnum secondLangTestSpeakingScore) {
        this.secondLangTestSpeakingScore = secondLangTestSpeakingScore;
    }

    public LanguageFactorEnum getSecondLangTestListeningScore() {
        return secondLangTestListeningScore;
    }

    public void setSecondLangTestListeningScore(LanguageFactorEnum secondLangTestListeningScore) {
        this.secondLangTestListeningScore = secondLangTestListeningScore;
    }

    public LanguageFactorEnum getSecondLangTestReadingScore() {
        return secondLangTestReadingScore;
    }

    public void setSecondLangTestReadingScore(LanguageFactorEnum secondLangTestReadingScore) {
        this.secondLangTestReadingScore = secondLangTestReadingScore;
    }

    public LanguageFactorEnum getSecondLangTestWritingScore() {
        return secondLangTestWritingScore;
    }

    public void setSecondLangTestWritingScore(LanguageFactorEnum secondLangTestWritingScore) {
        this.secondLangTestWritingScore = secondLangTestWritingScore;
    }

    public ForeignWorkExpFactorEnum getForeignWorkExp() {
        return foreignWorkExp;
    }

    public void setForeignWorkExp(ForeignWorkExpFactorEnum foreignWorkExp) {
        this.foreignWorkExp = foreignWorkExp;
    }

    public CanadianWorkExpFactorEnum getCanadianWorkExp() {
        return canadianWorkExp;
    }

    public void setCanadianWorkExp(CanadianWorkExpFactorEnum canadianWorkExp) {
        this.canadianWorkExp = canadianWorkExp;
    }

    public ArrangedEmploymentFactorEnum getArrangedEmployment() {
        return arrangedEmployment;
    }

    public void setArrangedEmployment(ArrangedEmploymentFactorEnum arrangedEmployment) {
        this.arrangedEmployment = arrangedEmployment;
    }

    public AdditionalPointsFactorEnum getProvinceNomination() {
        return provinceNomination;
    }

    public void setProvinceNomination(AdditionalPointsFactorEnum provinceNomination) {
        this.provinceNomination = provinceNomination;
    }

    public AdditionalPointsFactorEnum getSiblingWhoIsPr() {
        return siblingWhoIsPr;
    }

    public void setSiblingWhoIsPr(AdditionalPointsFactorEnum siblingWhoIsPr) {
        this.siblingWhoIsPr = siblingWhoIsPr;
    }
}
