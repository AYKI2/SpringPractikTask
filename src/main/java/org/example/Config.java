package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Configuration
@ComponentScan("org.example")
public class Config {
    @Primary
    @Bean
    public Service emailService(){
        return new EmailService();
    }
    
    @Bean
    public Service smsService(){
        return new SMSService();
    }
    @Bean
    public MessagePrinter messagePrinter(){
        return new MessagePrinter(emailService());
    }
}

