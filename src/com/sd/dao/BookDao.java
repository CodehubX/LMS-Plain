package com.sd.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author subha
 */

import com.sd.support.db.DB;
import com.sd.support.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BookDao {

    public static int save(String bookId, String name, String author, String publisher, int quantity) {
        Connection con = DB.getConnection();
        int status = 0;
        try {
            if(con.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)){
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            PreparedStatement ps = con.prepareStatement("insert into books(book_id,name,author,publisher,available_quantity) values(?,?,?,?,?)");
            ps.setString(1, bookId);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, quantity);
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
    
    public static Object[] getAllAsTable(boolean availableOnly){
        Connection con = DB.getConnection();
        String query;
        if(!availableOnly) query = "select * from books";
        else query = "select book_id, name, author, publisher from books where available_quantity > 0";
        
        return Util.queryAndFormatIntoTable(con, query);
    }
}

