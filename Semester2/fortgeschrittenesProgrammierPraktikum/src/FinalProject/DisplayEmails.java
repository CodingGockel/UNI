package FinalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DisplayEmails extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuItemSetting = new JMenuItem("Settings");
    private JMenuItem menuNewMail = new JMenuItem("New Mail");
    private GridBagConstraints constraints = new GridBagConstraints();
    private MailList mailList;
    private ConfigUtility configUtil = new ConfigUtility();
    public DisplayEmails(){
        super("Moritz's E-Mail Program");
        setLayout(new GridBagLayout());
        this.constraints.anchor = GridBagConstraints.WEST;
        this.constraints.insets = new Insets(5, 5, 5, 5);
        this.setupMenu();
        this.mailList = new MailList(this.configUtil);
        this.add(this.mailList);
        this.pack();
        this.setLocationRelativeTo(null);    // center on screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void setupMenu() {
        this.menuItemSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                SettingsDialog dialog = new SettingsDialog(DisplayEmails.this, configUtil);
                dialog.setVisible(true);
            }
        });
        this.menuNewMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                EmailSenderDialog dialog = new EmailSenderDialog(DisplayEmails.this, configUtil);
                dialog.setVisible(true);
            }
        });
        this.menuFile.add(this.menuNewMail);
        this.menuFile.add(this.menuItemSetting);
        this.menuBar.add(this.menuFile);
        this.setJMenuBar(this.menuBar);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisplayEmails().setVisible(true);
            }
        });
    }
}