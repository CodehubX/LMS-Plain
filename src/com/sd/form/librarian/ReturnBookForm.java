package com.sd.form.librarian;

import com.sd.dao.ReturnBookDao;
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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

public class ReturnBookForm extends JFrame {

    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 80;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static ReturnBookForm frame;
    private JPanel contentPane;
    private JTextField textFieldBookCallNo;
    private JTextField textFieldStudentId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ReturnBookForm();
                    frame.setVisible(true);
                    frame.setTitle("Return Book");
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
    public ReturnBookForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 330, 210);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblBookCallno = new JLabel("Book ID");

        JLabel lblStudentId = new JLabel("Student ID");

        textFieldBookCallNo = new JTextField();
        textFieldBookCallNo.setColumns(10);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setColumns(10);

        JButton btnReturnBook = new JButton("Return");
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookId = textFieldBookCallNo.getText();
                int studentId = Integer.parseInt(textFieldStudentId.getText());
                int i = ReturnBookDao.delete(bookId, studentId);
                if (i == 0) {
                    JOptionPane.showMessageDialog(ReturnBookForm.this, "Book returned successfully!");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(ReturnBookForm.this, "Sorry, unable to return book!");
                }
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                        .addGroup(Alignment.CENTER, gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblStudentId)
                                        .addComponent(lblBookCallno))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(textFieldStudentId, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldBookCallNo, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()
                        )
                        .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookCallno)
                                        .addComponent(textFieldBookCallNo))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblStudentId)
                                        .addComponent(textFieldStudentId))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE))
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }

}
