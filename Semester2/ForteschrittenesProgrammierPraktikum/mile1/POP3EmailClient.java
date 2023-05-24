import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import java.io.*;
public class POP3EmailClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        // POP3-Server-Einstellungen
        System.out.print("POP3-Server: ");
        String pop3Server = scanner.nextLine();

        System.out.print("Benutzername: ");
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
            // Verbindungseinstellungen konfigurieren
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "pop3");
            properties.put("mail.pop3.host", pop3Server);

            // Sitzung erstellen
            Session session = Session.getDefaultInstance(properties);

            // Store und Ordner für den POP3-Zugriff öffnen
            Store store = session.getStore("pop3");
            store.connect(pop3Server, username, password);
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // Nachrichten abrufen
            Message[] messages = folder.getMessages();
            System.out.println("Anzahl der Nachrichten: " + messages.length);

            // Nachrichteninformationen anzeigen
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("Nachricht #" + (i + 1) + ":");
                System.out.println("Betreff: " + message.getSubject());
                System.out.println("Von: " + message.getFrom()[0]);
                System.out.println("Datum: " + message.getSentDate());
                System.out.println("-----------------------------------------");
            }

            // Abrufen einer bestimmten Nachricht
            System.out.println("Welche Nachricht möchten Sie abrufen? (Geben Sie die Nummer ein, oder -1 zum Beenden): ");
            int messageNum = scanner.nextInt();
            while (messageNum != -1) {
                if (messageNum > 0 && messageNum <= messages.length) {
                    Message message = messages[messageNum - 1];
                    System.out.println("Nachricht #" + messageNum + ":");
                    System.out.println("Betreff: " + message.getSubject());
                    System.out.println("Von: " + message.getFrom()[0]);
                    System.out.println("Datum: " + message.getSentDate());
                    System.out.println("Inhalt: " + message.getContent());
                    System.out.println("-----------------------------------------");
                } else {
                    System.out.println("Ungültige Nachrichtennummer!");
                }

                System.out.println("Welche Nachricht möchten Sie abrufen? (Geben Sie die Nummer ein, oder -1 zum Beenden): ");
                messageNum = scanner.nextInt();
            }

            // Verbindung schließen
            System.out.println("quitting...");
            folder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
