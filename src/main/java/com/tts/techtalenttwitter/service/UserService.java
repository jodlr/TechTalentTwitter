package com.tts.techtalenttwitter.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.techtalenttwitter.model.Role;
import com.tts.techtalenttwitter.model.User;
import com.tts.techtalenttwitter.repository.RoleRepository;
import com.tts.techtalenttwitter.repository.UserRepository;

import antlr.collections.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, 
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
        
    public List findAll(){
        return (List) userRepository.findAll();
    }
        
    public void save(User user) {
        userRepository.save(user);
    }
    public User saveNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        javax.management.relation.Role userRole = roleRepository.findByRole("USER");
        user.setRoles1(new HashSet<Role>());
        return userRepository.save(user);
    }
	public com.tts.techtalenttwitter.controller.User getLoggedInUser1() {
		// TODO Auto-generated method stub
		return null;
	}
	public com.tts.techtalenttwitter.controller.User getLoggedInUser11() {
		// TODO Auto-generated method stub
		return null;
	}
	public com.tts.techtalenttwitter.controller.User getLoggedInUser() {
		// TODO Auto-generated method stub
		return null;
	}
}

