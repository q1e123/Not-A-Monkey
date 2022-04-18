package controller;

public class InsecurePasswordException extends Exception{
    public InsecurePasswordException(String message) {
        super(message);
    }
}
