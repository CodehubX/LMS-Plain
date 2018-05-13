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

public class StudentLogin extends JFrame {

    static StudentLogin frame;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField idField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new StudentLogin();
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
    public StudentLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        JLabel lblEnterId = new JLabel("Enter Id:");
        
        JLabel lblEnterName = new JLabel("Enter Name:");

        textField = new JTextField();
        textField.setColumns(10);
        idField = new JTextField();

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String id = idField.getText();
                //System.out.println(name+" "+password);
                if (StudentDao.validate(id, name)) {
                    Cache.add("student_id", id);
                    Cache.add("student_name", name);
                    StudentSuccess.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(StudentLogin.this, "Sorry, name or id does not exist", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                    idField.setText("");
                }
            }
        });

        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.CENTER)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblEnterName)
                                                        .addComponent(lblEnterId))
                                                .addGap(20)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(idField)
                                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblEnterId)
                                        .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblEnterName)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
