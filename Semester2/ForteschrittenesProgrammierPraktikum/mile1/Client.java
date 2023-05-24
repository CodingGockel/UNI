import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;
public class Client {
   
    
    
   public static void main(String[] args) {
      String password;
      Scanner scanner = new Scanner(System.in);
      Boolean isConnected = false;
      while(true){
          if(!isConnected){
              System.out.println("You are not Connected. You need to Login: ");
              System.out.print("POP3 Server: ");
              String pop3Server = scanner.nextLine();
            
              System.out.print("Port: ");
              int port = Integer.parseInt(scanner.nextLine());
      
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
          }
      }
      
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
            System.out.println("Nachrichtennummer: "+response.split(" ")[0]+"\t"+"Größe: "+response.split(" ")[1]);
            response = in.readLine();
         }
         
         // Abrufen einer bestimmten Nachricht
         System.out.print("Welche Nachricht möchten Sie abrufen? Oder möchten Sie Beenden (-1)?");
         int messageNum = scanner.nextInt();
         while(messageNum != -1){
             out.println("RETR " + messageNum);
             out.flush();
             response = in.readLine();
             while (!response.equals(".")) {
                System.out.println(response);
                response = in.readLine();
             }
             System.out.print("Welche Nachricht möchten Sie abrufen? Oder möchten Sie Beenden (-1)?");
             messageNum = scanner.nextInt();
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