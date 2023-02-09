package org.example;

public class EmailService implements Service{
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "Email: " + message;
    }
}
