package com.tap.dao;

import com.tap.modal.User;

public interface UserDao {
    public int addUser(User u);
    public User fetchUserByEmail(String email);
    public User fetchUserByEmailAndPassword(String email, String password);
    public int updateUser(User u);
    public int deleteUser(String email);
}