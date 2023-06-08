package Mile1;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import java.io.*;
public class Pop3EmailClient {
    public static void main(String[] args) {
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
                String password;
                System.out.print("POP3 Server: ");
                String pop3Server = scanner.nextLine();

                System.out.print("Username: ");
                String username = scanner.nextLine();

                Console console = System.console();
                if (console == null) {
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                }else{
                    char[] passwordArray = console.readPassword("Password: ");
                    password = new String(passwordArray);
                }
                try {
                    Properties properties = new Properties();
                    properties.put("mail.store.protocol", "pop3");
                    properties.put("mail.pop3.host", pop3Server);

                    Session session = Session.getDefaultInstance(properties);

                    Store store = session.getStore("pop3");
                    store.connect(pop3Server, username, password);
                    Folder folder = store.getFolder("INBOX");
                    folder.open(Folder.READ_ONLY);

                    System.out.println("You succsefully Logged in!");
                    while(true){
                        System.out.println("----------------------------------");
                        System.out.println("What do you wanna do?");
                        System.out.println("(1) Get your total message count");
                        System.out.println("(2) List all your Messages");
                        System.out.println("(3) Get a specific Message");
                        System.out.println("(4) Logout");
                        System.out.println("----------------------------------");

                        decision = Integer.parseInt(scanner.nextLine());
                        Message[] messages = folder.getMessages();

                        switch(decision){
                            case 1:
                                System.out.println("Number of messages: " + messages.length);
                                break;
                            case 2:

                                for (int i = 0; i < messages.length; i++) {
                                    Message message = messages[i];
                                    System.out.println("Nachricht #" + (i + 1) + ":");
                                    System.out.println("Betreff: " + message.getSubject());
                                    System.out.println("Von: " + message.getFrom()[0]);
                                    System.out.println("Datum: " + message.getSentDate());
                                    System.out.println("-----------------------------------------");
                                }
                                break;
                            case 3:
                                System.out.print("Which Message do you want to print?");
                                int messageNum = scanner.nextInt();
                                if(messageNum > 0 && messageNum <= messages.length){
                                    Message message = messages[messageNum - 1];
                                    System.out.println("Nachricht #" + messageNum + ":");
                                    System.out.println("Betreff: " + message.getSubject());
                                    System.out.println("Von: " + message.getFrom()[0]);
                                    System.out.println("Datum: " + message.getSentDate());
                                    System.out.println("Inhalt: " + message.getContent());
                                    System.out.println("-----------------------------------------");
                                    String clear = scanner.nextLine();
                                }else{
                                    System.out.println("not a valid Messagenumber");
                                }
                                break;
                        }
                        if(decision == 4){
                            System.out.println("Logout...");
                            folder.close(false);
                            store.close();
                            break;
                        }
                        if(decision <= 0 || decision > 4){
                            System.out.println(decision+" is not a valid option.");
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(decision+" is not a valid option.");
            }
        }
    }
}
