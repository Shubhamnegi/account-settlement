package com.settlement.demo.service;

import com.settlement.demo.model.User;
import com.settlement.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User u) {
        return userRepository.save(u);
    }

    public User findUserByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByDomainAndMobile(Long domainId, String mobile) {
        return userRepository.findByDomain_IdAndMobile(domainId, mobile);
    }

    public List<User> findUserByDomain(Long domainId) {
        return userRepository.findByDomain_Id(domainId);
    }


}
