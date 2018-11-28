package com.sd.form.admin;

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
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminLoginForm extends JFrame {

    private final int BUTTON_HEIGHT = 32;
    private final int BUTTON_WIDTH = 90;
    private final int MARGIN_GAP = 18;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    static AdminLoginForm frame;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JPasswordField textFieldPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AdminLoginForm();
                    frame.setVisible(true);
                    frame.setTitle("Admin Login");
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
    public AdminLoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 380, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblEnterName = new JLabel("Enter Name:");

        JLabel lblEnterPassword = new JLabel("Enter Password:");

        textFieldName = new JTextField();
        textFieldName.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
                if (name.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    AdminPanel.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(AdminLoginForm.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    textFieldName.setText("");
                    textFieldPassword.setText("");
                }
            }
        });

        textFieldPassword = new JPasswordField();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblEnterName)
                                        .addComponent(lblEnterPassword))
                                .addGap(2*MARGIN_GAP)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(textFieldPassword)
                                        .addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                )
                                .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                        )
                        .addGroup(Alignment.CENTER, gl_contentPane.createSequentialGroup()
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                        )
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblEnterName)
                                        .addComponent(textFieldName))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblEnterPassword)
                                        .addComponent(textFieldPassword))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                //.addContainerGap()
                        )
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }
}
