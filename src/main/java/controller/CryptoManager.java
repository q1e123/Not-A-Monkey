package controller;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class CryptoManager {
    public static String getSHA256(String message){
        String hashedMessage = Hashing.sha256().hashString(message, StandardCharsets.UTF_8).toString();
        return hashedMessage;
    }
}
