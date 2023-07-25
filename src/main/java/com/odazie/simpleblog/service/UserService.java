package com.odazie.simpleblog.service;

import com.odazie.simpleblog.model.User;
import com.odazie.simpleblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    public void saveUser( User user )
    {
        userRepository.save( user );
    }

    public List< User > getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(Long aUserId) {
        return userRepository.findByUserId(aUserId);
    }

    public void deleteUser(Long aUserId) {
        userRepository.deleteById(aUserId);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
