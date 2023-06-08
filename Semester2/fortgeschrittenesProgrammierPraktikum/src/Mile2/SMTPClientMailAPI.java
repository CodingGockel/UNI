package Mile2;

import java.io.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Scanner;
public class SMTPClientMailAPI {
    public static void sendMailWithoutSSL(String host, int port, String username, String password, String fromAdress, String[] toAdresses, String subject, String body){

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAdress));

            InternetAddress[] recipientAddresses = new InternetAddress[toAdresses.length];
            for (int i = 0; i < toAdresses.length; i++) {
                recipientAddresses[i] = new InternetAddress(toAdresses[i]);
            }

            message.setRecipients(Message.RecipientType.TO, recipientAddresses);
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMailWithSSL(String host, int port, String username, String password, String fromAdress, String[] toAdresses, String subject, String body){

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAdress));

            InternetAddress[] recipientAddresses = new InternetAddress[toAdresses.length];
            for (int i = 0; i < toAdresses.length; i++) {
                recipientAddresses[i] = new InternetAddress(toAdresses[i]);
            }

            message.setRecipients(Message.RecipientType.TO, recipientAddresses);
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        boolean ssl;
        String host;
        int port;
        String username;
        String password;
        String fromAdress;
        String[] toAddresses;
        String subject;
        String body;

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("(1) Login");
            System.out.println("(2) Exit Program");
            int decision = Integer.parseInt(scanner.nextLine());
            if(decision == 2){
                System.out.println("Exiting Program...");
                break;
            }else if(decision == 1){
                while (true) {
                    System.out.println("Do you want to use SSL?(1==yes/2==no)");
                    int dec =Integer.parseInt(scanner.nextLine());
                    if(dec == 1){
                        ssl = true;
                        break;
                    }else if(dec == 2){
                        ssl = false;
                        break;
                    }else{
                        System.out.println("not a valid option");
                    }
                }
                System.out.print("host Server: ");
                host = scanner.nextLine();

                System.out.print("Port: ");
                port = Integer.parseInt(scanner.nextLine());

                System.out.print("Username: ");
                username = scanner.nextLine();

                Console console = System.console();
                if (console == null) {
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                }else{
                    char[] passwordArray = console.readPassword("Password: ");
                    password = new String(passwordArray);
                }

                System.out.print("Mail from: ");
                fromAdress = scanner.nextLine();

                System.out.print("Mail to(multiple with ';' between): ");
                toAddresses = scanner.nextLine().split(";");

                System.out.print("Subject: ");
                subject = scanner.nextLine();

                System.out.print("Body: ");
                body = scanner.nextLine();

                if(ssl){
                    sendMailWithSSL(host,port,username,password,fromAdress,toAddresses,subject,body);
                }else{
                    sendMailWithoutSSL(host,port,username,password,fromAdress,toAddresses,subject,body);
                }

                while(true){
                    System.out.println("(1) send another Mail");
                    System.out.println("(2) logout");
                    int d = Integer.parseInt(scanner.nextLine());
                    if(d == 1){
                        System.out.print("Mail from: ");
                        fromAdress = scanner.nextLine();

                        System.out.print("Mail to(multiple with ';' between): ");
                        toAddresses = scanner.nextLine().split(";");

                        System.out.print("Subject: ");
                        subject = scanner.nextLine();

                        System.out.print("Body: ");
                        body = scanner.nextLine();

                        if(ssl){
                            sendMailWithSSL(host,port,username,password,fromAdress,toAddresses,subject,body);
                        }else{
                            sendMailWithoutSSL(host,port,username,password,fromAdress,toAddresses,subject,body);
                        }
                    } else if (d == 2) {
                        break;
                    }else{
                        System.out.println("not a valid option!");
                    }
                }
            }else{
                System.out.println(decision +" is not a valid option!");
            }

        }
        /*
        String host = "wp1170810.mailout.server-he.de";
        int port = 465;
        String username = "wp1170810-moritz";
        String password = "Moritz2004";
        String fromAdress = "Moritz@hahnimnetz.de";
        String[] toAddresses = {"Moritz.hahn@uni-jena.de","moritz@hahnimnetz.de","badassgockel@gmail.com"};
        String subject = "Test mit SSL";
        String body = "Hallo";
        //sendMailWithSSL(host,port,username,password,fromAdress,toAddresses,subject,body);
        host = "smtp.uni-jena.de";
        port = 587;
        username = "du54tef";
        password = "16Moritz05.2004/UNI";
        fromAdress = "moritz.hahn@uni-jena.de";
        subject = "Test ohne SSL";
        sendMailWithoutSSL(host,port, username,password,fromAdress,toAddresses,subject,body);
        */
    }
}