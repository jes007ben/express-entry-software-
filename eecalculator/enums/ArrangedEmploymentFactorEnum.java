package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ArrangedEmploymentFactorEnum {

    NONE("None", 0),
    ARRANGED_EMPLOYMENT_NOC_00("Arranged employment - NOC 00", 200),
    ARRANGED_EMPLOYMENT_NOC_0_A_OR_B("Arranged employment – NOC 0, A or B", 50),
    ARRANGED_EMPLOYMENT_NOC_C_OR_D("Arranged employment – NOC C or D", 0);

    private String value;

    private Integer points;

    public String getValue() {
        return value;
    }

    public Integer getPoints() {
        return points;
    }


    private ArrangedEmploymentFactorEnum(String value, Integer points ) {

        this.value = value;

        this.points = points;
    }

    private static final Map<Integer, ArrangedEmploymentFactorEnum> lookup= new HashMap<>();

    static {
        int i = -1;
        for (ArrangedEmploymentFactorEnum obj : EnumSet.allOf(ArrangedEmploymentFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static ArrangedEmploymentFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

}
