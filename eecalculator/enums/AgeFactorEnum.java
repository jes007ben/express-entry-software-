package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum AgeFactorEnum {

    SEVENTEEN_OR_LESS("17 years of less", 0, 0),
    EIGHTEEN("18 years", 90, 99),
    NINETEEN("19 years of age", 95, 105),
    TWENTY_TO_TWENTY_NINE("20 to 29",100,110 ),
    THIRTY("30 years",95,105),
    THIRTY_ONE("31 years",90,99),
    THIRTY_TWO("32 years",85,94),
    THIRTY_THREE("33 Years",80,93),
    THIRTY_FOUR("34 years",75,88),
    THIRTY_FIVE("35 years",70,77),
    THIRTY_SIX("36 years",65,72),
    THIRTY_SEVEN("37 years",60,66),
    THIRTY_EIGHT("38 years",55,61),
    THIRTY_NINE("39 years",50,55),
    FORTY("40 years",45,50),
    FORTY_ONE("41 years",35,39),
    FORTY_TWO("42 years",25,28),
    FORTY_THREE("43 years",15,17),
    FORTY_FOUR("44 years",5,6),
    FORTY_FIVE_OR_MORE("45 years or more",0,0);


    private String value;

    private Integer valueIfSingle;

    private Integer valueIfMarried;

    private AgeFactorEnum(String value,Integer valueIfMarried,Integer valueIfSingle ) {

        this.value = value;

        this.valueIfMarried = valueIfMarried;

        this.valueIfSingle = valueIfSingle;
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

    private static final Map<Integer, AgeFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (AgeFactorEnum obj : EnumSet.allOf(AgeFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static AgeFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

}
