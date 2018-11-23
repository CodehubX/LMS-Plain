package com.sd.form.student;

import com.sd.dao.BookDao;
import com.sd.form.librarian.*;
import com.sd.support.util.Util;
import com.sd.support.db.DB;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewAvailableBooksList extends JFrame {

    private JPanel contentPane;
    private JTable table;
    
    private static ViewAvailableBooksList frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewAvailableBooksList();
                    frame.setVisible(true);
                    frame.setTitle("Books");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewAvailableBooksList() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        Util.customizeFrame(this);

        Object[] bookData = BookDao.getAllAsTable(true);

        if (bookData != null) {
            String[][] data = (String[][]) bookData[0];
            String[] column = (String[]) bookData[1];

            table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);

            contentPane.add(sp, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(ViewAvailableBooksList.this, "Error retrieving data");
            frame.dispose();
        }
    }

}
