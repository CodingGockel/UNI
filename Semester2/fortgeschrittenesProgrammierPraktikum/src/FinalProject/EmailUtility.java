package FinalProject;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {
    public static void sendMail(Properties props, String toAdresses, String subject, String body, File[] attachFiles) throws AddressException, MessagingException, IOException{
        final String username = props.getProperty("mail.user");
        final String password = props.getProperty("mail.password");
        final String fromAdress = props.getProperty("sender.mail");
        String[] toAdress = toAdresses.split(",");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAdress));

            InternetAddress[] recipientAddresses = new InternetAddress[toAdress.length];
            for (int i = 0; i < toAdress.length; i++) {
                recipientAddresses[i] = new InternetAddress(toAdress[i]);
            }

            message.setRecipients(Message.RecipientType.TO, recipientAddresses);
            message.setSubject(subject);
            message.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if (attachFiles != null && attachFiles.length > 0) {
                for (File aFile : attachFiles) {
                    MimeBodyPart attachPart = new MimeBodyPart();

                    try {
                        attachPart.attachFile(aFile);
                    } catch (IOException ex) {
                        throw ex;
                    }

                    multipart.addBodyPart(attachPart);
                }
            }
            message.setContent(multipart);;

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Message> getAllMailsFromServer(Properties props) throws MessagingException{
        List<Message> messages = new ArrayList<>();

        try {
            Session session = Session.getDefaultInstance(props);
            Store store = session.getStore();
            if(props.getProperty("isIMAP").equals("true")){
                store.connect(props.getProperty("mail.imaps.host"), Integer.valueOf(props.getProperty("mail.imaps.port")), props.getProperty("mail.user"), props.getProperty("mail.password"));
            }else{
                store.connect(props.getProperty("mail.pop3s.host"), Integer.valueOf(props.getProperty("mail.pop3s.port")), props.getProperty("mail.user"), props.getProperty("mail.password"));
            }
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messagesInFolder = inbox.getMessages();
            for(Message m: messagesInFolder){
                messages.add(new MimeMessage((MimeMessage) m));
                saveMail(m,props.getProperty("archive.path"));
            }
            inbox.close(false);
            store.close();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

        return messages;
    }
    public static List<Message> getStoredMessages(String path) throws Exception {

        List<Message> messages = new ArrayList<>();

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File[] existingFiles = directory.listFiles();

        for(File f:existingFiles){
            InputStream is = new FileInputStream(path+f.getName());
            messages.add(new MimeMessage(null, is));
        }

        return messages;
    }
    public static void saveMail(Message message, String path) {
        try {
            Message m = message;
            String filename = path + message.getSubject().replaceAll("[^a-zA-Z0-9]", "") + "_" + message.getSentDate().toString().replaceAll("[^a-zA-Z0-9]", "_") + ".eml";
            m.writeTo(new FileOutputStream(new File(filename)));
        } catch (MessagingException | IOException ex) {
            ex.printStackTrace();
        }
    }
    public static List<Message> sortByDate(List<Message> messages){
        messages.sort(new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                try {
                    return m1.getSentDate().compareTo(m2.getSentDate());
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return messages;
    }
}