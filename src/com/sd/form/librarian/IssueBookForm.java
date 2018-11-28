package com.sd.form.librarian;

import com.sd.dao.IssueBookDao;
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
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

public class IssueBookForm extends JFrame {

    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 80;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static IssueBookForm frame;
    private JPanel contentPane;
    private JTextField textFieldBookName;
    private JTextField textFieldStudentId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new IssueBookForm();
                    frame.setVisible(true);
                    frame.setTitle("Issue Book");
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
    public IssueBookForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 420, 210);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblBookName = new JLabel("Book ID");

        textFieldBookName = new JTextField();
        textFieldBookName.setColumns(10);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setColumns(10);

        JLabel lblStudentId = new JLabel("Student ID");

        JButton btnIssueBook = new JButton("Issue");
        btnIssueBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String bookId = textFieldBookName.getText();
                int studentId = Integer.parseInt(textFieldStudentId.getText());
                String librarianId = Cache.get("librarianId");
                if (IssueBookDao.save(bookId, studentId, Integer.parseInt(librarianId)) == 0) {
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Book issued successfully!");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, unable to issue!");
                }
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblBookName)
                                                .addComponent(lblStudentId))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(textFieldStudentId, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldBookName, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE))
                                )
                                .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                        )
                        .addContainerGap()
                )
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblBookName)
                                .addComponent(textFieldBookName))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblStudentId)
                                .addComponent(textFieldStudentId))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                )
        );
        contentPane.setLayout(gl_contentPane);

        pack();
        Util.customizeFrame(this);
    }
}
