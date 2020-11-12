package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JdbcUtils {
    private static String url = "jdbc:mysql://localhost:3306/MySQL";
    private static String user = "root";
    private static String password = "zbn123ZBN456";
    private static String dv = "com.mysql.jdbc.Driver";

    static{
        /*Properties prop = new Properties();
        InputStream in = JdbcUtils.class.getResourceAsStream("/b");*/

        try {
            /*prop.load(in);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            dv = prop.getProperty("driver");*/

            //注册驱动
            Class.forName(dv);
        } /*catch (IOException e) {
            e.printStackTrace();
        }*/ catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getconn() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;

    }

    public static void close(Statement statement, Connection connection){
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet result) {
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(result != null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
