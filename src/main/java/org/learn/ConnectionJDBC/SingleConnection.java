package org.learn.ConnectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static String url = "jdbc:postgresql://localhost:5432/jdbclearn";
    private static String pwd = "root";
    private static String user = "postgres";
    private static Connection connection= null;

    static {
        connect();
    }

    public SingleConnection(){
        connect();
    }

    private static void connect(){
        try{
            if(connection == null){
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, pwd);
                connection.setAutoCommit(false);
                System.out.println("Success!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
