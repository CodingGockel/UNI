package FinalProject;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import javax.swing.*;

public class SettingsDialog extends JDialog {

    private ConfigUtility configUtil;
    private JLabel labelHost = new JLabel("Host out name: ");
    private JLabel labelPort = new JLabel("Port out number: ");
    private JLabel labelHostIn = new JLabel("Host in name: ");
    private JLabel labelCheckIMAP = new JLabel("IMAP: ");
    private JCheckBox checkIMAP = new JCheckBox(" ");
    private JLabel labelPortIn = new JLabel("Port in number: ");
    private JLabel labelUser = new JLabel("Username: ");
    private JLabel labelPass = new JLabel("Password: ");
    private JLabel labelSender = new JLabel("Sender Mail: ");
    private JLabel labelSSL = new JLabel("SSL: ");
    private JLabel labelTLS = new JLabel("TLS: ");
    private JLabel labelArchivePath = new JLabel("Archive: ");
    private JTextField textHost = new JTextField(20);
    private JTextField textPort = new JTextField(20);
    private JTextField textHostIn = new JTextField(20);
    private JTextField textPortIn = new JTextField(20);
    private JTextField textUser = new JTextField(20);
    private JPasswordField textPass = new JPasswordField(20);
    private JTextField textSender = new JTextField(30);
    private JCheckBox checkSSL = new JCheckBox(" ");
    private JCheckBox checkTLS = new JCheckBox(" ");
    private JTextField textArchivePath = new JTextField(20);
    private JButton buttonSave = new JButton("Save");

    public SettingsDialog(JFrame parent, ConfigUtility configUtil) {
        super(parent, "SMTP Settings", true);
        this.configUtil = configUtil;
        setupForm();
        loadSettings();
        pack();
        setLocationRelativeTo(null);
    }

    private void setupForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(11, 11, 11, 11);
        constraints.anchor = GridBagConstraints.WEST;

        add(labelHost, constraints);

        constraints.gridx = 1;
        add(textHost, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        add(labelPort, constraints);

        constraints.gridx = 1;
        add(textPort, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        add(labelHostIn, constraints);

        constraints.gridx = 1;
        add(textHostIn, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        add(labelCheckIMAP, constraints);

        constraints.gridx = 1;
        add(checkIMAP, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        add(labelPortIn, constraints);

        constraints.gridx = 1;
        add(textPortIn, constraints);

        constraints.gridy = 5;
        constraints.gridx = 0;
        add(labelUser, constraints);

        constraints.gridx = 1;
        add(textUser, constraints);

        constraints.gridy = 6;
        constraints.gridx = 0;
        add(labelPass, constraints);

        constraints.gridx = 1;
        add(textPass, constraints);

        constraints.gridy = 7;
        constraints.gridx = 0;
        add(labelSender, constraints);

        constraints.gridx = 1;
        add(textSender, constraints);

        constraints.gridy = 8;
        constraints.gridx = 0;
        add(labelSSL, constraints);

        constraints.gridx = 1;
        add(checkSSL, constraints);

        constraints.gridy = 9;
        constraints.gridx = 0;
        add(labelTLS, constraints);

        constraints.gridx = 1;
        add(checkTLS, constraints);

        constraints.gridy = 10;
        constraints.gridx = 0;
        add(labelArchivePath, constraints);

        constraints.gridx = 1;
        add(textArchivePath, constraints);

        constraints.gridy = 11;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(buttonSave, constraints);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonSaveActionPerformed(event);
            }
        });
    }

    private void loadSettings() {
        Properties configProps = null;
        try {
            configProps = this.configUtil.loadProperties();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error reading settings: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.textHost.setText(configProps.getProperty("mail.smtp.host"));
        this.textPort.setText(configProps.getProperty("mail.smtp.port"));
        if(configProps.getProperty("isIMAP").equals("true")){
            this.checkIMAP.setSelected(true);
            this.textHostIn.setText(configProps.getProperty("mail.imaps.host"));
            this.textPortIn.setText(configProps.getProperty("mail.imaps.port"));
        }else{
            this.checkIMAP.setSelected(false);
            this.textHostIn.setText(configProps.getProperty("mail.pop3s.host"));
            this.textPortIn.setText(configProps.getProperty("mail.pop3s.port"));
        }
        this.textUser.setText(configProps.getProperty("mail.user"));
        this.textPass.setText(configProps.getProperty("mail.password"));
        this.textSender.setText(configProps.getProperty("sender.mail"));

        if(configProps.getProperty("mail.smtp.ssl.enable").equals("true")){
            this.checkSSL.setSelected(true);
        }else{
            this.checkSSL.setSelected(false);
        }
        if(configProps.getProperty("mail.smtp.starttls.enable").equals("true")){
            this.checkTLS.setSelected(true);
        }else{
            this.checkTLS.setSelected(false);
        }
        this.textArchivePath.setText(configProps.getProperty("archive.path"));
    }

    private void buttonSaveActionPerformed(ActionEvent event) {
        try {
            this.configUtil.saveProperties(this.textHost.getText(),
                    this.textPort.getText(),
                    this.textHostIn.getText(),
                    this.textPortIn.getText(),
                    this.textUser.getText(),
                    new String(this.textPass.getPassword()),
                    this.textSender.getText(),
                    this.checkSSL.isSelected(),
                    this.checkTLS.isSelected(),
                    this.checkIMAP.isSelected(),
                    this.textArchivePath.getText());
            JOptionPane.showMessageDialog(SettingsDialog.this,
                    "Properties were saved successfully!");
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving properties file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
