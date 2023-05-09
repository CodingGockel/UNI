import java.io.*;
import java.net.*;
import java.util.*;

public class Pop3Server {
   
   private static final int PORT = 110;
   private static final String USERNAME = "username";
   private static final String PASSWORD = "password";
   
   public static void main(String[] args) {
   
      try {
         // Server-Socket erstellen und auf eingehende Verbindungen warten
         ServerSocket serverSocket = new ServerSocket(PORT);
         System.out.println("POP3-Server gestartet auf Port " + PORT);
         Socket socket = serverSocket.accept();
         System.out.println("Verbindung hergestellt mit " + socket.getInetAddress().getHostName());
         
         // Ein- und Ausgabe-Streams erstellen
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
         
         // Anmeldung mit Benutzername und Passwort
         out.println("+OK POP3-Server bereit");
         out.flush();
         
         String response = in.readLine();
         if (response.startsWith("USER")) {
            String[] tokens = response.split(" ");
            if (tokens[1].equals(USERNAME)) {
               out.println("+OK Benutzername akzeptiert");
               out.flush();
               response = in.readLine();
               if (response.startsWith("PASS")) {
                  tokens = response.split(" ");
                  if (tokens[1].equals(PASSWORD)) {
                     out.println("+OK Anmeldung erfolgreich");
                     out.flush();
                  } else {
                     out.println("-ERR Passwort ungültig");
                     out.flush();
                     socket.close();
                     return;
                  }
               } else {
                  out.println("-ERR Passwort erforderlich");
                  out.flush();
                  socket.close();
                  return;
               }
            } else {
               out.println("-ERR Benutzername unbekannt");
               out.flush();
               socket.close();
               return;
            }
         } else {
            out.println("-ERR Benutzername erforderlich");
            out.flush();
            socket.close();
            return;
         }
         
         // Nachrichtenliste senden
         out.println("+OK " + getNumMessages() + " Nachricht(en) im Postfach");
         out.flush();
         for (int i = 1; i <= getNumMessages(); i++) {
            out.println(i + " " + getMessageSize(i));
            out.flush();
         }
         out.println(".");
         out.flush();
         
         // Nachricht abrufen
         response = in.readLine();
         if (response.startsWith("RETR")) {
            String[] tokens = response.split(" ");
            int messageNum = Integer.parseInt(tokens[1]);
            out.println(getMessage(messageNum));
            out.flush();
            out.println(".");
            out.flush();
         }
         
         // Verbindung schließen
         out.println("+OK POP3-Server beendet");
         out.flush();
         socket.close();
         serverSocket.close();
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   
   private static int getNumMessages() {
      return 2;
   }
   
   private static int getMessageSize(int messageNum) {
      return 30;
   }
   
   private static String getMessage(int messageNum) {
      return "hallo";
   }
   
}
