package edu.mum.controller;

import edu.mum.domain.Login;
import edu.mum.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginControllerHelper {
    @Autowired
    LoginService loginService;
    public String verify(Login login){
        return loginService.verify(login);
    }
}
