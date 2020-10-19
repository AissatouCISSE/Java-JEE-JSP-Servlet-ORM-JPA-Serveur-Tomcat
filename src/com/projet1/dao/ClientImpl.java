package com.projet1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projet1.entities.Client;
import com.projet1.metier.SingletonConnection;



public class ClientImpl implements IClient {

	@Override
	public Client save(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> clientParMC(String mc) {
		// TODO Auto-generated method stub
				List<Client> clients = new ArrayList<Client>();
				Connection conn = SingletonConnection.getConnection();
				try {
					PreparedStatement ps = conn.prepareStatement(" SELECT * FROM clients where nom_client LIKE '%"+mc+"%'");
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Client c = new Client();
						c.setId_client(rs.getLong("id_client"));
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
