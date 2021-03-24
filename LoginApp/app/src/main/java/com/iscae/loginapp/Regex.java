package com.iscae.loginapp;

import java.util.regex.Pattern;

public class Regex {

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^"+
            "(?=.*[0-9])"+              //at least 1 digit
            "(?=.*[a-z])"+             //at least 1 lower case letter
            "(?=.*[A-Z])"+            //at least 1 upper case letter
            //"(?=.*[a-zA-Z])"+            //any letter
            "(?=.*[@#%^&+=])"+       //at least 1 special character
            "(?=\\S+$)"+            //no white spaces
            ".{8,40}"+                //at least 6 characters
            "$");

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{2,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{2,64}" +
                    "(" +
                    "\\." +
                    "(com|net|org)" +
                    ")+");
}
