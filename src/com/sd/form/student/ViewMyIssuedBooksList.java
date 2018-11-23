package com.sd.form.student;

import com.sd.dao.IssueBookDao;
import com.sd.form.librarian.ViewIssuedBooksList;
import com.sd.support.util.Util;
import com.sd.support.db.DB;
import com.sd.support.util.Cache;

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

public class ViewMyIssuedBooksList extends JFrame {

    private JPanel contentPane;
    private JTable table;
    
    private static ViewMyIssuedBooksList frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewMyIssuedBooksList();
                    frame.setVisible(true);
                    frame.setTitle("My Books");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewMyIssuedBooksList() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        Util.customizeFrame(this);

        Object[] myIssuedBookData = IssueBookDao.getAllAsTable(Cache.get("student_id"));

        if (myIssuedBookData != null) {
            String[][] data = (String[][]) myIssuedBookData[0];
            String[] column = (String[]) myIssuedBookData[1];

            table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);

            contentPane.add(sp, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(ViewMyIssuedBooksList.this, "Error retrieving data");
            frame.dispose();
        }
    }

}
