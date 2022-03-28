package com.dominhtuan.exercise1.util;

import java.util.Objects;

public class ValidateUtils {
    public static boolean isValid(Object o){
        if (Objects.nonNull(o)) {
            return !o.toString().equals("") && !o.toString().equals("0");
        }
        return false;
    }
}
