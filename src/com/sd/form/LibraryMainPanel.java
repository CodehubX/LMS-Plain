package com.sd.form;


import com.sd.form.student.StudentLoginForm;
import com.sd.form.librarian.LibrarianLoginForm;
import com.sd.form.admin.AdminLoginForm;
import com.sd.support.util.Util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class LibraryMainPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private final int BUTTON_HEIGHT = 52;
    private final int BUTTON_WIDTH = 140;
    private final int BUTTON_GAP = 18;
    private final int MARGIN_GAP = 100;
    
    static LibraryMainPanel frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex1) {
            }
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new LibraryMainPanel();
                    frame.setVisible(true);
                    frame.setTitle("Library Management");
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
    public LibraryMainPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        

        JButton btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminLoginForm.main(new String[]{});
                frame.dispose();
            }
        });
        btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnLibrarianLogin = new JButton("Librarian Login");
        btnLibrarianLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LibrarianLoginForm.main(new String[]{});
                frame.dispose();
            }
        });
        btnLibrarianLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnStudentLogin = new JButton("Student Login");
        btnStudentLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentLoginForm.main(new String[]{});
                frame.dispose();
            }
        });
        btnStudentLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(btnStudentLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, BUTTON_WIDTH, Short.MAX_VALUE)
                                                        .addComponent(btnLibrarianLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, BUTTON_WIDTH, Short.MAX_VALUE)
                                                        .addComponent(btnAdminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, BUTTON_WIDTH, Short.MAX_VALUE)
                                                )
                                        )
                                )
                                .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                        )
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGap(100)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(BUTTON_GAP)
                                .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addGap(BUTTON_GAP)
                                .addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addGap(BUTTON_GAP)
                                .addComponent(btnStudentLogin, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addGap(BUTTON_GAP)
                        )
                                .addGap(100)
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }
}
