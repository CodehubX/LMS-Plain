package com.sd.form.student;

import com.sd.dao.StudentDao;
import com.sd.support.util.Util;
import com.sd.support.util.Cache;

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
import javax.swing.LayoutStyle;

public class StudentLoginForm extends JFrame {

    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 80;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static StudentLoginForm frame;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new StudentLoginForm();
                    frame.setVisible(true);
                    frame.setTitle("Student Login");
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
    public StudentLoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 260, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lbId = new JLabel("ID");

        JLabel lblName = new JLabel("Name");

        textFieldName = new JTextField();
        textFieldName.setColumns(10);
        textFieldID = new JTextField();

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String id = textFieldID.getText();
                //System.out.println(name+" "+password);
                if (StudentDao.validate(id, name)) {
                    Cache.add("student_id", id);
                    Cache.add("student_name", name);
                    StudentPanel.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(StudentLoginForm.this, "Sorry, name or id does not exist", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    textFieldName.setText("");
                    textFieldID.setText("");
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
                                                        .addComponent(lblName)
                                                        .addComponent(lbId))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.DEFAULT_SIZE)
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lbId)
                                        .addComponent(textFieldID))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(textFieldName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                        )
        );
        contentPane.setLayout(gl_contentPane);
        
        pack();
        Util.customizeFrame(this);
    }
}
