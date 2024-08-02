package com.tap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.dao.UserDao;
import com.tap.daoimpl.UserDaoImpl;
import com.tap.modal.User;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        String address = req.getParameter("address");

        User user = new User(name, email, phonenumber, password, address);
        UserDao userDao = new UserDaoImpl();

        int status = userDao.addUser(user);

        if (status == 0) {
            // Redirect to failure page if addition was unsuccessful
            resp.sendRedirect("failure.jsp");
        } else {
            // Redirect to userAdded.jsp to confirm addition and provide login link
            resp.sendRedirect("userAdded.jsp");
        }
    }
}
