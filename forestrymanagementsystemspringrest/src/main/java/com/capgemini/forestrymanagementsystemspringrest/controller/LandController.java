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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.forestrymanagementsystemspringrest.dto.LandBean;
import com.capgemini.forestrymanagementsystemspringrest.dto.LandResponse;
import com.capgemini.forestrymanagementsystemspringrest.exception.LandException;
import com.capgemini.forestrymanagementsystemspringrest.service.LandService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class LandController {
	@Autowired
	private LandService service;

	@PostMapping(path = "/addlanddetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse register(@RequestBody LandBean land) {
		LandResponse response = new LandResponse();

		if (service.addLandDetails(land)) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("land Details Added Sucessfully");
		} else {
			response.setStatusCode(201);
			response.setMessage("failure");
			response.setDescription("Land Details already exit");
		}

		return response;
	}

	@DeleteMapping(path = "/deleteland/{landid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse deleteLandDetails(@PathVariable("landid") int landid) {
		LandResponse response = new LandResponse();

		boolean deleteFlag = false;
		try {
			deleteFlag = service.deleteLandDetails(landid);
		} catch (LandException e) {
			System.out.println(e.getMessage());
		}

		if (deleteFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("land Details Deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry, Not able to Delete Land ");
		}
		return response;

	}

	// update
	@PutMapping(path = "/modifyland", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse updateLandDeatails(@RequestBody LandBean bean) {
		LandResponse response = new LandResponse();
		List<LandBean> landList = new ArrayList<LandBean>();
		landList.add(bean);
		boolean updateFlag = false;
		try {
			updateFlag = service.updateLandDeatails(bean.getLandid(), bean.getLandValue());
		} catch (LandException e) {
			System.out.println(e.getMessage());
		}
		if (updateFlag) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Landvalue updated Successfully");
			response.setBeans(landList);
		} else {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry, Not able to Update Land Value");
		}
		return response;
	}

	@GetMapping(path = "/getAllland", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse showLandDetails() {
		LandResponse response = new LandResponse();
		List<LandBean> landList = null;

		try {
			landList = service.showLandDetails();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (landList.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Currently There is no land details found");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Land Details :");
			response.setBeans(landList);

		}
		return response;
	}

	@GetMapping(path = "/searchland", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse viewLandDetails(@RequestParam("landid") int landid) {
		LandResponse response = new LandResponse();
		LandBean bean = null;

		try {
			bean = service.viewLandDetails(landid);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

		if (bean == null) {
			response.setStatusCode(401);
			response.setMessage("failuer");
			response.setDescription("Sorry,Currently There is no land details found for Id: " + landid);

		} else {
			List<LandBean> landList = new ArrayList<LandBean>();
			landList.add(bean);
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Land Details :");
			response.setBeans(landList);

		}
		return response;
	}

}
