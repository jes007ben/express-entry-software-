package com.hylston.eecalculator.model.response;

public class ProfileResponse {

    private String name;

    private Integer scoreAge;

    private Integer scoreLevelEducation;

    private Integer scoreStudyInCanadaSecA;

    private Integer scoreOfficialLanguages;

    private Integer scoreFirstOfficialLanguage;

    private Integer scoreSecondOfficialLanguage;

    private Integer scoreCanadianWorkExperience;

    private Integer subTotalSectionA;

    private static final Integer MAX_SCORE_SECTION_A_IF_SINGLE = 500;

    private static final Integer MAX_SCORE_SECTION_A_IF_MARRIED = 460;

    private Integer scoreLevelEducationSpouse;

    private Integer scoreOfficialLanguageSpouse;

    private Integer scoreCanadianWorkExperienceSpouse;

    private Integer subTotalSectionB;

    private static final Integer MAX_SCORE_SECTION_B = 40;

    private Integer scoreOfficialLanguageAndEducation;

    private Integer scoreCanadianWorkExperienceAndEducation;

    private Integer scoreOfficialLanguageAndForeignWorkExperience;

    private Integer scoreCanadianAndForeignWorkExperience;

    private Integer scoreCertificateOfQualification;

    private Integer subTotalSectionC;

    private static final Integer MAX_SCORE_SECTION_C = 100;

    private Integer scoreProvincialNomination;

    private Integer scoreJobOffer;

    private Integer scoreStudyInCanadaSecD;

    private Integer scoreSiblingInCanada;

    private Integer scoreFrenchLanguage;

    private Integer subTotalSectionD;

    private Integer totalScore;

    private static final Integer MAX_SCORE_SECTION_D = 600;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScoreAge() {
        return scoreAge;
    }

    public void setScoreAge(Integer scoreAge) {
        this.scoreAge = scoreAge;
    }

    public Integer getScoreLevelEducation() {
        return scoreLevelEducation;
    }

    public void setScoreLevelEducation(Integer scoreLevelEducation) {
        this.scoreLevelEducation = scoreLevelEducation;
    }

    public Integer getScoreStudyInCanadaSecA() {
        return scoreStudyInCanadaSecA;
    }

    public void setScoreStudyInCanadaSecA(Integer scoreStudyInCanadaSecA) {
        this.scoreStudyInCanadaSecA = scoreStudyInCanadaSecA;
    }

    public Integer getScoreOfficialLanguages() {
        return scoreOfficialLanguages;
    }

    public void setScoreOfficialLanguages(Integer scoreOfficialLanguages) {
        this.scoreOfficialLanguages = scoreOfficialLanguages;
    }

    public Integer getScoreFirstOfficialLanguage() {
        return scoreFirstOfficialLanguage;
    }

    public void setScoreFirstOfficialLanguage(Integer scoreFirstOfficialLanguage) {
        this.scoreFirstOfficialLanguage = scoreFirstOfficialLanguage;
    }

    public Integer getScoreSecondOfficialLanguage() {
        return scoreSecondOfficialLanguage;
    }

    public void setScoreSecondOfficialLanguage(Integer scoreSecondOfficialLanguage) {
        this.scoreSecondOfficialLanguage = scoreSecondOfficialLanguage;
    }

    public Integer getScoreCanadianWorkExperience() {
        return scoreCanadianWorkExperience;
    }

    public void setScoreCanadianWorkExperience(Integer scoreCanadianWorkExperience) {
        this.scoreCanadianWorkExperience = scoreCanadianWorkExperience;
    }

    public Integer getSubTotalSectionA() {
        return subTotalSectionA;
    }

    public void setSubTotalSectionA(Integer subTotalSectionA) {
        this.subTotalSectionA = subTotalSectionA;
    }

    public static Integer getMaxScoreSectionAIfSingle() {
        return MAX_SCORE_SECTION_A_IF_SINGLE;
    }

    public static Integer getMaxScoreSectionAIfMarried() {
        return MAX_SCORE_SECTION_A_IF_MARRIED;
    }

    public Integer getScoreLevelEducationSpouse() {
        return scoreLevelEducationSpouse;
    }

    public void setScoreLevelEducationSpouse(Integer scoreLevelEducationSpouse) {
        this.scoreLevelEducationSpouse = scoreLevelEducationSpouse;
    }

    public Integer getScoreOfficialLanguageSpouse() {
        return scoreOfficialLanguageSpouse;
    }

    public void setScoreOfficialLanguageSpouse(Integer scoreOfficialLanguageSpouse) {
        this.scoreOfficialLanguageSpouse = scoreOfficialLanguageSpouse;
    }

    public Integer getScoreCanadianWorkExperienceSpouse() {
        return scoreCanadianWorkExperienceSpouse;
    }

