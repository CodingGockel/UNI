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
        // sets default properties
        defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
        defaultProps.setProperty("mail.smtp.port", "587");
        defaultProps.setProperty("mail.user", "test@gmail.com");
        defaultProps.setProperty("mail.password", "secret");
        defaultProps.setProperty("mail.smtp.auth", "true");
        defaultProps.setProperty("sender.mail", "test@test.de");
        configProps = new Properties(defaultProps);

        // loads properties from file
        if (configFile.exists()) {
            InputStream inputStream = new FileInputStream(configFile);
            configProps.load(inputStream);
            inputStream.close();
        }

        return configProps;
    }

    public void saveProperties(String host, String port, String user, String pass, String sender, boolean ssl, boolean tls) throws IOException {
        configProps.setProperty("mail.smtp.host", host);
        configProps.setProperty("mail.smtp.port", port);
        configProps.setProperty("mail.user", user);
        configProps.setProperty("mail.password", pass);
        configProps.setProperty("mail.smtp.auth", "true");
        configProps.setProperty("sender.mail", sender);
        if(ssl){
            configProps.setProperty("mail.smtp.ssl.enable", "true");
        }else{
            configProps.remove("mail.smtp.ssl.enable");
        }
        if(tls){
            configProps.setProperty("mail.smtp.starttls.enable", "true");
        }else{
            configProps.remove("mail.smtp.starttls.enable");
        }

        OutputStream outputStream = new FileOutputStream(configFile);
        configProps.store(outputStream, "host setttings");
        outputStream.close();
    }
    public Properties getConfigProps(){
        return this.configProps;
    }
}