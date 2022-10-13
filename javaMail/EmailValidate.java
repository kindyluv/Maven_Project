package com.first.twitter.services.notificationConfig.javaMail;

import com.first.twitter.exceptions.EmailNotValidException;
import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidate {

    public boolean test(String s, String emailAddress) throws EmailNotValidException {
        EmailValidator email = EmailValidator.getInstance();
        if (emailAddress == null) throw new IllegalArgumentException("emailAddress can not be null");
        boolean valid = false;
        if(valid == email.isValid(emailAddress)){
            valid = true;
            return valid;}
        else{
            throw new EmailNotValidException("emailAddress is not a valid email address");
        }
    }
}
