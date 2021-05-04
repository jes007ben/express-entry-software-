package com.hylston.eecalculator.service;

import com.hylston.eecalculator.enums.*;
import com.hylston.eecalculator.model.Profile;
import com.hylston.eecalculator.model.request.ProfileRequest;
import com.hylston.eecalculator.model.response.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class CalculatorService {

    @Autowired
    ProfileService profileService;

    public ProfileResponse calculateProfileScore(ProfileRequest profileRequest, boolean spouseIsMainApplicant){

        Profile p1;
        Profile p2 = null;

        if(profileRequest.getSpouseWillApply() == 1 && spouseIsMainApplicant){

            p2 = this.getProfileFromProfileView(profileRequest);

            p1 = this.getProfileSpouseFromProfileView(profileRequest);

        } else if (profileRequest.getSpouseWillApply() == 1){

             p1 = this.getProfileFromProfileView(profileRequest);

             p2 = this.getProfileSpouseFromProfileView(profileRequest);

        } else {
             p1 = this.getProfileFromProfileView(profileRequest);
        }

        profileService.save(p1);
        if (p2 != null){
            profileService.save(p2);
        }

        ProfileResponse profileResponse = this.calculateScore(p1, p2);

        if(profileRequest.getEmail() != null){
            this.sendEmail(profileRequest.getEmail(), profileResponse);
        }

        return profileResponse;

    }

    public void sendEmail(String destination, ProfileResponse profileResponse){

        if (destination != null) {

            String subject = "Express Entry Calculator - Score Result";

            String body = this.buildEmailBody(profileResponse);

            try {

                EmailService.sendEmail(destination, subject, body);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    private String buildEmailBody(ProfileResponse profileResponse){

        StringBuilder html = new StringBuilder();

        Integer totalSectionsABC = 0;

        totalSectionsABC += profileResponse.getSubTotalSectionA() != null ? profileResponse.getSubTotalSectionA() : 0;
        totalSectionsABC += profileResponse.getSubTotalSectionB() != null ? profileResponse.getSubTotalSectionB() : 0;
        totalSectionsABC += profileResponse.getSubTotalSectionC() != null ? profileResponse.getSubTotalSectionC() : 0;

        html.append("<h2>Your results</h2>");
        html.append("<div id=\"core_factors\">\n" +
                "                <h3><strong>Core/Human capital factors</strong></h3>");
        html.append("<li>Age = ");
        html.append(profileResponse.getScoreAge() == null? "0" : profileResponse.getScoreAge());
        html.append("</li><li>Level of education = ");
        html.append(profileResponse.getScoreLevelEducation() == null? "0" : profileResponse.getScoreLevelEducation());
        html.append("</li><li>Study in Canada = ");
        html.append(profileResponse.getScoreStudyInCanadaSecA() == null? "0" : profileResponse.getScoreStudyInCanadaSecA());
        html.append("</li><li>Official Languages = ");
        html.append(profileResponse.getScoreOfficialLanguages() == null? "0" : profileResponse.getScoreOfficialLanguages());
        html.append("<ul><li ><em>First Official Language</em> =");
        html.append(profileResponse.getScoreFirstOfficialLanguage() == null? "0" : profileResponse.getScoreFirstOfficialLanguage());
        html.append("</li><li><em>Second Official Language</em> =");
        html.append(profileResponse.getScoreSecondOfficialLanguage() == null? "0" : profileResponse.getScoreSecondOfficialLanguage());
        html.append("</li></ul></li><li>Canadian work experience =");
        html.append(profileResponse.getScoreCanadianWorkExperience() == null? "0" : profileResponse.getScoreCanadianWorkExperience());
        html.append("</li></ul><p><strong>Subtotal - Core/Human capital factors</strong> =");
        html.append(profileResponse.getSubTotalSectionA() == null? "0" : profileResponse.getSubTotalSectionA());
        html.append("</p></div><div id=\"spouse_factors\"><hr><h3>Spouse factors</h3><ul><li>Level of education =");
        html.append(profileResponse.getScoreLevelEducationSpouse() == null? "0" : profileResponse.getScoreLevelEducationSpouse());
        html.append("</li><li>First Official Languages =");
        html.append(profileResponse.getScoreOfficialLanguageSpouse() == null? "0" : profileResponse.getScoreOfficialLanguageSpouse());
        html.append("</li><li>Canadian work experience = ");
        html.append(profileResponse.getScoreCanadianWorkExperienceSpouse() == null? "0" : profileResponse.getScoreCanadianWorkExperienceSpouse());
        html.append("</li></ul><p><strong>Subtotal - Spouse factors</strong> = ");
        html.append(profileResponse.getSubTotalSectionB() == null? "0" : profileResponse.getSubTotalSectionB());
        html.append("</p></div><div><hr><h3>Skill transferability factors</h3><h4>Education</h4><ul><li>A) Official Language proficiency and education  =");
        html.append(profileResponse.getScoreOfficialLanguageAndEducation() == null? "0" : profileResponse.getScoreOfficialLanguageAndEducation());
        html.append("</li><li>B) Canadian work experience and education  = ");
        html.append(profileResponse.getScoreCanadianWorkExperienceAndEducation() == null? "0" : profileResponse.getScoreCanadianWorkExperienceAndEducation());
        html.append("</li><h4>Foreign work experience</h4><ul><li>A) Official Language proficiency and foreign work experience =");
        html.append(profileResponse.getScoreOfficialLanguageAndForeignWorkExperience() == null? "0" : profileResponse.getScoreOfficialLanguageAndForeignWorkExperience());
        html.append("</li><li>B) Canadian and foreign work experience = ");
        html.append(profileResponse.getScoreCanadianAndForeignWorkExperience() == null? "0" : profileResponse.getScoreCanadianAndForeignWorkExperience());
        html.append("</li><p><em>Certificate of qualification</em> = ");
        html.append(profileResponse.getScoreCertificateOfQualification() == null? "0" : profileResponse.getScoreCertificateOfQualification());
        html.append("</p></p></div><div></div><p><strong>Subtotal Skill transferability factors</strong> =");
        html.append(profileResponse.getSubTotalSectionC() == null? "0" : profileResponse.getSubTotalSectionC());
        html.append("<div><hr><p><strong>Subtotal Core/Human capital + Spouse factors + Skill transferability</strong> = ");
        html.append(totalSectionsABC);
        html.append("</p><p>Provincial nomination = ");
        html.append(profileResponse.getScoreProvincialNomination() == null? "0" : profileResponse.getScoreProvincialNomination());
        html.append("</p><p>Job offer = ");
        html.append(profileResponse.getScoreJobOffer() == null? "0" : profileResponse.getScoreJobOffer());
        html.append("</p><p>Study in Canada = ");
        html.append(profileResponse.getScoreStudyInCanadaSecD() == null? "0" : profileResponse.getScoreStudyInCanadaSecD());
        html.append("</p><p>Sibling in Canada = ");
        html.append(profileResponse.getScoreSiblingInCanada() == null? "0" : profileResponse.getScoreSiblingInCanada());
        html.append("</p><p>French-language skills = ");
        html.append(profileResponse.getScoreFrenchLanguage() == null? "0" : profileResponse.getScoreFrenchLanguage());
        html.append("</p><p><strong>Subtotal Additional points</strong> = ");
        html.append(profileResponse.getSubTotalSectionD() == null? "0" : profileResponse.getSubTotalSectionD());
        html.append("</p><p><strong>Grand total</strong> =");
        html.append(profileResponse.getTotalScore() == null? "0" : profileResponse.getTotalScore());
        html.append("</p></div>");

        return html.toString();

    }

    private ProfileResponse calculateScore(Profile profile, Profile profileSpouse){

        ProfileResponse profileResponse = new ProfileResponse();

        if(profileSpouse != null){

            profileResponse = this.calcScoreSectionAIfMarried(profile, profileResponse);


            System.out.println("Points section 1: " + profileResponse.getSubTotalSectionA());


            profileResponse = calcScoreSectionB(profileSpouse, profileResponse);


            System.out.println("Points section 2: " + profileResponse.getSubTotalSectionB());


            profileResponse = this.calcScoreSectionC(profile, profileResponse);


            System.out.println("Points section 3: " + profileResponse.getSubTotalSectionC());


            profileResponse = this.calcScoreSectionD(profile, profileResponse);


            System.out.println("Points section 4: " + profileResponse.getSubTotalSectionD());


        } else {

            profileResponse = this.calcScoreSectionA(profile, profileResponse);

            System.out.println("Points section 1: " + profileResponse.getSubTotalSectionA());

            profileResponse = this.calcScoreSectionC(profile, profileResponse);

            System.out.println("Points section 3: " + profileResponse.getSubTotalSectionB());

            profileResponse = this.calcScoreSectionD(profile, profileResponse);

            System.out.println("Points section 4: " + profileResponse.getSubTotalSectionC());

        }

        return profileResponse;
    }

    public Profile getProfileFromProfileView(ProfileRequest pv) {

        try {

            Profile profile = new Profile();

            if(pv.getSpouseWillApply() != null && pv.getSpouseWillApply() == 1){
                profile.setSpouseWillApplyTogether(true);
            }

            if (pv.getBirthDate() != null) {
                profile.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse(pv.getBirthDate()));
                profile.setAge(this.getAgeByBirthDate(profile.getBirthDate()));
            }
            if (pv.getCanadianWorkExp() != null) {
                profile.setCanadianWorkExp(CanadianWorkExpFactorEnum.getByIntValue(pv.getCanadianWorkExp()));
            }
            if (pv.getCertificateOfQualification() != null) {
                profile.setCertificateOfQualification(pv.getCertificateOfQualification() == 1);
            }
            if (pv.getEducation() != null) {
                profile.setEducation(EducationFactorEnum.getByIntValue(pv.getEducation()));
            }
            if (pv.getEducationInCanada() != null) {
                if(pv.getEducationInCanada() == 1) {
                    profile.setEducationInCanada(AdditionalPointsFactorEnum.ONE_OR_TWO_YEARS_PROGRAM_IN_CANADA);
                } else if (pv.getEducationInCanada() == 2){
                    profile.setEducationInCanada(AdditionalPointsFactorEnum.THREE_OR_MORE_YEARS_PROGRAM_IN_CANADA);
                }
            }
            if(pv.getFirstLanguageTest() != null){

                profile.setFirstLanguageTest(LanguageTestTypeEnum.getByIntValue(pv.getFirstLanguageTest()));

                if (pv.getFltListeningScore() != null) {
                    profile.setFirstLangTestListeningScore(LanguageFactorEnum.getByIntValue(pv.getFltListeningScore()));
                }
                if (pv.getFltReadingScore() != null) {
                    profile.setFirstLangTestReadingScore(LanguageFactorEnum.getByIntValue(pv.getFltReadingScore()));
                }
                if (pv.getFltSpeakingScore() != null) {
                    profile.setFirstLangTestSpeakingScore(LanguageFactorEnum.getByIntValue(pv.getFltSpeakingScore()));
                }
                if (pv.getFltWritingScore() != null) {
                    profile.setFirstLangTestWritingScore(LanguageFactorEnum.getByIntValue(pv.getFltWritingScore()));
                }
            }
            if (pv.getForeignWorkExp() != null) {
                profile.setForeignWorkExp(ForeignWorkExpFactorEnum.getByIntValue(pv.getForeignWorkExp()));
            }
            if (pv.getName() != null) {
                profile.setName(pv.getName());
            }
            if (pv.getProvinceNomination() != null && pv.getProvinceNomination() == 1) {
                profile.setProvinceNomination(AdditionalPointsFactorEnum.PROVINCIAL_NOMINATION);
            }
            if(pv.getSecondLanguageTest() != null){

                profile.setSecondLanguageTest(LanguageTestTypeEnum.getByIntValue(pv.getSecondLanguageTest()));

                if (pv.getSltListeningScore() != null) {
                    profile.setSecondLangTestListeningScore(LanguageFactorEnum.getByIntValue(pv.getSltListeningScore()));
                }
                if (pv.getSltReadingScore() != null) {
                    profile.setSecondLangTestReadingScore(LanguageFactorEnum.getByIntValue(pv.getSltReadingScore()));
                }
                if (pv.getSltSpeakingScore() != null) {
                    profile.setSecondLangTestSpeakingScore(LanguageFactorEnum.getByIntValue(pv.getSltSpeakingScore()));
                }
                if (pv.getSltWritingScore() != null) {
                    profile.setSecondLangTestWritingScore(LanguageFactorEnum.getByIntValue(pv.getSltWritingScore()));
                }
            }
            if (pv.getArrangedEmployment() != null) {
                profile.setArrangedEmployment(ArrangedEmploymentFactorEnum.getByIntValue(pv.getArrangedEmployment()));
            } else {
                profile.setArrangedEmployment(ArrangedEmploymentFactorEnum.NONE);
            }
            if(pv.getSiblingWhoIsPr() != null){
                profile.setSiblingWhoIsPr(AdditionalPointsFactorEnum.SIBLING_WHO_IS_PERMANENT_RESIDENT);
            }

            return profile;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public Profile getProfileSpouseFromProfileView(ProfileRequest pv) {

        try {

            Profile profileSpouse = new Profile();

            if(pv.getSpouseWillApply() != null && pv.getSpouseWillApply() == 1){
                profileSpouse.setSpouseWillApplyTogether(true);
            }

            if (pv.getName() != null) {
                profileSpouse.setName("Main candidate name: " + pv.getName());
            }

            if (pv.getBirthDateSpouse() != null) {
                profileSpouse.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse(pv.getBirthDateSpouse()));
                profileSpouse.setAge(this.getAgeByBirthDate(profileSpouse.getBirthDate()));
            }
            if (pv.getCanadianWorkExpSpouse() != null) {
                profileSpouse.setCanadianWorkExp(CanadianWorkExpFactorEnum.getByIntValue(pv.getCanadianWorkExpSpouse()));
            }
            if (pv.getCertificateOfQualificationSpouse() != null) {
                profileSpouse.setCertificateOfQualification(pv.getCertificateOfQualificationSpouse() == 1);
            }
            if (pv.getEducationSpouse() != null) {
                profileSpouse.setEducation(EducationFactorEnum.getByIntValue(pv.getEducationSpouse()));
            }
            if (pv.getEducationInCanadaSpouse() != null) {
                if(pv.getEducationInCanadaSpouse() == 1) {
                    profileSpouse.setEducationInCanada(AdditionalPointsFactorEnum.ONE_OR_TWO_YEARS_PROGRAM_IN_CANADA);
                } else if (pv.getEducationInCanadaSpouse() == 2){
                    profileSpouse.setEducationInCanada(AdditionalPointsFactorEnum.THREE_OR_MORE_YEARS_PROGRAM_IN_CANADA);
                }
            }
            if(pv.getFirstLanguageTestSpouse() != null){

                profileSpouse.setFirstLanguageTest(LanguageTestTypeEnum.getByIntValue(pv.getFirstLanguageTestSpouse()));

                if (pv.getFltListeningScoreSpouse() != null) {
                    profileSpouse.setFirstLangTestListeningScore(LanguageFactorEnum.getByIntValue(pv.getFltListeningScoreSpouse()));
                }
                if (pv.getFltReadingScoreSpouse() != null) {
                    profileSpouse.setFirstLangTestReadingScore(LanguageFactorEnum.getByIntValue(pv.getFltReadingScoreSpouse()));
                }
                if (pv.getFltSpeakingScoreSpouse() != null) {
                    profileSpouse.setFirstLangTestSpeakingScore(LanguageFactorEnum.getByIntValue(pv.getFltSpeakingScoreSpouse()));
                }
                if (pv.getFltWritingScoreSpouse() != null) {
                    profileSpouse.setFirstLangTestWritingScore(LanguageFactorEnum.getByIntValue(pv.getFltWritingScoreSpouse()));
                }
            }
            if (pv.getForeignWorkExpSpouse() != null) {
                profileSpouse.setForeignWorkExp(ForeignWorkExpFactorEnum.getByIntValue(pv.getForeignWorkExpSpouse()));
            }
            if (pv.getProvinceNominationSpouse() != null && pv.getProvinceNominationSpouse() == 1) {
                profileSpouse.setProvinceNomination(AdditionalPointsFactorEnum.PROVINCIAL_NOMINATION);
            }
            if(pv.getSecondLanguageTestSpouse() != null){

                profileSpouse.setSecondLanguageTest(LanguageTestTypeEnum.getByIntValue(pv.getSecondLanguageTestSpouse()));

                if (pv.getSltListeningScoreSpouse() != null) {
                    profileSpouse.setSecondLangTestListeningScore(LanguageFactorEnum.getByIntValue(pv.getSltListeningScoreSpouse()));
                }
                if (pv.getSltReadingScoreSpouse() != null) {
                    profileSpouse.setSecondLangTestReadingScore(LanguageFactorEnum.getByIntValue(pv.getSltReadingScoreSpouse()));
                }
                if (pv.getSltSpeakingScoreSpouse() != null) {
                    profileSpouse.setSecondLangTestSpeakingScore(LanguageFactorEnum.getByIntValue(pv.getSltSpeakingScoreSpouse()));
                }
                if (pv.getSltWritingScoreSpouse() != null) {
                    profileSpouse.setSecondLangTestWritingScore(LanguageFactorEnum.getByIntValue(pv.getSltWritingScoreSpouse()));
                }
            }
            if (pv.getArrangedEmploymentSpouse() != null) {
                profileSpouse.setArrangedEmployment(ArrangedEmploymentFactorEnum.getByIntValue(pv.getArrangedEmploymentSpouse()));
            } else {
                profileSpouse.setArrangedEmployment(ArrangedEmploymentFactorEnum.NONE);
            }
            if(pv.getSiblingWhoIsPrSpouse() != null){
                profileSpouse.setSiblingWhoIsPr(AdditionalPointsFactorEnum.SIBLING_WHO_IS_PERMANENT_RESIDENT);
            }

            return profileSpouse;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    private ProfileResponse calcScoreSectionA(Profile profile, ProfileResponse profileResponse){

        Integer points = 0;

        profileResponse.setScoreAge(profile.getAge().getValueIfSingle());

        profileResponse.setScoreLevelEducation(profile.getEducation().getValueIfSingle());

        points += profile.getFirstLangTestListeningScore().getValueIfSingle();

        points += profile.getFirstLangTestReadingScore().getValueIfSingle();

        points += profile.getFirstLangTestWritingScore().getValueIfSingle();

        points += profile.getFirstLangTestSpeakingScore().getValueIfSingle();

        profileResponse.setScoreFirstOfficialLanguage(points);

        profileResponse.setScoreCanadianWorkExperience(profile.getCanadianWorkExp().getValueIfSingle());

        profileResponse.setScoreSecondOfficialLanguage(calcSecondLanguage(profile));

        profileResponse.setSubTotalSectionA(profileResponse.getScoreAge() + profileResponse.getScoreLevelEducation()
                + points + profileResponse.getScoreCanadianWorkExperience() + profileResponse.getScoreSecondOfficialLanguage());

        return profileResponse;
    }

     private ProfileResponse calcScoreSectionAIfMarried(Profile profile, ProfileResponse profileResponse){

        Integer points = 0;

        profileResponse.setScoreAge(profile.getAge().getValueIfMarried());

        profileResponse.setScoreLevelEducation(profile.getEducation().getValueIfMarried());

        points += profile.getFirstLangTestListeningScore().getValueIfMarried();

        points += profile.getFirstLangTestReadingScore().getValueIfMarried();

        points += profile.getFirstLangTestWritingScore().getValueIfMarried();

        points += profile.getFirstLangTestSpeakingScore().getValueIfMarried();

        profileResponse.setScoreFirstOfficialLanguage(points);

        profileResponse.setScoreCanadianWorkExperience(profile.getCanadianWorkExp().getValueIfMarried());

        profileResponse.setScoreSecondOfficialLanguage(calcSecondLanguage(profile));

        profileResponse.setSubTotalSectionA(profileResponse.getScoreAge() + profileResponse.getScoreLevelEducation()
                + points + profileResponse.getScoreCanadianWorkExperience() + profileResponse.getScoreSecondOfficialLanguage());

        return profileResponse;
    }

    public ProfileResponse calcScoreSectionB(Profile profile, ProfileResponse profileResponse){

        Integer points = 0;

        profileResponse.setScoreLevelEducationSpouse(profile.getEducation().getValueIfSpouse());

        points += profile.getFirstLangTestListeningScore().getValueIfSpouse();

        points += profile.getFirstLangTestReadingScore().getValueIfSpouse();

        points += profile.getFirstLangTestWritingScore().getValueIfSpouse();

        points += profile.getFirstLangTestSpeakingScore().getValueIfSpouse();

        profileResponse.setScoreOfficialLanguageSpouse(points);

        profileResponse.setScoreCanadianWorkExperienceSpouse(profile.getCanadianWorkExp().getValueIfSpouse());

        profileResponse.setSubTotalSectionB(profileResponse.getScoreLevelEducationSpouse() + points +
                profileResponse.getScoreCanadianWorkExperienceSpouse());

        return profileResponse;
    }


    public ProfileResponse calcScoreSectionC(Profile profile, ProfileResponse profileResponse){

        Integer score = 0;

        if (profile.getEducation().getLevelIndex() > 4){

            if(this.checkIfIsClb9(profile)){

                profileResponse.setScoreOfficialLanguageAndEducation(50);
                score +=  profileResponse.getScoreOfficialLanguageAndEducation();

            } else if (this.checkIfIsClb7OrHigher(profile)){

                profileResponse.setScoreOfficialLanguageAndEducation(25);
                score +=  profileResponse.getScoreOfficialLanguageAndEducation();
            }

            if (profile.getCanadianWorkExp().getYearsIndex() > 1){
                profileResponse.setScoreCanadianWorkExperienceAndEducation(50);
                score +=  profileResponse.getScoreCanadianWorkExperienceAndEducation();
            } else if (profile.getCanadianWorkExp() == CanadianWorkExpFactorEnum.ONE_YEAR){
                profileResponse.setScoreCanadianWorkExperienceAndEducation(25);
                score +=  profileResponse.getScoreCanadianWorkExperienceAndEducation();
            }
        } else if (profile.getEducation().getLevelIndex() > 1){

            if(this.checkIfIsClb9(profile)){
                profileResponse.setScoreOfficialLanguageAndEducation(25);
                score +=  profileResponse.getScoreOfficialLanguageAndEducation();
            } else if (this.checkIfIsClb7OrHigher(profile)){

                profileResponse.setScoreOfficialLanguageAndEducation(13);
                score +=  profileResponse.getScoreOfficialLanguageAndEducation();
            }

            if (profile.getCanadianWorkExp().getYearsIndex() > 1){
                profileResponse.setScoreCanadianWorkExperienceAndEducation(25);
                score +=  profileResponse.getScoreCanadianWorkExperienceAndEducation();
            } else if (profile.getCanadianWorkExp() == CanadianWorkExpFactorEnum.ONE_YEAR){
                profileResponse.setScoreCanadianWorkExperienceAndEducation(13);
                score +=  profileResponse.getScoreCanadianWorkExperienceAndEducation();
            }

            if (profile.getForeignWorkExp() == ForeignWorkExpFactorEnum.THREE_YEARS_OR_MORE){

                if (this.checkIfIsClb9(profile)){
                    profileResponse.setScoreOfficialLanguageAndForeignWorkExperience(50);
                    score +=  profileResponse.getScoreOfficialLanguageAndForeignWorkExperience();

                } else if (this.checkIfIsClb7OrHigher(profile)){
                    profileResponse.setScoreOfficialLanguageAndForeignWorkExperience(25);
                    score +=  profileResponse.getScoreOfficialLanguageAndForeignWorkExperience();
                }
                if (profile.getCanadianWorkExp().getYearsIndex() > 1){
                    profileResponse.setScoreCanadianAndForeignWorkExperience(50);
                    score +=  profileResponse.getScoreCanadianAndForeignWorkExperience();
                } else if (profile.getCanadianWorkExp() == CanadianWorkExpFactorEnum.ONE_YEAR){
                    profileResponse.setScoreCanadianAndForeignWorkExperience(25);
                    score +=  profileResponse.getScoreCanadianAndForeignWorkExperience();
                }
            } else if (profile.getForeignWorkExp() == ForeignWorkExpFactorEnum.ONE_OR_TWO_YEARS){

                if (this.checkIfIsClb9(profile)){
                    profileResponse.setScoreOfficialLanguageAndForeignWorkExperience(25);
                    score +=  profileResponse.getScoreOfficialLanguageAndForeignWorkExperience();

                } else if (this.checkIfIsClb7OrHigher(profile)){
                    profileResponse.setScoreOfficialLanguageAndForeignWorkExperience(13);
                    score +=  profileResponse.getScoreOfficialLanguageAndForeignWorkExperience();
                }

                if (profile.getCanadianWorkExp().getYearsIndex() > 1){
                    profileResponse.setScoreCanadianAndForeignWorkExperience(25);
                    score +=  profileResponse.getScoreCanadianAndForeignWorkExperience();
                } else if (profile.getCanadianWorkExp() == CanadianWorkExpFactorEnum.ONE_YEAR){
                    profileResponse.setScoreCanadianAndForeignWorkExperience(13);
                    score +=  profileResponse.getScoreCanadianAndForeignWorkExperience();
                }
            }

            if( profile.isCertificateOfQualification()){

                if (this.checkIfIsClb7OrHigher(profile)){
                    profileResponse.setScoreCertificateOfQualification(50);
                    score +=  profileResponse.getScoreCertificateOfQualification();
                } else if (this.checkIfIsClb5OrHigher(profile)) {
                    profileResponse.setScoreCertificateOfQualification(25);
                    score +=  profileResponse.getScoreCertificateOfQualification();
                }
            }

        }

        if (score > 100){
            score = 100;
        }

        profileResponse.setSubTotalSectionC(score);

        return profileResponse;
    }

    private ProfileResponse calcScoreSectionD(Profile profile, ProfileResponse profileResponse){

        Integer score = 0;


        if (profile.getProvinceNomination() != null) {

            profileResponse.setScoreProvincialNomination(profile.getProvinceNomination().getPoints());

            score += profileResponse.getScoreProvincialNomination();

        } else {

            if(profile.getArrangedEmployment()!= null) {

                profileResponse.setScoreJobOffer(profile.getArrangedEmployment().getPoints());

                score += profileResponse.getScoreJobOffer();
            }

            if(profile.getSiblingWhoIsPr() != null) {

                profileResponse.setScoreSiblingInCanada(profile.getSiblingWhoIsPr().getPoints());

                score += profileResponse.getScoreSiblingInCanada();
            }

            if (profile.getEducationInCanada() != null) {

                profileResponse.setScoreStudyInCanadaSecD(profile.getEducationInCanada().getPoints());

                score += profileResponse.getScoreStudyInCanadaSecD();
            }

            if (profile.getSecondLanguageTest() != null && profile.getSecondLanguageTest() != LanguageTestTypeEnum.NONE
                    && this.checkIfIsClb7OrHigherSecondLanguage(profile)) {

                if (this.checkIfIsClb5OrHigher(profile)) {

                    profileResponse.setScoreFrenchLanguage(30);
                    score += profileResponse.getScoreFrenchLanguage();
                } else {
                    profileResponse.setScoreFrenchLanguage(15);
                    score += profileResponse.getScoreFrenchLanguage();
                }
            }
        }

        profileResponse.setSubTotalSectionD(score);

        return profileResponse;
    }

    private Integer calcSecondLanguage(Profile profile){

        Integer points = 0;

        if (profile.getSecondLanguageTest() != null && profile.getSecondLanguageTest() != LanguageTestTypeEnum.NONE){

            points += profile.getSecondLangTestListeningScore().getValueIfSecondLanguage();

            points += profile.getSecondLangTestReadingScore().getValueIfSecondLanguage();

            points += profile.getSecondLangTestSpeakingScore().getValueIfSecondLanguage();

            points += profile.getSecondLangTestWritingScore().getValueIfSecondLanguage();
        }

        return points;
    }



    public boolean checkIfIsClb9(Profile profile){

        if (profile.getFirstLangTestListeningScore().getClbIndex() > 5 && profile.getFirstLangTestSpeakingScore().getClbIndex() > 5
        && profile.getFirstLangTestReadingScore().getClbIndex() >5 && profile.getFirstLangTestWritingScore().getClbIndex() > 5){

            return true;
        } else {

            return false;
        }
    }

    public boolean checkIfIsClb7OrHigher(Profile profile){

        if (profile.getFirstLangTestListeningScore().getClbIndex() > 3 && profile.getFirstLangTestSpeakingScore().getClbIndex() > 3
                && profile.getFirstLangTestReadingScore().getClbIndex() >3 && profile.getFirstLangTestWritingScore().getClbIndex() > 3){

            return true;
        } else {

            return false;
        }
    }

    public boolean checkIfIsClb5OrHigher(Profile profile){

        if (profile.getFirstLangTestListeningScore().getClbIndex() > 1 && profile.getFirstLangTestSpeakingScore().getClbIndex() > 1
                && profile.getFirstLangTestReadingScore().getClbIndex() >1 && profile.getFirstLangTestWritingScore().getClbIndex() > 1){

            return true;
        } else {

            return false;
        }
    }

    public boolean checkIfIsClb7OrHigherSecondLanguage(Profile profile){

        if (profile.getSecondLangTestListeningScore().getClbIndex() > 3 && profile.getSecondLangTestSpeakingScore().getClbIndex() > 3
                && profile.getSecondLangTestReadingScore().getClbIndex() >3 && profile.getSecondLangTestWritingScore().getClbIndex() > 3){

            return true;
        } else {

            return false;
        }
    }

    private AgeFactorEnum getAgeByBirthDate(Date birthDate){

        Long age = Duration.between(birthDate.toInstant(), Instant.now()).toDays() /365;

        AgeFactorEnum ageEnum = AgeFactorEnum.SEVENTEEN_OR_LESS;

        if(age >=0 && age <= 17){
            ageEnum = AgeFactorEnum.SEVENTEEN_OR_LESS;
        } else if(age == 18){
            ageEnum = AgeFactorEnum.EIGHTEEN;
        } else if (age == 19){
            ageEnum = AgeFactorEnum.NINETEEN;
        } else if (age >= 20 && age <= 29){
            ageEnum = AgeFactorEnum.TWENTY_TO_TWENTY_NINE;
        } else if (age ==30){
            ageEnum = AgeFactorEnum.THIRTY;
        }else if (age ==31){
            ageEnum = AgeFactorEnum.THIRTY_ONE;
        }else if (age ==32){
            ageEnum = AgeFactorEnum.THIRTY_TWO;
        }else if (age ==33){
            ageEnum = AgeFactorEnum.THIRTY_THREE;
        }else if (age ==34){
            ageEnum = AgeFactorEnum.THIRTY_FOUR;
        }else if (age ==35){
            ageEnum = AgeFactorEnum.THIRTY_FIVE;
        }else if (age ==36){
            ageEnum = AgeFactorEnum.THIRTY_SIX;
        }else if (age ==37){
            ageEnum = AgeFactorEnum.THIRTY_SEVEN;
        }else if (age ==38){
            ageEnum = AgeFactorEnum.THIRTY_EIGHT;
        }else if (age ==39){
            ageEnum = AgeFactorEnum.THIRTY_NINE;
        }else if (age ==40){
            ageEnum = AgeFactorEnum.FORTY;
        }else if (age ==41){
            ageEnum = AgeFactorEnum.FORTY_ONE;
        }else if (age ==42){
            ageEnum = AgeFactorEnum.FORTY_TWO;
        }else if (age ==43){
            ageEnum = AgeFactorEnum.FORTY_THREE;
        }else if (age ==44){
            ageEnum = AgeFactorEnum.FORTY_FOUR;
        }else if (age >=45){
            ageEnum = AgeFactorEnum.FORTY_FIVE_OR_MORE;
        }

        return ageEnum;

    }

}
