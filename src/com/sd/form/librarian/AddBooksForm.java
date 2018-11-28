package com.sd.form.librarian;

import com.sd.dao.BookDao;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class AddBooksForm extends JFrame {

    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_WIDTH = 110;
    private final int MARGIN_GAP = 140;
    private final int LABEL_WIDTH = 60;
    private final int TEXTBOX_WIDTH = 180;

    static AddBooksForm frame;
    private JPanel contentPane;
    private JTextField textFieldCallNo;
    private JTextField textFieldName;
    private JTextField textFieldAuthor;
    private JTextField textFieldPublisher;
    //private JTextField textField_4;
    private JSpinner spinnerQuantity;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AddBooksForm();
                    frame.setVisible(true);
                    frame.setTitle("Add Book");
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
    public AddBooksForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 360, 310);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //Util.customizeFrame(this);

        JLabel lblCallNo = new JLabel("Book ID");

        JLabel lblName = new JLabel("Name");

        JLabel lblAuthor = new JLabel("Author");

        JLabel lblPublisher = new JLabel("Publisher");

        JLabel lblQuantity = new JLabel("Quantity");

        textFieldCallNo = new JTextField();
        textFieldCallNo.setColumns(10);

        textFieldName = new JTextField();
        textFieldName.setColumns(10);

        textFieldAuthor = new JTextField();
        textFieldAuthor.setColumns(10);

        textFieldPublisher = new JTextField();
        textFieldPublisher.setColumns(10);

        //textField_4 = new JTextField();
        //textField_4.setColumns(10);
        SpinnerModel model = new SpinnerNumberModel(1, 1, 500, 1);
        spinnerQuantity = new JSpinner(model);

        JButton btnAddBooks = new JButton("Add Book");
        btnAddBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookNo = textFieldCallNo.getText();
                String name = textFieldName.getText();
                String author = textFieldAuthor.getText();
                String publisher = textFieldPublisher.getText();
                //String squantity = textField_4.getText();
                String squantity = String.valueOf(spinnerQuantity.getValue());
                int quantity = Integer.parseInt(squantity);

                int i = BookDao.save(bookNo, name, author, publisher, quantity);
                if (i > 0) {
                    JOptionPane.showMessageDialog(AddBooksForm.this, "Book added successfully!");
                    //LibrarianPanel.main(new String[]{});
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(AddBooksForm.this, "Sorry, unable to save!");
                }
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(lblName, GroupLayout.PREFERRED_SIZE, LABEL_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCallNo)
                                                .addComponent(lblAuthor)
                                                .addComponent(lblPublisher)
                                                .addComponent(lblQuantity))
                                        .addGap(47)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                //.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(spinnerQuantity, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldPublisher, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldAuthor, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textFieldCallNo, GroupLayout.PREFERRED_SIZE, TEXTBOX_WIDTH, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                .addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
        );
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblCallNo)
                                .addComponent(textFieldCallNo))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblName)
                                .addComponent(textFieldName))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblAuthor)
                                .addComponent(textFieldAuthor))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblPublisher)
                                .addComponent(textFieldPublisher))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblQuantity)
                                .addComponent(spinnerQuantity))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, GroupLayout.PREFERRED_SIZE)
                )
        );
        contentPane.setLayout(gl_contentPane);

        pack();
        Util.customizeFrame(this);
    }

}
