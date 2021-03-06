package com.projet1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projet1.entities.Client;
import com.projet1.entities.Village;
import com.projet1.metier.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VillageImpl implements IVillage {
	private EntityManager em;

	public VillageImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet1_JEEPU");
		em = emf.createEntityManager();
	}
	@Override
	public int add(Village village) {
		try {
			em.getTransaction().begin();
			em.persist(village);
			em.getTransaction().commit();
			return 1;
		}catch (Exception ex){
			ex.printStackTrace();
			return  0;
		}
	}

	@Override
	public List<Village> villages() {
		//return em.createQuery("SELECT v FROM village v ").getResultList();
		
		// TODO Auto-generated method stub
		List<Village> villages = new ArrayList<Village>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM village");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Village v = new Village();
				v.setId(rs.getInt("id"));
				v.setNom_village(rs.getString("nom_village"));
				
				villages.add(v);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return villages;
	}

	@Override
	public Village getVillageByName(String nomVillage) {
		// TODO Auto-generated method stub
		try {

			Village village = (Village) em
					.createQuery("select v from Village v where v.nom_village=:n")
					.setParameter("n",nomVillage)
					.getSingleResult();
			return village;

		}catch (Exception e)
		{
			return null;
		}
	}
	@Override
	public int delete(int id, Village village) {
		try {
			em.getTransaction().begin();
			village = em.find(Village.class,id);
			em.remove(village);
			em.getTransaction().commit();
			return 1;
		}catch (Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	@Override
	public Village get(int id) {
		// TODO Auto-generated method stub
		return em.find(Village.class,id);
		
	}
}