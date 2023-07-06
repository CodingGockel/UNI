package FinalProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import java.util.List;

class MailList extends JPanel implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;
    private ConfigUtility configUtil;
    private List<Message> messages;
    private JButton showMailButton;
    private JButton updateButton;
    private HashMap<Integer,Message> messageMap;
    public MailList(ConfigUtility configUtil){
        super(new BorderLayout());
        this.configUtil = configUtil;
        this.messages = new ArrayList<>();
        this.listModel = new DefaultListModel();
        this.messageMap = new HashMap<>();
        try{
            this.configUtil.loadProperties();
            this.messages = EmailUtility.getAllMailsFromServer(this.configUtil.getConfigProps());
            Collections.reverse(this.messages);
            int i = 0;
            for(Message m:this.messages){
                if(m.getFlags().contains(Flags.Flag.RECENT)){
                    this.listModel.addElement("[NEW]" + m.getSubject());
                }else{
                    this.listModel.addElement(m.getSubject());
                }
                messageMap.put(i, m);
                i++;
            }
        }catch(MessagingException | IOException ex){
            ex.printStackTrace();
        }
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(this.list);

        this.updateButton = new JButton("Update");
        this.updateButton.setActionCommand("Update");
        this.updateButton.addActionListener(new UpdateListener());

        this.showMailButton = new JButton("Show");
        this.showMailButton.setActionCommand("Show");
        this.showMailButton.addActionListener(new ShowListener());

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(this.updateButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(this.showMailButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    class ShowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            ShowMailPanel mailPanel = new ShowMailPanel(messageMap.get(index));
            mailPanel.setVisible(true);
            int size = listModel.getSize();
            if (size == 0) {
                showMailButton.setEnabled(false);
            }
        }
    }
    class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                listModel.clear();
                configUtil.loadProperties();
                messages = EmailUtility.getAllMailsFromServer(configUtil.getConfigProps());
                Collections.reverse(messages);
                int i = 0;
                for(Message m:messages){
                    if(m.getFlags().contains(Flags.Flag.RECENT)){
                        listModel.addElement("[NEW]" + m.getSubject());
                    }else {
                        listModel.addElement(m.getSubject());
                    }
                    messageMap.put(i, m);
                    i++;
                }
            }catch(MessagingException | IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                showMailButton.setEnabled(false);

            } else {
                showMailButton.setEnabled(true);
            }
        }

    }
}
