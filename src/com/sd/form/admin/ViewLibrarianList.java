package com.sd.form.admin;

import com.sd.dao.LibrarianDao;
import com.sd.form.librarian.IssueBookForm;
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

public class ViewLibrarianList extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private static ViewLibrarianList frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewLibrarianList();
                    frame.setVisible(true);
                    frame.setTitle("Librarians");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewLibrarianList() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        Util.customizeFrame(this);

        Object[] librarianData = LibrarianDao.getAllAsTable();

        if (librarianData != null) {
            String[][] data = (String[][]) librarianData[0];
            String[] column = (String[]) librarianData[1];

            table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);

            contentPane.add(sp, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(ViewLibrarianList.this, "Error retrieving data");
            frame.dispose();
        }
    }

}
