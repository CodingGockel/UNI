package FinalProject;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Array;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.search.FlagTerm;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.mail.internet.MimeMultipart;
public class test{
    public static String saveDirectory = "C:\\Users\\pc\\Desktop\\Github\\UNI\\Semester2\\fortgeschrittenesProgrammierPraktikum\\src\\FinalProject\\mails\\"; // Directory to save emails

    public static void main(String[] args) throws IOException {
        ConfigUtility configUtil = new ConfigUtility();
        configUtil.loadProperties();
        Properties props = configUtil.getConfigProps();
        List<Message> messages = new ArrayList<>();
        try {
            messages = EmailUtility.getAllMailsFromServer(props);
            for(Message m : messages){
                EmailUtility.saveMail(m,saveDirectory);
                System.out.println(m.getSubject());
                for(Address ad: m.getFrom()){
                    System.out.println(ad.toString());
                }
                System.out.println(m.getSentDate());
                if (m.isMimeType("multipart/*")) {
                    MimeMultipart mimeMultipart = (MimeMultipart) m.getContent();
                    System.out.println(getTextFromMimeMultipart(mimeMultipart));
                }
                if (m.isMimeType("text/plain")) {
                    System.out.println(m.getContent().toString());
                }
                System.out.println("-----------------------------------------------------------------------------------");
            }
            System.out.println("################################################################################################");
            messages = EmailUtility.getStoredMessages(saveDirectory);
            messages = EmailUtility.sortByDate(messages);
            for(Message m : messages){
                EmailUtility.saveMail(m,saveDirectory);
                System.out.println(m.getSubject());
                for(Address ad: m.getFrom()){
                    System.out.println(ad.toString());
                }
                System.out.println(m.getSentDate());
                if (m.isMimeType("multipart/*")) {
                    MimeMultipart mimeMultipart = (MimeMultipart) m.getContent();
                    System.out.println(getTextFromMimeMultipart(mimeMultipart));
                }
                if (m.isMimeType("text/plain")) {
                    System.out.println(m.getContent().toString());
                }
                System.out.println("-----------------------------------------------------------------------------------");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                return result + "\n" + bodyPart.getContent(); // without return, same text appears twice in my tests
            }
            result += parseBodyPart(bodyPart);
        }
        return result;
    }
    private static String parseBodyPart(BodyPart bodyPart) throws MessagingException, IOException {
        if (bodyPart.isMimeType("text/html")) {
            return "\n" + org.jsoup.Jsoup
                    .parse(bodyPart.getContent().toString())
                    .text();
        }
        if (bodyPart.getContent() instanceof MimeMultipart){
            return getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
        }

        return "";
    }
}
