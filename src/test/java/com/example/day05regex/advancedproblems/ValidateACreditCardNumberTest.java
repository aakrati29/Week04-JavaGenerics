package com.example.day05regex.advancedproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

public class ValidateACreditCardNumberTest {

    private static final String CARD_REGEX = "^(4[0-9]{15})|(5[0-9]{15})$";

    public static boolean isValidCardNumber(String cardNumber) {
        return Pattern.matches(CARD_REGEX, cardNumber);
    }

    @Test
    void testValidVisaAndMasterCardNumbers() {
        assertTrue(isValidCardNumber("4111111111111111"), "Visa: 4111111111111111 should be valid.");
        assertTrue(isValidCardNumber("5555555555554444"), "MasterCard: 5555555555554444 should be valid.");
        assertTrue(isValidCardNumber("5011111111111111"), "MasterCard: 5011111111111111 should be valid.");
    }

    @Test
    void testInvalidCardNumbers() {
        assertFalse(isValidCardNumber("6011111111111117"), "6011111111111117 (Discover) should be invalid.");
        assertFalse(isValidCardNumber("378282246310005"), "378282246310005 (Amex) should be invalid.");
        assertFalse(isValidCardNumber("1234567812345678"), "1234567812345678 should be invalid (wrong prefix).");
        assertFalse(isValidCardNumber("511111112141111"), "511111112141111 (15 digits) should be invalid.");
        assertFalse(isValidCardNumber("51111111214111122"), "51111111214111122 (17 digits) should be invalid.");
        assertFalse(isValidCardNumber("5051A51051022220"), "5051A51051022220 (contains non-numeric character) should be invalid.");
    }
}
