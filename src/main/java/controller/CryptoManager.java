package controller;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class CryptoManager {
    public static String getSHA256(String message){
        HashFunction sha256 = Hashing.sha256();
        HashCode hashCode = sha256.hashString(message, StandardCharsets.UTF_8);
        String hashedMessage = hashCode.toString();
        return hashedMessage;
    }
}
