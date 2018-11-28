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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

public class DeleteLibrarianForm extends JFrame {
    
    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 110;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static DeleteLibrarianForm frame;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new DeleteLibrarianForm();
                    frame.setVisible(true);
                    frame.setTitle("Delete Librarian");
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
    public DeleteLibrarianForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 300, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblEnterId = new JLabel("Librarian ID");

        textField = new JTextField();
        textField.setColumns(10);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sid = textField.getText();
                if (sid == null || sid.trim().equals("")) {
                    JOptionPane.showMessageDialog(DeleteLibrarianForm.this, "Id can't be blank");
                } else {
                    int id = Integer.parseInt(sid);
                    int i = LibrarianDao.delete(id);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(DeleteLibrarianForm.this, "Record deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(DeleteLibrarianForm.this, "Unable to delete given id!");
                    }
                }
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEnterId)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()
                )
                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEnterId))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE))
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }
}
