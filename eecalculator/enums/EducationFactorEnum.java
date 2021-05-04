package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EducationFactorEnum {

    LESS_THAN_SECONDARY(0, "Less than High School", 0, 0, 0),
    SECONDARY_DIPLOMA(1, "High School", 28, 30, 2),
    ONE_YEAR_PROGRAM(2, "One-year Program", 84, 90, 6),
    TWO_YEAR_PROGRAM(3, "2 Year Program",91,98, 7 ),
    BACHELORS_DEGREE(4, "Bachelor's Degree",112,120, 8),
    TWO_OR_MORE_CERTIFICATES(5, "2 or more certificates. One must be 3 or more years",119,128, 9),
    MASTERS_DEGREE(6, "Master's Degree",126,135, 10),
    DOCTORAL_LEVEL(7, "Doctoral level university degree(Ph.D.",140,150, 10);


    private String value;

    private Integer valueIfSingle;

    private Integer valueIfMarried;

    private Integer valueIfSpouse;

    private Integer levelIndex;

    private EducationFactorEnum(Integer levelIndex, String value, Integer valueIfMarried, Integer valueIfSingle,Integer valueIfSpouse ) {

        this.levelIndex = levelIndex;

        this.value = value;

        this.valueIfMarried = valueIfMarried;

        this.valueIfSingle = valueIfSingle;

        this.valueIfSpouse = valueIfSpouse;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getValueIfSingle() {
        return valueIfSingle;
    }

    public void setValueIfSingle(Integer valueIfSingle) {
        this.valueIfSingle = valueIfSingle;
    }

    public Integer getValueIfMarried() {
        return valueIfMarried;
    }

    public void setValueIfMarried(Integer valueIfMarried) {
        this.valueIfMarried = valueIfMarried;
    }

    public Integer getValueIfSpouse() {
        return valueIfSpouse;
    }

    public void setValueIfSpouse(Integer valueIfSpouse) {
        this.valueIfSpouse = valueIfSpouse;
    }

    private static final Map<Integer, EducationFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (EducationFactorEnum obj : EnumSet.allOf(EducationFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static EducationFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

    public Integer getLevelIndex() {
        return levelIndex;
    }
}
