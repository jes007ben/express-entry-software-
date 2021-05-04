package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EducationInCanadaFactorEnum {

    SECONDARY_DIPLOMA_OR_LESS("High School or less", 0, 0),
    ONE_YEAR_PROGRAM_OR_LONGER("One year program or longer", 13,25),
    TWO_OR_MORE_POST_SENCONDARY_PROGRAM("Two or more post secondary program being 1 of 3 years or longer",25,50);

    private String value;

    private Integer valueIfHigherThanClb7OrOneYearCanadianWorkExp;

    private Integer valueIfHigherThanClb9OrTwoOrMoreYearsCanadianWorkExp;

    private EducationInCanadaFactorEnum(String value, Integer valueIfHigherThanClb7OrOneYearCanadianWorkExp,
                                        Integer valueIfHigherThanClb9OrTwoOrMoreYearsCanadianWorkExp ) {

        this.value = value;

        this.valueIfHigherThanClb7OrOneYearCanadianWorkExp = valueIfHigherThanClb7OrOneYearCanadianWorkExp;

        this.valueIfHigherThanClb9OrTwoOrMoreYearsCanadianWorkExp = valueIfHigherThanClb9OrTwoOrMoreYearsCanadianWorkExp;
    }

    public String getValue() {
        return value;
    }

    public Integer getValueIfHigherThanClb7OrOneYearCanadianWorkExp() {
        return valueIfHigherThanClb7OrOneYearCanadianWorkExp;
    }

    public Integer getValueIfHigherThanClb9OrTwoOrMoreYearsCanadianWorkExp() {
        return valueIfHigherThanClb9OrTwoOrMoreYearsCanadianWorkExp;
    }

    private static final Map<Integer, EducationInCanadaFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (EducationInCanadaFactorEnum obj : EnumSet.allOf(EducationInCanadaFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static EducationInCanadaFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }
}
