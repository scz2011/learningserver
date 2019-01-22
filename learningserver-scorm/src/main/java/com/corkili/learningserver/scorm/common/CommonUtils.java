package com.corkili.learningserver.scorm.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {

    private static final Set<String> LANGUAGE_CODES = new HashSet<>(Arrays.asList(Locale.getISOLanguages()));
    private static final Set<String> LANGUAGE_SUBCODES = new HashSet<>(Arrays.asList(Locale.getISOCountries()));

    public static String stringifyError(Throwable error) {
        StringWriter result = new StringWriter();
        PrintWriter printer = new PrintWriter(result);
        error.printStackTrace(printer);
        printer.close();
        return result.toString();
    }

    public static String format(String format, Object... objects) {
        return String.format(format.replace("{}", "%s"), objects);
    }

    public static boolean isLegalLanguage(String language) {
        if (StringUtils.isBlank(language)) {
            return false;
        }
        String[] code = language.split("-");
        boolean result;
        if (code.length == 1 || code.length == 2) {
            result = LANGUAGE_CODES.contains(code[0]);
            if (code.length == 2) {
                result &= LANGUAGE_SUBCODES.contains(code[1]);
            }
        } else {
            result = false;
        }
        return result;
    }

}
