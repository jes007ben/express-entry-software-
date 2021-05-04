package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CanadianWorkExpFactorEnum {

    NONE_OR_LESS_THAN_1(0, "None or less than 1 year", 0, 0, 0),
    ONE_YEAR(1, "1 Year", 35, 40, 5),
    TWO_YEARS(2, "2 Years", 46, 53, 7),
    THREE_YEARS(3, "3 Years", 56, 64, 8),
    FOUR_YEARS(4, "4 Years", 63, 72, 9),
    FIVE_YEARS_OR_MORE(5, "5 Years or more", 70, 80, 10);

    private String value;

    private Integer valueIfSingle;

    private Integer valueIfMarried;

    private Integer valueIfSpouse;

    private Integer yearsIndex;


    private CanadianWorkExpFactorEnum(Integer yearsIndex, String value, Integer valueIfMarried, Integer valueIfSingle, Integer valueIfSpouse) {

        this.yearsIndex = yearsIndex;

        this.value = value;

        this.valueIfMarried = valueIfMarried;

        this.valueIfSingle = valueIfSingle;

        this.valueIfSpouse = valueIfSpouse;
    }

    public String getValue() {

        return value;
    }

    public Integer getValueIfSingle() {
        return valueIfSingle;
    }


    public Integer getValueIfMarried() {
        return valueIfMarried;
    }


    public Integer getValueIfSpouse() {
        return valueIfSpouse;
    }

    public void setValueIfSpouse(Integer valueIfSpouse) {this.valueIfSpouse = valueIfSpouse;}

    private static final Map<Integer, CanadianWorkExpFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (CanadianWorkExpFactorEnum obj : EnumSet.allOf(CanadianWorkExpFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static CanadianWorkExpFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

    public Integer getYearsIndex() {
        return yearsIndex;
    }
}
