package br.edu.ifsp.testing.class03.exercises;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static String[] substringsBetween(final String str, final String open, final String close) {

        if (str == null || open.isEmpty() || close.isEmpty()) {
            return null;
        }

        final int strLen = str.length();
        if (strLen == 0) {
            return new String[0];
        }
        final int closeLen = close.length();
        final int openLen = open.length();
        final List<String> list = new ArrayList<>();
        int pos = 0;

        while (pos < strLen - closeLen) {
            int start = str.indexOf(open, pos);
            if (start < 0) {
                break;
            }
            start += openLen;
            final int end = str.indexOf(close, start);
            if (end < 0) {
                break;
            }
            list.add(str.substring(start, end));
            pos = end + closeLen;
        }

        if (list.isEmpty()) {
            return null;
        }

        return list.toArray(new String[0]);
    }
}
