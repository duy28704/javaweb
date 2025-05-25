package com.example.laptopshop.service;

import com.example.laptopshop.dto.ProfileForm;
import com.example.laptopshop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    public List<User> getAllUsers();
    public Optional<User> getUserById(Long id);
    public boolean addUser(ProfileForm pf);
    public boolean editUser(Long id , ProfileForm pf);
    public boolean deleteUser(Long id);
}
