package Mile2;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SMTPClientSocket {
    public static void sendMailWithSSL(String host, int port, String username, String password, String fromAdress, String[] toAdresses, String subject, String body){
        try {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(host, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String response = reader.readLine();
            System.out.println(response);

            writer.write("EHLO "+host+"\r\n");
            writer.flush();

            response = reader.readLine();
            System.out.println(response);

            writer.write("AUTH LOGIN\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write(encodeBase64(username) + "\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write(encodeBase64(password) + "\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write("MAIL FROM: <"+fromAdress+">\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            for(String toAddress: toAdresses){
                writer.write("RCPT TO: <" + toAddress + ">\r\n");
                writer.flush();
                response = reader.readLine();
                System.out.println(response);
            }

            writer.write("DATA\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write("Subject: "+subject+"\r\n");
            writer.write("From: " + fromAdress + "\r\n");
            writer.write("To: " + String.join(",",toAdresses) + "\r\n");
            writer.write("\r\n");
            writer.write(body+"\r\n");
            writer.write(".\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write("QUIT\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.close();
            reader.close();
            socket.close();

            System.out.println("Die E-Mail wurde erfolgreich gesendet.");
        } catch (Exception e) {
            System.out.println("Fehler beim Senden der E-Mail: " + e.getMessage());
        }
    }

    public static void sendMailWithoutSSL(String host, int port, String username, String password, String fromAdress, String[] toAdresses, String subject, String body){
        try {
            Socket socket = new Socket(host, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String response = reader.readLine();
            System.out.println(response);

            writer.write("EHLO "+host+"\r\n");
            writer.flush();

            response = reader.readLine();
            System.out.println(response);

            writer.write("AUTH LOGIN\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write(encodeBase64(username) + "\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write(encodeBase64(password) + "\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write("MAIL FROM: <"+fromAdress+">\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            for(String toAddress: toAdresses){
                writer.write("RCPT TO: <" + toAddress + ">\r\n");
                writer.flush();
                response = reader.readLine();
                System.out.println(response);
            }

            writer.write("DATA\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write("Subject: "+subject+"\r\n");
            writer.write("From: " + fromAdress + "\r\n");
            writer.write("To: " + String.join(",",toAdresses) + "\r\n");
            writer.write("\r\n");
            writer.write(body+"\r\n");
            writer.write(".\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.write("QUIT\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);

            writer.close();
            reader.close();
            socket.close();

            System.out.println("Die E-Mail wurde erfolgreich gesendet.");
        } catch (Exception e) {
            System.out.println("Fehler beim Senden der E-Mail: " + e.getMessage());
        }
    }
    private static String encodeBase64(String input) {
        byte[] encodedBytes = Base64.getEncoder().encode(input.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes, StandardCharsets.UTF_8);
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
