package com.smart.village.util;

import com.smart.village.model.UserSms;

public interface SmsSender {

    

	void sendSms(UserSms userSms);

    // or maybe void sendSms(String phoneNumber, String message);
}
