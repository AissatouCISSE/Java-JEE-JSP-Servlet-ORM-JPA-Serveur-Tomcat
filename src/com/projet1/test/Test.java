package com.projet1.test;

import com.projet1.dao.IUser;
import com.projet1.dao.UserImpl;
import com.projet1.entities.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUser userdao = new UserImpl();
		User u = new User();
		u.setNom_user("CISSE");
		u.setPrenom_user("Aissatou");
		u.setEmail("aissatoucisse351@gmail.com");
		u.setPassword("passer345");
		u.setEtat(1);
		System.out.println(userdao.add(u));

	}

}
