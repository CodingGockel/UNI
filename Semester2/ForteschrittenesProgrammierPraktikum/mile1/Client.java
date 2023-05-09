import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;
public class Client {

   public static void main(String[] args) {
   
      Scanner scanner = new Scanner(System.in);
      
      /*System.out.print("POP3 Server: ");
      String pop3Server = scanner.nextLine();
      
      System.out.print("Username: ");
      String username = scanner.nextLine();
      
      System.out.print("Password: ");
      String password = scanner.nextLine();
      */
      String password = "16Moritz05.2004/UNI";
      String username = "du54tef";
      String pop3Server = "pop3.uni-jena.de";
      int port = 110;
      try {
         // Verbindung zum POP3-Server herstellen
         Socket socket = new Socket(pop3Server, port);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
         
         String response;
         // Anmeldung mit Benutzername und Passwort
         out.println("USER " + username);
         out.flush();
         response = in.readLine();
         System.out.println(response);
         out.println("PASS " + password);
         out.flush();
         response = in.readLine();
         System.out.println(response);
         response = in.readLine();
         System.out.println(response);
         // Status des Postfachs abrufen
         out.println("STAT");
         out.flush();
         response = in.readLine();
         String[] status = response.split(" ");
         int numMessages = Integer.parseInt(status[1]);
         int totalSize = Integer.parseInt(status[2]);
         
         System.out.println("Anzahl der Nachrichten: " + numMessages);
         System.out.println("Gesamtgröße: " + totalSize + " Bytes");
         //Liste der Nachrichten abrufen
         out.println("LIST");
         out.flush();
         response = in.readLine();
         while (!response.equals(".")) {
            System.out.println(response);
            response = in.readLine();
         }
         
         // Abrufen einer bestimmten Nachricht
         System.out.print("Welche Nachricht möchten Sie abrufen? ");
         int messageNum = scanner.nextInt();
         
         out.println("RETR " + messageNum);
         out.flush();
         response = in.readLine();
         while (!response.equals(".")) {
            System.out.println(response);
            response = in.readLine();
         }
         
         // Verbindung schließen
         System.out.println("quitting");
         out.println("QUIT");
         out.flush();
         socket.close();
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   
}