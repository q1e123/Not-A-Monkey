package controller;

public class SecurityPoliciesManager {
    private static SecurityPoliciesManager securityPoliciesManager;

    Integer minimumPasswordLength;

    private SecurityPoliciesManager(){
        this.minimumPasswordLength = 16;
    }

    public static SecurityPoliciesManager getInstance(){
        if (securityPoliciesManager == null){
            securityPoliciesManager = new SecurityPoliciesManager();
        }
        return securityPoliciesManager;
    }

    public void checkPassword(String password) throws InsecurePasswordException {
        if (password.length() < this.minimumPasswordLength){
            throw new InsecurePasswordException("Password is too short. Minimum length: " + this.minimumPasswordLength.toString());
        }
        if (!password.matches("    (?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])")){
            throw new InsecurePasswordException("Insecure password.");
        }
    }
}
