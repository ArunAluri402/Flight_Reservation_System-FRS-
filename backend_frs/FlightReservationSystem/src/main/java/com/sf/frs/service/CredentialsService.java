package com.sf.frs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sf.frs.beans.CredentialsBean;
import com.sf.frs.dao.CredentialsDAO;
@Service
public class CredentialsService {

    private CredentialsDAO credentialsDAO;

    public CredentialsService() {
        credentialsDAO = new CredentialsDAO();
    }

    public void addCredentials(CredentialsBean credentials) {
        credentialsDAO.addCredentials(credentials);
    }

    public List<CredentialsBean> getAllCredentials() {
        return credentialsDAO.viewAllCredentials();
    }

    
}
