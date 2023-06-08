package Mile1;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;
public class Client {
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
                try {

                    Socket socket = new Socket(pop3Server, port);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String response;

                    out.println("USER " + username);
                    out.flush();
                    response = in.readLine();
                    out.println("PASS " + password);
                    out.flush();
                    response = in.readLine();
                    response = in.readLine();

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

                        switch(decision){
                            case 1:
                                out.println("STAT");
                                out.flush();
                                response = in.readLine();
                                String[] status = response.split(" ");
                                int numMessages = Integer.parseInt(status[1]);
                                int totalSize = Integer.parseInt(status[2]);
                                System.out.println("Number of Messages: " + numMessages);
                                break;
                            case 2:
                                out.println("LIST");
                                out.flush();
                                response = in.readLine();
                                while (!response.equals(".")) {
                                    System.out.println("Messagenumber: "+response.split(" ")[0]+"\t"+"Size: "+response.split(" ")[1]);
                                    response = in.readLine();
                                }
                                break;
                            case 3:
                                System.out.print("Which Message do you want to print?");
                                int messageNum = scanner.nextInt();
                                out.println("STAT");
                                out.flush();
                                response = in.readLine();
                                String[] stat = response.split(" ");
                                int numMes = Integer.parseInt(stat[1]);
                                if(messageNum > 0 && messageNum <= numMes){
                                    out.println("RETR " + messageNum);
                                    out.flush();
                                    response = in.readLine();
                                    while (!response.equals(".")) {
                                        System.out.println(response);
                                        response = in.readLine();
                                    }
                                    String clear = scanner.nextLine();
                                }else{
                                    System.out.println("not a valid Messagenumber");
                                }
                                break;
                        }
                        if(decision == 4){
                            System.out.println("Logout...");
                            out.println("QUIT");
                            out.flush();
                            socket.close();
                            break;
                        }
                        if(decision <= 0 || decision > 4){
                            System.out.println(decision+" is not a valid option.");
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(decision+" is not a valid option.");
            }
        }
    }

}