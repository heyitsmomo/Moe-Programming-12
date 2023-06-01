package com.moe.module25;

public class Main {

    /**
     * MAIN METHOD
     * @param args not used
     */
    public static void main(String[] args) {
        int shift = 1;
        CaeserCipher cipher = new CaeserCipher(shift);

        String message = "Hello, World!";
        String encryptedMessage = cipher.encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = cipher.decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
