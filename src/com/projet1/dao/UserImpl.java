package com.projet1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projet1.entities.User;

public class UserImpl implements IUser {

	private EntityManager em;
	public UserImpl() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Projet1_JEEPU");
		
		em = emf.createEntityManager();
	}
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		try {
		
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
	}catch (Exception e) {
		e.printStackTrace();
	return 0;
	}
}
}
