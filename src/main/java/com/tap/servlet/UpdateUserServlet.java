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

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.fetchUserByEmail(email);

        if (user != null) {
            user.setName(name);
            user.setPhonenumber(phonenumber);
            user.setAddress(address);
            int status = userDao.updateUser(user);

            if (status > 0) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("error.jsp?error=update");
            }
        } else {
            resp.sendRedirect("error.jsp?error=notfound");
        }
    }
}
