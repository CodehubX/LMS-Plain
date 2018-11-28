package com.sd.form.librarian;

import com.sd.dao.StudentDao;
import com.sd.support.util.Cache;
import com.sd.support.util.Util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddStudentsForm extends JFrame {
    
    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 110;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static AddStudentsForm frame;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldEmail;
    private JTextField textFieldAddress;
    private JTextField textFieldCity;
    private JTextField textFieldContact;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AddStudentsForm();
                    frame.setVisible(true);
                    frame.setTitle("Add Student");
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddStudentsForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 380, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblName = new JLabel("Name:");

        JLabel lblEmail = new JLabel("Email:");

        JLabel lblAddress = new JLabel("Address:");

        JLabel lblCity = new JLabel("City:");

        JLabel lblContact = new JLabel("Contact:");

        textFieldName = new JTextField();
        textFieldName.setColumns(10);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);

        textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);

        textFieldCity = new JTextField();
        textFieldCity.setColumns(10);

        textFieldContact = new JTextField();
        textFieldContact.setColumns(10);

        JButton btnAddStudent = new JButton("Add Student");
        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String email = textFieldEmail.getText();
                String address = textFieldAddress.getText();
                String city = textFieldCity.getText();
                String contact = textFieldContact.getText();
                int id = StudentDao.save(name, email, address, city, contact, Integer.parseInt(Cache.get("librarianId")));
                if (id > -1) {
                    JOptionPane.showMessageDialog(AddStudentsForm.this, "Student added. ID = " + id);
                    //LibrarianPanel.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(AddStudentsForm.this, "Sorry, unable to save!");
                }
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(lblName)
                                                .addComponent(lblEmail)
                                                .addComponent(lblAddress)
                                                .addComponent(lblCity)
                                                .addComponent(lblContact))
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(textFieldContact, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                .addGroup(Alignment.CENTER, gl_contentPane.createSequentialGroup()
                        .addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblName)
                                .addComponent(textFieldName))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblEmail)
                                .addComponent(textFieldEmail))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblAddress)
                                .addComponent(textFieldAddress))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblCity)
                                .addComponent(textFieldCity))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblContact)
                                .addComponent(textFieldContact))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(btnAddStudent, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE))
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }

}
