package com.sd.form.admin;

import com.sd.dao.LibrarianDao;
import com.sd.support.util.Util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLibrarianForm extends JFrame {
    
    private final int BUTTON_HEIGHT = 32;
    private final int BUTTON_WIDTH = 140;
    private final int MARGIN_GAP = 18;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static AddLibrarianForm frame;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldEmail;
    private JTextField textFieldAddress;
    private JTextField textFieldCity;
    private JTextField textFieldContactNo;
    private JPasswordField textFieldPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AddLibrarianForm();
                    frame.setVisible(true);
                    frame.setTitle("Add Librarian");
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
    public AddLibrarianForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 360, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblName = new JLabel("Name:");

        JLabel lblPassword = new JLabel("Password:");

        JLabel lblEmail = new JLabel("Email:");

        JLabel lblAddress = new JLabel("Address:");

        JLabel lblCity = new JLabel("City:");

        JLabel lblContactNo = new JLabel("Contact No:");

        textFieldName = new JTextField();
        textFieldName.setColumns(10);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);

        textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);

        textFieldCity = new JTextField();
        textFieldCity.setColumns(10);

        textFieldContactNo = new JTextField();
        textFieldContactNo.setColumns(10);

        textFieldPassword = new JPasswordField();

        JButton btnNewButton = new JButton("Add Librarian");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
                String email = textFieldEmail.getText();
                String address = textFieldAddress.getText();
                String city = textFieldCity.getText();
                String contact = textFieldContactNo.getText();

                int id = LibrarianDao.save(name, password, email, address, city, contact);
                if (id > -1) {
                    JOptionPane.showMessageDialog(AddLibrarianForm.this, "Librarian added. ID = " + id);
                } else {
                    JOptionPane.showMessageDialog(AddLibrarianForm.this, "Sorry, unable to add!");
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, LABEL_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName)
                                        .addComponent(lblEmail)
                                        .addComponent(lblAddress)
                                        .addComponent(lblCity)
                                        .addComponent(lblContactNo))
                                .addGap(2*MARGIN_GAP)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(textFieldContactNo, GroupLayout.DEFAULT_SIZE, TEXTBOX_WIDTH, Short.MAX_VALUE)
                                        .addComponent(textFieldCity)
                                        .addComponent(textFieldAddress)
                                        .addComponent(textFieldEmail)
                                        .addComponent(textFieldName)
                                        .addComponent(textFieldPassword))
                                .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                        )
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                        )
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(textFieldName))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblPassword)
                                        .addComponent(textFieldPassword))
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
                                        .addComponent(lblContactNo)
                                        .addComponent(textFieldContactNo))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                //.addContainerGap()
                        )
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }

}
