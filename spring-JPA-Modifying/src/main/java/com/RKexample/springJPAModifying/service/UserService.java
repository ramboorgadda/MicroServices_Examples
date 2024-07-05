package com.RKexample.springJPAModifying.service;


import com.RKexample.springJPAModifying.entity.Users;
import com.RKexample.springJPAModifying.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Users createUser(Users user){
        return  userRepository.save(user);
    }

    public int updateUserEmail(Long id,String email){
        return userRepository.updateEmailById(id,email);
    }

    public int deleteUserOlderThan(int age){
        return userRepository.deleteUserOlderThan(age);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
