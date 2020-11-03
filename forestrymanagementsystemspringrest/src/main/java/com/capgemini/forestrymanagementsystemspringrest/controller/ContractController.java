package com.capgemini.forestrymanagementsystemspringrest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspringrest.dto.ContractBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.ContractResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.InventoryException;
import com.capgemini.forestrymanagementsystemspringrest.service.ContractService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ContractController {
	@Autowired
	private ContractService service;

	@PostMapping(path = "/addcontract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse register(@RequestBody ContractBean contractBean) {

		contractBean.setStatus("Ordered");

		ContractResponse response = new ContractResponse();
		if (service.addContract(contractBean)) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Contract Added Sucessfully");

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Contract already exit");
		}

		return response;
	}

	@DeleteMapping(path = "/deletecontract/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse deleteContract(@PathVariable("contractId") int contractId) {
		ContractResponse response = new ContractResponse();

		boolean deleteFlag = false;
		try {
			deleteFlag = service.deleteContract(contractId);
		} catch (InventoryException e) {
			System.out.println(e.getMessage());
		}

		if (deleteFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Contract Details Deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry, Not able to Delete Contract ");
		}
		return response;

	}

	@GetMapping(path = "/getAllcontract", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse getAllContract() {
		ContractResponse response = new ContractResponse();

		List<ContractBean> contractList = null;

		try {
			contractList = service.getContract();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (contractList.isEmpty()) {

			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Currently There is no Contract details found");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Contract Details : ");
			response.setBeans(contractList);

		}

		return response;
	}

	@GetMapping(path = "/searchcontract", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse getContract(@RequestParam("contractId") int contractId) {
		ContractResponse response = new ContractResponse();
		List<ContractBean> contractList = new ArrayList<ContractBean>();

		ContractBean bean = null;

		try {
			bean = service.viewContract(contractId);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (bean == null) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Contract With Contract Id:" + contractId + " Not Present ");

		} else {
			contractList.add(bean);
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Contract Details : ");
			response.setBeans(contractList);

		}
		return response;
	}
}
