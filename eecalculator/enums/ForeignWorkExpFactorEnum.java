package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ForeignWorkExpFactorEnum {

    NONE_OR_LESS_THAN_1("None or less than 1 year", 0, 0),
    ONE_OR_TWO_YEARS("1 or 2 Years", 13, 25),
    THREE_YEARS_OR_MORE("3 Years or more", 25, 50);

    private String value;

    private Integer valueIfHigherThanCLB7OrOneYearCanWorkExp;

    private Integer valueIfHigherThanCLB9OrTwoYearsOrMoreCanWorkExp;


    private ForeignWorkExpFactorEnum(String value, Integer valueIfHigherThanCLB7OrOneYearCanWorkExp,
                                     Integer valueIfHigherThanCLB9OrTwoYearsOrMoreCanWorkExp) {

        this.value = value;
        this.valueIfHigherThanCLB7OrOneYearCanWorkExp = valueIfHigherThanCLB7OrOneYearCanWorkExp;
        this.valueIfHigherThanCLB9OrTwoYearsOrMoreCanWorkExp = valueIfHigherThanCLB9OrTwoYearsOrMoreCanWorkExp;
    }

    public String getValue() {

        return value;
    }

    private static final Map<Integer, ForeignWorkExpFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (ForeignWorkExpFactorEnum obj : EnumSet.allOf(ForeignWorkExpFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static ForeignWorkExpFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }


}
