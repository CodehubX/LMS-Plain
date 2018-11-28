package com.sd.form.librarian;

import com.sd.dao.LibrarianDao;
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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;

public class LibrarianLoginForm extends JFrame {

    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 80;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static LibrarianLoginForm frame;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new LibrarianLoginForm();
                    frame.setVisible(true);
                    frame.setTitle("Librarian Login");
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
    public LibrarianLoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 360, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblEnterName = new JLabel("ID");

        JLabel lblEnterPassword = new JLabel("Password");

        textField = new JTextField();
        textField.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                //System.out.println(name+" "+password);
                if (LibrarianDao.validate(id, password)) {
                    Cache.add("librarianId", id);
                    LibrarianPanel.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(LibrarianLoginForm.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                    passwordField.setText("");
                }
            }
        });

        passwordField = new JPasswordField();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.CENTER)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblEnterName)
                                                .addComponent(lblEnterPassword))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, TEXTBOX_WIDTH, Short.MAX_VALUE)
                                                .addComponent(textField, GroupLayout.DEFAULT_SIZE, TEXTBOX_WIDTH, Short.MAX_VALUE)))
                                .addContainerGap()
                        )
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblEnterName)
                                        .addComponent(textField))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblEnterPassword)
                                        .addComponent(passwordField))
                                .addGap(20)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE))
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }
}