    public void setScoreCanadianWorkExperienceSpouse(Integer scoreCanadianWorkExperienceSpouse) {
        this.scoreCanadianWorkExperienceSpouse = scoreCanadianWorkExperienceSpouse;
    }

    public Integer getSubTotalSectionB() {
        return subTotalSectionB;
    }

    public void setSubTotalSectionB(Integer subTotalSectionB) {
        this.subTotalSectionB = subTotalSectionB;
    }

    public static Integer getMaxScoreSectionB() {
        return MAX_SCORE_SECTION_B;
    }

    public Integer getScoreOfficialLanguageAndEducation() {
        return scoreOfficialLanguageAndEducation;
    }

    public void setScoreOfficialLanguageAndEducation(Integer scoreOfficialLanguageAndEducation) {
        this.scoreOfficialLanguageAndEducation = scoreOfficialLanguageAndEducation;
    }

    public Integer getScoreCanadianWorkExperienceAndEducation() {
        return scoreCanadianWorkExperienceAndEducation;
    }

    public void setScoreCanadianWorkExperienceAndEducation(Integer scoreCanadianWorkExperienceAndEducation) {
        this.scoreCanadianWorkExperienceAndEducation = scoreCanadianWorkExperienceAndEducation;
    }

    public Integer getScoreOfficialLanguageAndForeignWorkExperience() {
        return scoreOfficialLanguageAndForeignWorkExperience;
    }

    public void setScoreOfficialLanguageAndForeignWorkExperience(Integer scoreOfficialLanguageAndForeignWorkExperience) {
        this.scoreOfficialLanguageAndForeignWorkExperience = scoreOfficialLanguageAndForeignWorkExperience;
    }

    public Integer getScoreCanadianAndForeignWorkExperience() {
        return scoreCanadianAndForeignWorkExperience;
    }

    public void setScoreCanadianAndForeignWorkExperience(Integer scoreCanadianAndForeignWorkExperience) {
        this.scoreCanadianAndForeignWorkExperience = scoreCanadianAndForeignWorkExperience;
    }

    public Integer getScoreCertificateOfQualification() {
        return scoreCertificateOfQualification;
    }

    public void setScoreCertificateOfQualification(Integer scoreCertificateOfQualification) {
        this.scoreCertificateOfQualification = scoreCertificateOfQualification;
    }

    public Integer getSubTotalSectionC() {
        return subTotalSectionC;
    }

    public void setSubTotalSectionC(Integer subTotalSectionC) {
        this.subTotalSectionC = subTotalSectionC;
    }

    public static Integer getMaxScoreSectionC() {
        return MAX_SCORE_SECTION_C;
    }

    public Integer getScoreProvincialNomination() {
        return scoreProvincialNomination;
    }

    public void setScoreProvincialNomination(Integer scoreProvincialNomination) {
        this.scoreProvincialNomination = scoreProvincialNomination;
    }

    public Integer getScoreJobOffer() {
        return scoreJobOffer;
    }

    public void setScoreJobOffer(Integer scoreJobOffer) {
        this.scoreJobOffer = scoreJobOffer;
    }

    public Integer getScoreStudyInCanadaSecD() {
        return scoreStudyInCanadaSecD;
    }

    public void setScoreStudyInCanadaSecD(Integer scoreStudyInCanadaSecD) {
        this.scoreStudyInCanadaSecD = scoreStudyInCanadaSecD;
    }

    public Integer getScoreSiblingInCanada() {
        return scoreSiblingInCanada;
    }

    public void setScoreSiblingInCanada(Integer scoreSiblingInCanada) {
        this.scoreSiblingInCanada = scoreSiblingInCanada;
    }

    public Integer getScoreFrenchLanguage() {
        return scoreFrenchLanguage;
    }

    public void setScoreFrenchLanguage(Integer scoreFrenchLanguage) {
        this.scoreFrenchLanguage = scoreFrenchLanguage;
    }

    public Integer getSubTotalSectionD() {
        return subTotalSectionD;
    }

    public void setSubTotalSectionD(Integer subTotalSectionD) {
        this.subTotalSectionD = subTotalSectionD;
    }

    public static Integer getMaxScoreSectionD() {
        return MAX_SCORE_SECTION_D;
    }

    public Integer getTotalScore() {

        totalScore = this.getSubTotalSectionA() == null? 0 : this.getSubTotalSectionA();
        totalScore += this.getSubTotalSectionB() == null? 0 : this.getSubTotalSectionB();
        totalScore += this.getSubTotalSectionC() == null? 0 : this.getSubTotalSectionC();
        totalScore += this.getSubTotalSectionD() == null? 0 : this.getSubTotalSectionD();

        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
