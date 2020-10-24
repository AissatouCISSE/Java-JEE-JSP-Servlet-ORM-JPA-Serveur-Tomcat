package com.projet1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projet1.entities.Client;
import com.projet1.metier.SingletonConnection;



public class ClientImpl implements IClient {

private EntityManager em;
	
    public ClientImpl() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet1_JEEPU");
		em = emf.createEntityManager();
	}

	@Override
	public int add(Client client) {
		try {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
			return 1;
		}catch (Exception ex){
			ex.printStackTrace();
			return  0;
		}
	}

	@Override
	public List<Client> clientParMC(String mc) {
		// TODO Auto-generated method stub
				List<Client> clients = new ArrayList<Client>();
				Connection conn = SingletonConnection.getConnection();
				try {
					PreparedStatement ps = conn.prepareStatement(" SELECT * FROM client where nom_client LIKE '%"+mc+"%'");
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Client c = new Client();
						c.setId(rs.getInt("id"));
						c.setNom_client(rs.getString("nom_client"));
						c.setAdresse_client(rs.getString("adresse_client"));
						c.setTelephone_client(rs.getString("telephone_client"));
						clients.add(c);
					}
					
					
					
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return clients;
	}

	@Override
	public Client getClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		
	}

}
