package com.sd.support.db;


import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection getConnection() {
        Connection con = null;
        try {
            /*
            Depricated
            */
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymsswing", "user", "user");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
