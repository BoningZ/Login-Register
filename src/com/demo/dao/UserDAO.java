package com.demo.dao;

import com.demo.bean.User;
import com.demo.utils.JdbcUtils;

import java.sql.*;


public class UserDAO {
    public User login(String username, String password){
        User u = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getconn();
            String sql = "select * from users where name=? and password=?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                u = new User();
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JdbcUtils.close(preparedStatement,connection,resultSet);
        }
            return u;
    }

    public User check(String username){
        User u = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getconn();
            String sql = "select * from users where name=?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                u = new User();
                u.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JdbcUtils.close(preparedStatement,connection,resultSet);
        }
        return u;
    }

    public void addUser(User user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "insert into users(name,password)values(?,?);";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(preparedStatement,connection);
        }

    }

    public void changePswd(User user,String newPswd){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "update users set password=? where name=?;";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1,newPswd);
            preparedStatement.setString(2,user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(preparedStatement,connection);
        }

    }

}
