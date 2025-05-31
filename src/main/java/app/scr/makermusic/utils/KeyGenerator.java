package app.scr.makermusic.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {
    public static String generateKey() {
        int keySizeInBits = 512;
        byte[] keyBytes = new byte[keySizeInBits / 8];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
