package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SkillLanguageEnum {

    SPEAKING("Speaking"),
    LISTENING("Listening"),
    READING("Reading"),
    WRITING("Writing");

    private String value;

    private SkillLanguageEnum(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
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
