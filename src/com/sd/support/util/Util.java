package com.sd.support.util;

import com.sd.support.db.DB;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author subha
 */
public class Util {
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    public static void customizeFrame(Frame frame) {
        Image icon = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/com/sd/resources/icons/256x256.png"));
        //ImageIcon icon = new ImageIcon("./icons/256x256.png");
        frame.setIconImage(icon);
        frame.setLocationRelativeTo(null);
    }
    
    public static Object[] queryAndFormatIntoTable(Connection con, String query){
        String data[][] = null;
        String column[] = null;
        try {
            if(con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)){
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            
            PreparedStatement ps = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = Util.capitalizeFirstLetter(rsmd.getColumnName(i));
            }

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            data = new String[rows][cols];
            int count = 0;
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = rs.getString(i);
                }
                count++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        
        return new Object[] {data, column};
    }
}
