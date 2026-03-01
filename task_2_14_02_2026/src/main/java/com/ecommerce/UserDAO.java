package com.ecommerce;

public interface UserDAO {
    void saveUser(User u);
    User findUser(Long id);
    void deleteUser(Long id);
    void updateUser(User u);
}