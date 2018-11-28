package com.sd.form.admin;

import com.sd.form.LibraryMainPanel;
import com.sd.support.util.Util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

public class AdminPanel extends JFrame {
    
    private final int BUTTON_HEIGHT = 50;
    private final int BUTTON_WIDTH = 180;
    private final int MARGIN_GAP = 80;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static AdminPanel frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AdminPanel();
                    frame.setVisible(true);
                    frame.setTitle("Admin Panel");
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
    public AdminPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 470, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JButton btnNewButton = new JButton("Add Librarian");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddLibrarianForm.main(new String[]{});
            }
        });

        JButton btnViewLibrarian = new JButton("View Librarian");
        btnViewLibrarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ViewLibrarianList.main(new String[]{});
            }
        });
        btnViewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnDeleteLibrarian = new JButton("Delete Librarian");
        btnDeleteLibrarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteLibrarianForm.main(new String[]{});
            }
        });
        btnDeleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                LibraryMainPanel.main(new String[]{});
                frame.dispose();
            }
        });
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(MARGIN_GAP)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE))
                                .addGap(MARGIN_GAP)
                        )
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                        )
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }
}
