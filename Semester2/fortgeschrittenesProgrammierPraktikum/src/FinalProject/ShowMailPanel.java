package FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import javax.swing.event.*;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import java.util.List;
import javax.mail.internet.InternetAddress;
public class ShowMailPanel extends JFrame{
    private JTextArea emailTextArea;
    private Message message;
    public ShowMailPanel(Message m){
        this.message = m;
        try{
            setTitle(m.getSubject());
        }catch(MessagingException ex){
            ex.printStackTrace();
        }
        setPreferredSize(new Dimension(800, 600));

        this.emailTextArea = new JTextArea();
        this.emailTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(emailTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        StringBuilder emailContent = new StringBuilder();
        try {
            emailContent.append("Subject: ").append(this.message.getSubject()).append("\n");
            for (Address ad : m.getFrom()) {
                emailContent.append("From: ").append(ad.toString()).append("\n");
            }
            emailContent.append("To: ").append(InternetAddress.toString(this.message.getRecipients(Message.RecipientType.TO))).append("\n");
            emailContent.append("Date: ").append(this.message.getSentDate()).append("\n");
            if (m.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) m.getContent();
                emailContent.append(getTextFromMimeMultipart(mimeMultipart));
            }
            if (m.isMimeType("text/plain")) {
                emailContent.append(m.getContent().toString());
            }
        }catch(MessagingException |IOException ex){
            ex.printStackTrace();
        }

        this.emailTextArea.setText(emailContent.toString());
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null);
    }
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
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
    private String parseBodyPart(BodyPart bodyPart) throws MessagingException, IOException {
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
