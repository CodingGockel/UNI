package FinalProject;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;

import javax.swing.*;

public class EmailSenderDialog extends JDialog {
    private ConfigUtility configUtil;
    private JLabel labelFrom = new JLabel("From: ");
    private JLabel labelTo = new JLabel("To: ");
    private JLabel labelSubject = new JLabel("Subject: ");
    private JTextField fieldFrom = new JTextField(30);
    private JTextField fieldTo = new JTextField(30);
    private JTextField fieldSubject = new JTextField(30);
    private JButton buttonSend = new JButton("SEND");
    private JFilePicker filePicker = new JFilePicker("Attached", "Attach File");
    private JTextArea textAreaMessage = new JTextArea(10, 30);
    private GridBagConstraints constraints = new GridBagConstraints();

    public EmailSenderDialog(JFrame parent, ConfigUtility configUtil) {
        super(parent, "New E-Mail", true);
        this.configUtil = configUtil;
        setLayout(new GridBagLayout());
        this.constraints.anchor = GridBagConstraints.WEST;
        this.constraints.insets = new Insets(5, 5, 5, 5);
        this.setupForm();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void setupForm() {
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.add(labelFrom, constraints);

        this.constraints.gridx = 1;
        this.constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(fieldFrom, constraints);

        Properties props = getProps();
        if(props != null){
            this.fieldFrom.setText(props.getProperty("sender.mail"));
        }

        this.constraints.gridx = 0;
        this.constraints.gridy = 1;
        this.add(labelTo, constraints);

        this.constraints.gridx = 1;
        this.constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(fieldTo, constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.add(labelSubject, constraints);

        this.constraints.gridx = 1;
        this.constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(fieldSubject, constraints);

        this.constraints.gridx = 2;
        this.constraints.gridy = 0;
        this.constraints.gridheight = 2;
        this.constraints.fill = GridBagConstraints.BOTH;
        this.buttonSend.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(buttonSend, constraints);

        this.buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonSendActionPerformed(event);
                EmailSenderDialog.this.dispose();
            }
        });

        this.constraints.gridx = 0;
        this.constraints.gridy = 3;
        this.constraints.gridheight = 1;
        this.constraints.gridwidth = 3;
        this.filePicker.setMode(JFilePicker.MODE_OPEN);
        this.add(filePicker, constraints);

        this.constraints.gridy = 4;
        this.constraints.weightx = 1.0;
        this.constraints.weighty = 1.0;

        this.add(new JScrollPane(textAreaMessage), constraints);
    }

    private void buttonSendActionPerformed(ActionEvent event) {
        if (!validateFields()) {
            return;
        }

        String toAddress = fieldTo.getText();
        String subject = fieldSubject.getText();
        String message = textAreaMessage.getText();

        File[] attachFiles = null;

        if (!filePicker.getSelectedFilePath().equals("")) {
            File selectedFile = new File(filePicker.getSelectedFilePath());
            attachFiles = new File[] {selectedFile};
        }

        try {
            this.configUtil.getConfigProps().setProperty("sender.mail", fieldFrom.getText());
            Properties smtpProperties = configUtil.loadProperties();
            EmailUtility.sendMail(smtpProperties, toAddress, subject, message, attachFiles);

            JOptionPane.showMessageDialog(this,
                    "The e-mail has been sent successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error while sending the e-mail: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateFields() {
        if (fieldTo.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter To address!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            this.fieldTo.requestFocus();
            return false;
        }

        if (fieldSubject.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter subject!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            this.fieldSubject.requestFocus();
            return false;
        }

        if (textAreaMessage.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter message!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            this.textAreaMessage.requestFocus();
            return false;
        }

        return true;
    }
    private Properties getProps(){
        try{
            return configUtil.loadProperties();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
