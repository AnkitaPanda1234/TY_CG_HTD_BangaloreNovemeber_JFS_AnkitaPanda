package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.ProductResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(path = "/register", 
	produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductBean bean) {
		ProductResponse response = new ProductResponse();
		if (service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Product Registered");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription(" Product Already Exits");
		}
		return response;
	}
	 @GetMapping(path="/getproduct",produces = MediaType.APPLICATION_JSON_VALUE)
		public ProductResponse getProduct(@RequestParam("productid") int productid) {
			ProductResponse response = new ProductResponse();
			ProductBean bean = service.getProduct(productid);
			if (bean == null) {
				response.setStatusCode(401);
				response.setMessage("failuer");
				response.setDescription("Record with perticuler id does'nt exit");

			} else {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription(" Product found");

			}
			return response;
		}

	 @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
		public ProductResponse getAllProduct() {
			ProductResponse response = new ProductResponse();
			List<ProductBean> bean = service.getAllProduct();
			if (bean.size()==0) {

				response.setStatusCode(401);
				response.setMessage("failuer");
				response.setDescription("Record  does'nt exit");
				
			} else {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription(" All Product found");
				response.setBeans(bean);
				
			}
			return response;

		}
}
