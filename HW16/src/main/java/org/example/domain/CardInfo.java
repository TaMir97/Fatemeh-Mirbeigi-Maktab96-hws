package org.example.domain;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CardInfo {
    private String value;
    public CardInfo() {
    }

    public CardInfo(String value) {
        if (isValid(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Invalid card information.");
        }
    }

    public String getValue() {
        return value;
    }

    private boolean isValid(String value) {
        String regexPattern = "^(585963|6073998|5859831|6280852)\\d{9}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}

