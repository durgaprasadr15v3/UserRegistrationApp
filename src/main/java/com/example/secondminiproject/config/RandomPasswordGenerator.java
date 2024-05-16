package com.example.secondminiproject.config;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGenerator {
    
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    private static final SecureRandom random = new SecureRandom();

    public String generate() {
    	int length=12;
        StringBuilder password = new StringBuilder();

        // Use at least one character from each character set
        password.append(randomChar(UPPER));
        password.append(randomChar(LOWER));
        password.append(randomChar(DIGITS));

        // Fill the rest of the password length
        for (int i = 4; i < length; i++) {
            String charSet = getCharset();
            password.append(randomChar(charSet));
        }

        // Shuffle the password characters
        return shuffleString(password.toString());
    }

    private static String randomChar(String charSet) {
        int index = random.nextInt(charSet.length());
        return charSet.substring(index, index + 1);
    }

    private static String getCharset() {
        String allChars = UPPER + LOWER + DIGITS ;
        return allChars.substring(random.nextInt(allChars.length()));
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

}
