package com.sd.dao;

import com.sd.support.db.DB;
import com.sd.support.util.Util;

import java.sql.*;

public class IssueBookDao {

    public static int save(String bookId, int studentId, int librarianId) {
        int status = 0;

        Connection con = DB.getConnection();
        try {
            if (con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)) {
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }

            CallableStatement cs = con.prepareCall("{call issue_book(?, ?, ?, ?)}");
            cs.setString(1, bookId);
            cs.setInt(2, studentId);
            cs.setInt(3, librarianId);

            cs.registerOutParameter(4, Types.INTEGER);

            cs.execute();

            status = cs.getInt(4);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return status;
    }
    
    public static Object[] getAllAsTable(){
        Connection con = DB.getConnection();
        String query = "select * from issued_books";
        
        return Util.queryAndFormatIntoTable(con, query);
    }
    
    public static Object[] getAllAsTable(String studentName){
        Connection con = DB.getConnection();
        String query = "select book_id, issue_time from issued_books where student_id='"+studentName+"'";
        
        return Util.queryAndFormatIntoTable(con, query);
    }
}
