package org.example;

import org.springframework.stereotype.Component;

@Component
public class SMSService implements Service{
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "SMS: " + message;
    }
}
