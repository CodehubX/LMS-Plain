package com.sd.dao;


import com.sd.support.db.DB;
import com.sd.support.util.Util;

import java.sql.*;

public class LibrarianDao {

    public static int save(String name, String password, String email, String address, String city, String contact) {
        int status = 0;
        Connection con = DB.getConnection();
        try {
            if(con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)){
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            PreparedStatement ps = con.prepareStatement("insert into librarian(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, city);
            ps.setString(6, contact);
            ps.executeUpdate();
            
            ps = con.prepareStatement("select id from librarian where contact=?");
            ps.setString(1, contact);
            ResultSet rs = ps.executeQuery();
            status = rs.next()? rs.getInt("id"):-1;
            
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        Connection con = DB.getConnection();
        try {
            if(con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)){
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            PreparedStatement ps = con.prepareStatement("delete from librarian where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return status;
    }

    public static boolean validate(String id, String password) {
        boolean status = false;
        Connection con = DB.getConnection();
        try {
            if(con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)){
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            
            PreparedStatement ps = con.prepareStatement("select * from librarian where id=? and password=?");
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return status;
    }
    
    public static Object[] getAllAsTable(){
        Connection con = DB.getConnection();
        String query = "select * from librarian";
        
        return Util.queryAndFormatIntoTable(con, query);
    }

}
