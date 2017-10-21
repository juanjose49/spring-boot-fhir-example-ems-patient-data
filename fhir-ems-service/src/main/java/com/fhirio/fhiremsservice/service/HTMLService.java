package com.fhirio.fhiremsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpSession;

@Controller
public class HTMLService {


    @RequestMapping(path="/", method= RequestMethod.GET)
    public String login(){
        return "index";
    }
}


