package com.sf.frs.main.service;

import com.sf.frs.main.bean.CredentialsBean;
import com.sf.frs.main.util.HibernateUtil;

public class AuthenticationService {

    public CredentialsBean authenticateUser(int userID, String password) {
        // Retrieve the CredentialsBean object for the given userID from the database
        CredentialsBean credentials = getCredentialsByUserId(userID);

        if (credentials == null) {
            // User does not exist in the database
            return null;
        }

        if (!credentials.getPassword().equals(password)) {
            // Passwords do not match
            return null;
        }

        // Passwords match, so set the loginStatus to "LoggedIn" and update the object in the database
        credentials.setLoginStatus("LoggedIn");
        updateCredentials(credentials);

        return credentials;
    }


    private CredentialsBean getCredentialsByUserId(int userID) {
        // Retrieve the CredentialsBean object from the database using the given userID
        // Return null if the user does not exist in the database
        // Example implementation using Hibernate:
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        CredentialsBean credentials = session.get(CredentialsBean.class, userID);
        session.getTransaction().commit();
        return credentials;
}

    private void updateCredentials(CredentialsBean credentials) {
        // Update the CredentialsBean object in the database
        // Example implementation using Hibernate:
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(credentials);
        session.getTransaction().commit();
    }
    
    public boolean isAdmin(CredentialsBean credentials) {
        // Check if the user is an admin based on their userType attribute
        return credentials.getUserType().equals("admin");
    }

}
