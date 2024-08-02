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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao userDao = new UserDaoImpl();
        User loggedInUser = userDao.fetchUserByEmailAndPassword(email, password);

        if (loggedInUser != null) {
            req.setAttribute("user", loggedInUser);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp?error=invalid");
        }
    }
}
