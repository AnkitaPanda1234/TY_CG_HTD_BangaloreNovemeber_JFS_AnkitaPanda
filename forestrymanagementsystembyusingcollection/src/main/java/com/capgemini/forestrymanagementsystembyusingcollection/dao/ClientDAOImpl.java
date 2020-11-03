package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ClientBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ClientException;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.LoginException;
public class ClientDAOImpl implements ClientDAO {

	static HashMap<Integer, ClientBean> h1 = new HashMap<Integer, ClientBean>();

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ClientBean clientLogin(String username, String password) throws LoginException {

		ClientBean clientBean = null;
		if (h1.containsKey(username)) {
			clientBean = h1.get(username);
		}
		if (clientBean != null) {
			return clientBean;
		} else {
			throw new LoginException("Client Details are not present, Please conatct Admin To Create Client");
		}

	}

	@Override
	public boolean modifyClient(int id, ClientBean client) throws ClientException {
		ClientBean clientBean = searchClient(id);
		if (clientBean != null) {
			h1.replace(id, clientBean);
			return true;
		} else {
			throw new ClientException("Clinet Details Not To Found To Modify");
		}
	}

	@Override
	public boolean addClient(int id, ClientBean clientBean) throws ClientException {

		ClientBean clintBean = searchClient(id);
		if (clintBean != null) {
			throw new ClientException("Client  Already Present,Please Enter another Id");
		} else {
			h1.put(id, clientBean);
		}

		if (h1.containsKey(id)) {
			return true;
		} else {
			throw new ClientException("Client  Already Present,Please Enter another Id");
		}

	}

	@Override
	public void viewClients() throws ClientException {
		if (!h1.isEmpty()) {
			System.out.println(h1);

		} else {
			throw new ClientException("Clients Details Are Not Present");
		}

	}

	@Override
	public boolean deleteClient(int clientId) throws ClientException {
		ClientBean clientBean = searchClient(clientId);
		if (clientBean != null) {
			h1.remove(clientId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ClientBean searchClient(int id) throws ClientException {
		if (h1.containsKey(id)) {
			return h1.get(id);
		}
		return null;
	}
}