package FinalProject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigUtility {
    private File configFile = new File("smtp.properties");
    private Properties configProps;

    public Properties loadProperties() throws IOException {
        Properties defaultProps = new Properties();
        defaultProps.setProperty("mail.store.protocol", "imaps");
        defaultProps.setProperty("mail.imaps.host", "imap.gmail.com");
        defaultProps.setProperty("mail.imaps.port", "993");
        defaultProps.setProperty("mail.imaps.ssl.enable", "true");
        defaultProps.setProperty("mail.pop3s.host", "pop3.gmail.com");
        defaultProps.setProperty("mail.pop3s.port", "995");
        defaultProps.setProperty("mail.pop3s.ssl.enable", "true");
        defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
        defaultProps.setProperty("mail.smtp.port", "587");
        defaultProps.setProperty("mail.user", "test@gmail.com");
        defaultProps.setProperty("mail.password", "secret");
        defaultProps.setProperty("mail.smtp.auth", "true");
        defaultProps.setProperty("sender.mail", "test@test.de");
        defaultProps.setProperty("isIMAP", "true");
        defaultProps.setProperty("archive.path", "mails\\");
        this.configProps = new Properties(defaultProps);

        if (this.configFile.exists()) {
            InputStream inputStream = new FileInputStream(this.configFile);
            this.configProps.load(inputStream);
            inputStream.close();
        }

        return this.configProps;
    }
    public void saveProperties(String hostIn, String portIn, String hostOut, String portOut, String user, String pass, String sender, boolean ssl, boolean tls, boolean isIMAP, String archivePath) throws IOException {
        if(isIMAP){
            this.configProps.setProperty("mail.store.protocol", "imaps");
            this.configProps.setProperty("mail.imaps.host", hostOut);
            this.configProps.setProperty("isIMAP", "true");
        }else{
            this.configProps.setProperty("mail.store.protocol", "pop3s");
            this.configProps.setProperty("mail.pop3s.host", hostOut);
            this.configProps.setProperty("isIMAP", "false");
        }
        this.configProps.setProperty("mail.imaps.port", portOut);
        this.configProps.setProperty("mail.pop3s.port", portOut);
        this.configProps.setProperty("mail.smtp.host", hostIn);
        this.configProps.setProperty("mail.smtp.port", portIn);
        this.configProps.setProperty("mail.user", user);
        this.configProps.setProperty("mail.password", pass);
        this.configProps.setProperty("mail.smtp.auth", "true");
        this.configProps.setProperty("sender.mail", sender);
        if(ssl){
            this.configProps.setProperty("mail.smtp.ssl.enable", "true");
            this.configProps.setProperty("mail.imaps.ssl.enable", "true");
            this.configProps.setProperty("mail.pop3s.ssl.enable", "true");
        }else{
            this.configProps.setProperty("mail.smtp.ssl.enable","false");
            this.configProps.setProperty("mail.imaps.ssl.enable","false");
            this.configProps.setProperty("mail.pop3s.ssl.enable","false");
        }
        if(tls){
            this.configProps.setProperty("mail.smtp.starttls.enable", "true");
        }else{
            this.configProps.setProperty("mail.smtp.starttls.enable","false");
        }
        this.configProps.setProperty("archive.path", archivePath);

        OutputStream outputStream = new FileOutputStream(this.configFile);
        this.configProps.store(outputStream, "host setttings");
        outputStream.close();
    }
    public Properties getConfigProps(){
        return this.configProps;
    }
}