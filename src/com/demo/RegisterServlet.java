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


@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Date date = new Date();
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        String localIp=request.getLocalAddr();
        printer pt=new printer();

        pt.print("\n时间:"+time+" ip:"+localIp+"   注册\t");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String passwordrp=request.getParameter("passwordrp");
        if(!username.equals("")&&!password.equals("")) {
            if (password.equals(passwordrp)) {
                UserDAO userDAo = new UserDAO();
                User usert = userDAo.check(username);
                if (usert == null) {
                    User user = new User();
                    user.setName(username);
                    user.setPassword(password);
                    userDAo.addUser(user);
                    pt.print("成功 用户:"+username+" 密码:"+password);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } else {
                    pt.print("失败 原因：用户名已存在");
                    request.setAttribute("ValueA ", "用户名已存在，请重新注册");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            } else {
                pt.print("失败 原因：密码输入不一致");
                request.setAttribute("ValueA ", "密码输入不一致，请重新输入");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }else{
            pt.print("失败 原因：用户名或密码输入为空");
            request.setAttribute("ValueA ", "用户名和密码均不得为空！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
