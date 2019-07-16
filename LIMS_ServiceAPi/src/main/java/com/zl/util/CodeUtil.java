package com.zl.util;

import java.util.Random;

public class CodeUtil {
    public static Random random = new Random();

    public static  String getCode() {
        return String.valueOf(random.nextInt(8999) + 1000);
    }
}
