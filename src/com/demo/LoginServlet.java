package com.demo.service;

import com.demo.bean.User;
import com.demo.dao.UserDAO;
import com.demo.utils.printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date date = new Date();
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        String localIp=request.getLocalAddr();
        printer pt=new printer();

        pt.print("\n时间:"+time+" ip:"+localIp+"   登录\t");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAo = new UserDAO();
        User user = userDAo.login(username,password);
        if(user != null){
            pt.print("成功 用户: "+username);
            request.setAttribute( "ValueA ",username);
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }
        else {
            pt.print("失败 原因：用户名或密码错误");
            request.getRequestDispatcher("defeat.jsp").forward(request,response);
        }
    }
}
