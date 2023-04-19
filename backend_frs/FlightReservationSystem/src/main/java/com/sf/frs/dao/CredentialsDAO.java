package com.sf.frs.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.frs.beans.CredentialsBean;

@Repository
public class CredentialsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	private Transaction transaction;
	
	private Query<CredentialsBean> q;
	
	public ArrayList<CredentialsBean> viewAllCredentials()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from CredentialBean");
		return (ArrayList<CredentialsBean>) q.list();
	}
	
	public String addCredentials(CredentialsBean credentialsBean) {
		System.out.println(credentialsBean);
		
		if(credentialsBean!=null) {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(credentialsBean);
			transaction.commit();
			session.close();
			return "SUCESS";
			
		}else if(credentialsBean==null) {
			return "ERROR";
			
		}else {
			return "FAIL";
		}
	}
}