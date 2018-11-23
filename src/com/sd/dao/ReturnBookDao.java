package com.sd.dao;

import com.sd.support.db.DB;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class ReturnBookDao {

    public static int delete(String bookId, int studentId) {
        int status = 0;
        Connection con = DB.getConnection();
        try {
            if (con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)) {
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }

            CallableStatement cs = con.prepareCall("{call return_book(?, ?, ?)}");
            cs.setString(1, bookId);
            cs.setInt(2, studentId);

            cs.registerOutParameter(3, Types.INTEGER);

            cs.execute();

            status = cs.getInt(3);

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

}
