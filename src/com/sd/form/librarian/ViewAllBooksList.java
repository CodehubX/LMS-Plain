package com.sd.form.librarian;

import com.sd.dao.BookDao;
import com.sd.support.util.Util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewAllBooksList extends JFrame {

    private JPanel contentPane;
    private JTable table;
    
    private static ViewAllBooksList frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewAllBooksList();
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
    public ViewAllBooksList() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        Util.customizeFrame(this);
        
        Object[] bookData = BookDao.getAllAsTable(false);

        if (bookData != null) {
            String[][] data = (String[][]) bookData[0];
            String[] column = (String[]) bookData[1];

            table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);

            contentPane.add(sp, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(ViewAllBooksList.this, "Error retrieving data");
            frame.dispose();
        }
    }

}
