package com.moe.module25;

import java.util.HashMap;
import java.util.Map;
public class CaeserCipher {
    private int shift;
    private Map<Character, Character> encryptionMap;
    private Map<Character, Character> decryptionMap;

    /**
     * CIPHER CONSTRUCTOR
     * @param shift the shifting of the alphabet
     */
    public CaeserCipher(int shift) {
        if (shift < 1 || shift > 25) {
            throw new IllegalArgumentException("Shift value must be between 1 and 25.");
        }
        this.shift = shift;
        this.encryptionMap = generateEncryptionMap(shift);
        this.decryptionMap = generateDecryptionMap(shift);
    }

    /**
     * GENERATES ENCRYPTION MAP
     * @param shift the shifting of the alphabet
     * @return the map
     */
    private Map<Character, Character> generateEncryptionMap(int shift) {
        Map<Character, Character> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char encryptedChar = (char) (((ch - 'a' + shift) % 26) + 'a');
            map.put(ch, encryptedChar);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char encryptedChar = (char) (((ch - 'A' + shift) % 26) + 'A');
            map.put(ch, encryptedChar);
        }
        return map;
    }

    /**
     * GENERATE DECRYPTION MAP
     * @param shift the shifting of the alphabet
     * @return the map
     */
    private Map<Character, Character> generateDecryptionMap(int shift) {
        Map<Character, Character> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char decryptedChar = (char) (((ch - 'a' - shift + 26) % 26) + 'a');
            map.put(ch, decryptedChar);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char decryptedChar = (char) (((ch - 'A' - shift + 26) % 26) + 'A');
            map.put(ch, decryptedChar);
        }
        return map;
    }

    /**
     * ENCRYPT
     * @param message String of message to cipher
     * @return the encrypted message
     */
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (encryptionMap.containsKey(ch)) {
                encryptedMessage.append(encryptionMap.get(ch));
            } else {
                encryptedMessage.append(ch);
            }
        }
        return encryptedMessage.toString();
    }

    /**
     * DECRYPT
     * @param encryptedMessage the encrypted message in string
     * @return the decrypted message
     */
    public String decrypt(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char ch : encryptedMessage.toCharArray()) {
            if (decryptionMap.containsKey(ch)) {
                decryptedMessage.append(decryptionMap.get(ch));
            } else {
                decryptedMessage.append(ch);
            }
        }
        return decryptedMessage.toString();
    }
}
