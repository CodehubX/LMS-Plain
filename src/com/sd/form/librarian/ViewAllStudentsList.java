package com.sd.form.librarian;

import com.sd.dao.StudentDao;
import com.sd.support.util.Util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ViewAllStudentsList extends JFrame {

    private JPanel contentPane;
    private JTable table;
    
    private static ViewAllStudentsList frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ViewAllStudentsList();
                    frame.setVisible(true);
                    frame.setTitle("Students");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewAllStudentsList() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        Util.customizeFrame(this);
        
        Object[] studentData = StudentDao.getAllAsTable();

        if (studentData != null) {
            String[][] data = (String[][]) studentData[0];
            String[] column = (String[]) studentData[1];

            table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);

            contentPane.add(sp, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(ViewAllStudentsList.this, "Error retrieving data");
            frame.dispose();
        }
    }

}
