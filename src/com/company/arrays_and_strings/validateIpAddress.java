package com.company.arrays_and_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validateIpAddress {
    public String validIPAddress_1(String IP) {
        String regexV4 = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
        String regexV6 = "\\A(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}\\z";
        Pattern patternV4 = Pattern.compile(regexV4);
        Pattern patternV6 = Pattern.compile(regexV6);
        Matcher matcherV4 = patternV4.matcher(IP);
        Matcher matcherV6 = patternV6.matcher(IP);

        if(matcherV4.find()) return "IPv4";
        if(matcherV6.find()) return "IPv6";
        return "Neither";
    }
}
