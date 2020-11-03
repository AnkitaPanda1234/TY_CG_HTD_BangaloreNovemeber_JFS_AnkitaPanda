package com.capgemini.forestrymanagementsystembyusingcollection.service;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ClientBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ClientException;

public interface ClientService {

	public ClientBean clientLogin(String username, String Password);

	public boolean addClient(int id, ClientBean clientBean);

	public void viewClients();

	public boolean deleteClient(int id);

	public boolean modifyClient(int id, ClientBean client);

	ClientBean searchClient(int id) throws ClientException;

}
