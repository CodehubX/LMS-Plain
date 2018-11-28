package com.sd.form.librarian;

import com.sd.form.LibraryMainPanel;
import com.sd.support.util.Cache;
import com.sd.support.util.Util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

public class LibrarianPanel extends JFrame {

    private final int BUTTON_HEIGHT = 40;
    private final int BUTTON_WIDTH = 180;
    private final int MARGIN_GAP = 80;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static LibrarianPanel frame;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new LibrarianPanel();
                    frame.setVisible(true);
                    frame.setTitle("Librarian Panel");
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
    public LibrarianPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 450, 490);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JButton btnNewStudentButton = new JButton("Add Student");
        btnNewStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudentsForm.main(new String[]{});
            }
        });
        btnNewStudentButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnViewStudentButton = new JButton("View Students");
        btnViewStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewAllStudentsList.main(new String[]{});
            }
        });
        btnViewStudentButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnNewButton = new JButton("Add Books");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddBooksForm.main(new String[]{});
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnViewBooks = new JButton("View Books");
        btnViewBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ViewAllBooksList.main(new String[]{});
            }
        });
        btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnIssueBook = new JButton("Issue Book");
        btnIssueBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IssueBookForm.main(new String[]{});
            }
        });
        btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnViewIssuedBooks = new JButton("View Issued Books");
        btnViewIssuedBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewIssuedBooksList.main(new String[]{});
            }
        });
        btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnReturnBook = new JButton("Return Book");
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReturnBookForm.main(new String[]{});
            }
        });
        btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cache.remove("librarianId");
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
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewIssuedBooks, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNewStudentButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewStudentButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                        )
                        .addContainerGap(MARGIN_GAP, MARGIN_GAP)
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNewStudentButton, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewStudentButton, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewIssuedBooks, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                        )
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }

}
