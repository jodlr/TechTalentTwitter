package com.tts.techtalenttwitter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.techtalenttwitter.model.User;
import com.tts.techtalenttwitter.service.UserService;

@Controller
public class AuthorizationController {
	
	@Autowired
    private UserService userService;

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }
    
    
 

}
