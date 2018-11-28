package com.sd.form.student;

import com.sd.form.LibraryMainPanel;
import com.sd.support.util.Util;
import com.sd.support.util.Cache;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

public class StudentPanel extends JFrame {

    private final int BUTTON_HEIGHT = 40;
    private final int BUTTON_WIDTH = 180;
    private final int MARGIN_GAP = 80;
    private final int LABEL_WIDTH = 60;
    private final int LABEL_HEIGHT = 20;
    private final int TEXTBOX_WIDTH = 180;

    static StudentPanel frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new StudentPanel();
                    frame.setVisible(true);
                    frame.setTitle("Student Panel");
                    //frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public StudentPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 300, 280);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblStudentSection = new JLabel(Cache.get("student_name"));
        lblStudentSection.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JButton btnViewBooks = new JButton("View Available Books");
        btnViewBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ViewAvailableBooksList.main(new String[]{});
            }
        });
        btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnViewIssuedBooks = new JButton("View My Issued Books");
        btnViewIssuedBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewMyIssuedBooksList.main(new String[]{});
            }
        });
        btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cache.remove("student_id");
                Cache.remove("student_name");
                LibraryMainPanel.main(new String[]{});
                frame.dispose();
            }
        });
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createSequentialGroup()
                        .addContainerGap(MARGIN_GAP, MARGIN_GAP)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                                .addComponent(lblStudentSection)
                                .addGap(MARGIN_GAP/2)
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewIssuedBooks, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                        )
                        .addContainerGap(MARGIN_GAP, MARGIN_GAP)
        );

        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblStudentSection, GroupLayout.PREFERRED_SIZE, LABEL_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewIssuedBooks, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
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
