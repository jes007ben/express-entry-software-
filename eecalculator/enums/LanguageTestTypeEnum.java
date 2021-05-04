package com.hylston.eecalculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum LanguageTestTypeEnum {

    NONE("None"),
    CELPIP("CELPIP"),
    IELTS("IELTS"),
    TEF("TEF");

    private String value;

    private LanguageTestTypeEnum(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }

    private static final Map<Integer, LanguageTestTypeEnum > lookup= new HashMap<>();

    static {
        int i = 0;
        for (LanguageTestTypeEnum obj : EnumSet.allOf(LanguageTestTypeEnum.class))
            lookup.put(i++, obj);
    }

    public static LanguageTestTypeEnum getByIntValue(int intValue) {
        return lookup.get(intValue);
    }

}
