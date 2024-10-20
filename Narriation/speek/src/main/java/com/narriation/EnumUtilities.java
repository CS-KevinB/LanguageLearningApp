package com.narriation;

public class EnumUtilities {

    public static <T extends Enum<T>> T getEnumFromString(Class<T> enumClass, String str) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.toString().equalsIgnoreCase(str)) {
                return enumConstant;
            }
        }
        return null;
    }

}
