package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        boolean isTrue = true;
        MessagePrinter messagePrinter = context.getBean("messagePrinter", MessagePrinter.class);
        while (isTrue) {
            System.out.println("""
                    ----------MESSENGER----------
                    1 - Email Service
                    2 - SMS Service
                    3 - Stop
                    """);
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1 -> {
                    EmailService emailService = context.getBean("emailService", EmailService.class);
                    boolean isEmail = true;
                    while (isEmail) {
                        System.out.print("Enter message('stop' to stop): ");
                        String s = new Scanner(System.in).nextLine();
                        if(s.equals("stop")) {
                            isEmail = false;
                        }else {
                            emailService.setMessage(s);
                            messagePrinter.setService(emailService);
                            System.out.println(messagePrinter.getService().getMessage());
                        }
                    }
                }
                case 2 -> {
                    SMSService smsService = context.getBean("smsService", SMSService.class);
                    boolean isSms = true;
                    while (isSms) {
                        System.out.print("Enter message('stop' to stop): ");
                        String s = new Scanner(System.in).nextLine();
                        if(s.equals("stop")){
                            isSms = false;
                        }else {
                            smsService.setMessage(s);
                            messagePrinter.setService(smsService);
                            System.out.println(messagePrinter.getService().getMessage());
                        }
                    }
                }
                case 3 -> isTrue = false;
            }
        }
        context.close();
    }
}
