package com.sd.dao;

import com.sd.support.db.DB;
import com.sd.support.util.Util;

import java.sql.*;

public class StudentDao {

    public static int save(String name, String email, String address, String city, String contact, int librarianId) {
        int id = 0;
        Connection con = DB.getConnection();
        try {
            if(con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)){
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            PreparedStatement ps = con.prepareStatement("insert into student(name,email,address,city,contact,librarian_id) values(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, contact);
            ps.setInt(6, librarianId);
            ps.executeUpdate();
            
            ps = con.prepareStatement("selct student_id from student where contact = ?");
            ps.setString(1, contact);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("student_id");
            }else{
                id = -1;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return id;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from student where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static boolean validate(String id, String name) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select id from student where id=? and name=?");
            ps.setString(1, id);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static Object[] getAllAsTable(){
        Connection con = DB.getConnection();
        String query;
        query = "select * from student";
        
        return Util.queryAndFormatIntoTable(con, query);
    }

}
