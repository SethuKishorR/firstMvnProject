package com.tap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.dao.UserDao;
import com.tap.daoimpl.UserDaoImpl;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        UserDao userDao = new UserDaoImpl();
        int status = userDao.deleteUser(email);

        if (status > 0) {
            resp.sendRedirect("login.jsp?message=deleted");
        } else {
            resp.sendRedirect("error.jsp?error=delete");
        }
    }
}
