package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum LanguageFactorEnum {

    LESS_THAN_CLB4(0, "Less than CLB 4", 0, 0, 0, 0),
    CLB_4(1, "CLB 4", 6, 6, 0, 0),
    CLB_5(2, "CLB 5", 6, 6, 1, 1),
    CLB_6(3, "CLB 6", 8, 9, 1, 1),
    CLB_7(4, "CLB 7", 16, 17, 3, 3),
    CLB_8(5, "CLB 8", 22, 23, 3, 3),
    CLB_9(6, "CLB 9", 29, 31, 6, 5),
    CLB_10_OR_HIGHER(7, "CLB 10 or Higher", 32, 34, 6, 5);

    private String value;

    private Integer valueIfSingle;

    private Integer valueIfMarried;

    private Integer valueIfSecondLanguage;

    private Integer valueIfSpouse;

    private Integer clbIndex;


    private LanguageFactorEnum(Integer clbIndex, String value, Integer valueIfMarried, Integer valueIfSingle, Integer valueIfSpouse, Integer valueIfSecondLanguage) {

        this.clbIndex = clbIndex;

        this.value = value;

        this.valueIfMarried = valueIfMarried;

        this.valueIfSingle = valueIfSingle;

        this.valueIfSpouse = valueIfSpouse;

        this.valueIfSecondLanguage = valueIfSecondLanguage;
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


    public Integer getValueIfSecondLanguage() {
        return valueIfSecondLanguage;
    }

    public Integer getValueIfSpouse() {
        return valueIfSpouse;
    }

    private static final Map<Integer, LanguageFactorEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (LanguageFactorEnum obj : EnumSet.allOf(LanguageFactorEnum.class))
            lookup.put(i++, obj);
    }

    public static LanguageFactorEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

    public Integer getClbIndex() {
        return clbIndex;
    }
}
