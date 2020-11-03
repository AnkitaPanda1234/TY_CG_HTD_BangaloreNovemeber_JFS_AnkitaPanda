package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ClientBean;
import com.capgemini.forestrymanagementsystembyusingcollection.dao.ClientDAO;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ClientException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;

public class ClientServiceImpl implements ClientService {
	ClientDAO dao = ForestDaoManager.instanceofClientDAOImpl();

	@Override
	public ClientBean clientLogin(String username, String Password) {
		return dao.clientLogin(username, Password);
	}

	@Override
	public boolean addClient(int id, ClientBean clientBean) {
		return dao.addClient(id, clientBean);
	}

	@Override
	public void viewClients() {
		
	}

	@Override
	public boolean deleteClient(int id) {
		return dao.deleteClient(id);
	}

	@Override
	public boolean modifyClient(int id, ClientBean client) {
		return dao.modifyClient(id, client);
	}

	@Override
	public ClientBean searchClient(int id) throws ClientException {
		return dao.searchClient(id);
	}

	

}
