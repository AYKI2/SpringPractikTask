package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter @Setter
@NoArgsConstructor
@Component
@Scope("singleton")
public class MessagePrinter {
    private Service service;
    @Autowired
    public MessagePrinter(Service service) {
        this.service = service;
    }
    @PostConstruct
    public void init(){
        System.out.println("init method is working");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy method is working");
    }
}
