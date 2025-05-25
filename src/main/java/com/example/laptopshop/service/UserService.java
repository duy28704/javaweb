package com.example.laptopshop.service;

import com.example.laptopshop.dto.ProfileForm;
import com.example.laptopshop.entity.User;
import com.example.laptopshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{
    private final UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    @Transactional
    public boolean addUser(ProfileForm pf) {
        if (pf == null || pf.getUsername() == null || pf.getPassword() == null) {
            return false;
        }
        User user = new User();
        user.setUsername(pf.getUsername());
        String password = passwordEncoder.encode(pf.getPassword());
        user.setPassword(password);
        user.setRoles(pf.getRoles());
        user.setFullName(pf.getFullName());
        user.setBirthday(pf.getBirthday());
        user.setPhone(pf.getPhone());
        user.setEmail(pf.getEmail());
        user.setAddress(pf.getAddress());
        user.setJobArea(pf.getJobArea());
        user.setJob(pf.getJob());
        user.setUserActions(pf.getUserActions());
        user.setUserNotes(pf.getUserNotes());
        user.setPosition(pf.getPosition());
        user.setApplyYear(pf.getApplyYear());
        user.setCreatedDate(LocalDateTime.now());
        user.setLastModifiedDate(LocalDateTime.now());
        user.setLogined(false);
        user.setLastLogined(LocalDateTime.now());
        userRepository.save(user);
        return true;
    }
    @Transactional
    public boolean editUser(Long id , ProfileForm pf) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            if (pf.getFullName() != null && !pf.getFullName().isBlank()) user.setFullName(pf.getFullName().trim());
            if (pf.getBirthday() != null) user.setBirthday(pf.getBirthday());
            if (pf.getPhone() != null && !pf.getPhone().isBlank()) user.setPhone(pf.getPhone().trim());
            if (pf.getEmail() != null && !pf.getEmail().isBlank()) user.setEmail(pf.getEmail().trim());
            if (pf.getAddress() != null && !pf.getAddress().isBlank()) user.setAddress(pf.getAddress().trim());
            if (pf.getJobArea() != null && !pf.getJobArea().isBlank()) user.setJobArea(pf.getJobArea().trim());
            if (pf.getJob() != null && !pf.getJob().isBlank()) user.setJob(pf.getJob().trim());
            if (pf.getPosition() != null && !pf.getPosition().isBlank()) user.setPosition(pf.getPosition().trim());
            if (pf.getApplyYear() != null) user.setApplyYear(pf.getApplyYear());
            if (pf.getUserNotes() != null && !pf.getUserNotes().isBlank()) user.setUserNotes(pf.getUserNotes().trim());
            if (pf.getRoles() != null && !pf.getRoles().isBlank()) user.setRoles(pf.getRoles().trim());
            user.setLogined(user.isLogined());
            if (pf.getUserActions() != null && !pf.getUserActions().isBlank()) user.setUserActions(pf.getUserActions().trim());
            user.setLastModifiedDate(LocalDateTime.now());
            userRepository.save(user);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }



}


