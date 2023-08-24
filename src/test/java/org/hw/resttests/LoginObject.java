package org.hw.resttests;

public class LoginObject {
    private String email;
    private String password;
    private String token;

    public LoginObject() {
    }

    public LoginObject(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
