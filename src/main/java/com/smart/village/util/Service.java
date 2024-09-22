package com.smart.village.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.smart.village.model.UserSms;

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(UserSms userSms) {
    	System.out.println(userSms.getPhoneNumber());
        smsSender.sendSms(userSms);
    }
}
