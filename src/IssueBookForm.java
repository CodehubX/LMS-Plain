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

public class IssueBookForm extends JFrame {

    static IssueBookForm frame;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;

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
        setBounds(100, 100, 420, 210);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        Util.customizeFrame(this);

        JLabel lblBookName = new JLabel("Book Callno:");

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        JLabel lblStudentId = new JLabel("Student Id:");

        JButton btnIssueBook = new JButton("Issue Book");
        btnIssueBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String bookcallno = textField_1.getText();
                int studentid = Integer.parseInt(textField_2.getText());

                if (IssueBookDao.checkBook(bookcallno)) {

                    int i = IssueBookDao.save(bookcallno, studentid);
                    if (i > 0) {
                        JOptionPane.showMessageDialog(IssueBookForm.this, "Book issued successfully!");
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, unable to issue!");
                    }//end of save if-else

                } else {
                    JOptionPane.showMessageDialog(IssueBookForm.this, "Sorry, Callno doesn't exist!");
                }//end of checkbook if-else

            }
        });

        JLabel lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before issuing book!");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setForeground(Color.RED);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.CENTER)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblBookName)
                                                        .addComponent(lblStudentId))
                                                .addGap(10)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
                                                .addGap(48)
                                        )
                                        .addGroup(Alignment.CENTER, gl_contentPane.createSequentialGroup()
                                                .addGap(20)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                                                        .addComponent(lblNewLabel_1)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(100)
                                        )
                                )
                        )
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookName)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblStudentId)
                                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(lblNewLabel_1)
                                .addGap(20))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
