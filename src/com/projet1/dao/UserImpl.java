package com.projet1.dao;

import java.util.List;

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
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();		}
		return 0;
	}

	@Override
	public List<User> users() {
		return null;
	}

	@Override
	public User getLogin(String email, String password) {
		// TODO Auto-generated method stub
		try {

			User user = (User) em
					.createQuery("select u from User u where u.email=:e and u.password=:p")
					.setParameter("e",email)
					.setParameter("p",password)
					.getSingleResult();
			System.out.println(email);
			System.out.println(password);
			return user;

		}catch (Exception e)
		{
			return null;
		}
	}
	@Override
	public int delete(int id, User user){
		try {
			em.getTransaction().begin();
			user = em.find(User.class,id);
			em.remove(user);
			em.getTransaction().commit();
			return 1;
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public User get(int id) {
		
		return em.find(User.class,id);
	}
}