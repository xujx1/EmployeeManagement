package com.architecture.em.utils;


public class CharacterJudgeUtil {

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    public static boolean isAlphabet(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 65 || chr > 122 || (chr > 90 && chr < 97))
                return false;
        }
        return true;
    }

    public static boolean isChinese(String str) {
        String reg = "[\\u4e00-\\u9fa5]+";//表示+表示一个或多个中文，

        return str.matches(reg);
    }
}
