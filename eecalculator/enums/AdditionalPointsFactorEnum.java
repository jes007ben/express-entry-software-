package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum AdditionalPointsFactorEnum {

    SIBLING_WHO_IS_PERMANENT_RESIDENT("Brother or sister who is a permanent resident of Canada", 15),
    ONE_OR_TWO_YEARS_PROGRAM_IN_CANADA("Post-secondary education in  Canada - credential of one or two years", 15),
    THREE_OR_MORE_YEARS_PROGRAM_IN_CANADA("Post-secondary education in  Canada - credential three years or longer", 30),
    PROVINCIAL_NOMINATION("Provincial or territorial nomination", 600);

    private String value;

    private Integer points;

    public String getValue() {
        return value;
    }

    public Integer getPoints() {
        return points;
    }


    private AdditionalPointsFactorEnum(String value, Integer points ) {

        this.value = value;

        this.points = points;
    }

    private static final Map<Integer, AdditionalPointsFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (AdditionalPointsFactorEnum obj : EnumSet.allOf(AdditionalPointsFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static AdditionalPointsFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

}
