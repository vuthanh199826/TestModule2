package Bai1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NUMBER_REGEX = "^[0-9]{6,}$";


    public boolean validateRegex(String regex, String REGEX) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
