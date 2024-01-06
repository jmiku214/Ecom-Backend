package com.ecom.app.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenerateRandomCode {

	public static int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	
	public static String randomString(Integer length) {
        int leftLimit = 48; 
        int rightLimit = 122; 
        int targetStringLength = length;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

    }
}
