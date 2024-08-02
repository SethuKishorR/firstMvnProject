package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.tap.dao.UserDao;
import com.tap.modal.User;

public class UserDaoImpl implements UserDao {
    private static final String ADD_USER_QUERY = "INSERT INTO `user` (`name`, `email`, `phonenumber`, `password`, `address`) VALUES (?, ?, ?, ?, ?)";
    private static final String RETRIEVE_USER_BY_EMAIL_QUERY = "SELECT * FROM `user` WHERE `email`=?";
    private static final String RETRIEVE_USER_BY_EMAIL_AND_PASSWORD_QUERY = "SELECT * FROM `user` WHERE `email`=? AND `password`=?";
    private static final String UPDATE_USER_QUERY = "UPDATE `user` SET `name`=?, `phonenumber`=?, `address`=? WHERE `email`=?";
    private static final String DELETE_USER_QUERY = "DELETE FROM `user` WHERE `email`=?";
    private static String url = "jdbc:mysql://localhost:3306/jee";
    private static String dbusername = "root";
    private static String dbpassword = "Sethukishor@9944750880";
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet result;

    public UserDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, dbusername, dbpassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addUser(User u) {
        int x = 0;
        try {
            pstmt = con.prepareStatement(ADD_USER_QUERY);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPhonenumber());
            pstmt.setString(4, u.getPassword());
            pstmt.setString(5, u.getAddress());
            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public User fetchUserByEmail(String email) {
        User user = null;
        try {
            pstmt = con.prepareStatement(RETRIEVE_USER_BY_EMAIL_QUERY);
            pstmt.setString(1, email);
            result = pstmt.executeQuery();
            if (result.next()) {
                user = new User();
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPhonenumber(result.getString("phonenumber"));
                user.setPassword(result.getString("password"));
                user.setAddress(result.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User fetchUserByEmailAndPassword(String email, String password) {
        User user = null;
        try {
            pstmt = con.prepareStatement(RETRIEVE_USER_BY_EMAIL_AND_PASSWORD_QUERY);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            result = pstmt.executeQuery();
            if (result.next()) {
                user = new User();
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPhonenumber(result.getString("phonenumber"));
                user.setPassword(result.getString("password"));
                user.setAddress(result.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUser(User u) {
        int x = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_USER_QUERY);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getPhonenumber());
            pstmt.setString(3, u.getAddress());
            pstmt.setString(4, u.getEmail());
            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public int deleteUser(String email) {
        int x = 0;
        try {
            pstmt = con.prepareStatement(DELETE_USER_QUERY);
            pstmt.setString(1, email);
            x = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
}
