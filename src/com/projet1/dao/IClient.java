package com.projet1.dao;

import java.util.List;

import com.projet1.entities.Client;



public interface IClient {
	public Client save(Client c);
	public List<Client> clientParMC(String mc);
	public Client getClient(Long id);
	public Client updateClient(Client c);
	public void deleteClient(Long id);
}
