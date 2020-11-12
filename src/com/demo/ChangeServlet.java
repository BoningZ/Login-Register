package com.demo.service;

import com.demo.bean.User;
import com.demo.dao.UserDAO;
import com.demo.utils.printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

@WebServlet(name = "ChangeServlet")
public class ChangeServlet extends HttpServlet {

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

        pt.print("\n时间:"+time+" ip:"+localIp+"   改密\t");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        String passwordrp = request.getParameter("passwordrp");
        UserDAO userDAo = new UserDAO();
        if(password.equals(passwordrp)) {
            User user = userDAo.login(username,oldPassword);
            if (user != null) {
                userDAo.changePswd(user,password);
                pt.print("成功 用户:"+username+" 修改密码为:"+password);
                request.getRequestDispatcher("changed.jsp").forward(request, response);
            } else {
                pt.print("失败 原因：用户名或旧密码错误");
                request.setAttribute("ValueA ", "用户名或旧密码错误");
                request.getRequestDispatcher("change.jsp").forward(request, response);
            }
        }else{
            pt.print("失败 原因：两次新密码输入不一致");
            request.setAttribute("ValueA ", "密码输入不一致，请重新输入");
            request.getRequestDispatcher("change.jsp").forward(request, response);
        }
    }
}
