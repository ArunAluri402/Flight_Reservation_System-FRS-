package com.sf.frs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.frs.beans.CredentialsBean;
import com.sf.frs.service.CredentialsService;

@RestController
@RequestMapping("/api")
public class CredentialsController {

    @Autowired
    private CredentialsService credentialsService;
    
    @GetMapping("/credentials")
    public List<CredentialsBean> getallcandidates(){
    	return credentialsService.getAllCredentials();
    }
}
