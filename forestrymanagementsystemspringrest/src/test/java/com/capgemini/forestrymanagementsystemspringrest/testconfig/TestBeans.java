package com.capgemini.forestrymanagementsystemspringrest.testconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.capgemini.forestrymanagementsystemspringrest.dao.AdminDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.AdminDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.dao.ContractDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.ContractDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.CustomerDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.dao.InventoryDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.InventoryDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.dao.LandDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.dao.LoginDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.LoginDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.dao.ScheduleDAO;
import com.capgemini.forestrymanagementsystemspringrest.dao.ScheduleDAOImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.AdminService;
import com.capgemini.forestrymanagementsystemspringrest.service.AdminServiceImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.ContractService;
import com.capgemini.forestrymanagementsystemspringrest.service.ContractServiceImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.CustomerService;
import com.capgemini.forestrymanagementsystemspringrest.service.CustomerServiceImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.InventoryService;
import com.capgemini.forestrymanagementsystemspringrest.service.InventoryServiceImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.LandService;
import com.capgemini.forestrymanagementsystemspringrest.service.LandServiceImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.LoginService;
import com.capgemini.forestrymanagementsystemspringrest.service.LoginServiceImpl;
import com.capgemini.forestrymanagementsystemspringrest.service.ScheduleService;
import com.capgemini.forestrymanagementsystemspringrest.service.ScheduleServiceImpl;

@Configuration
public class TestBeans {
	@Bean
	public AdminDAO adminDao() {
		return new AdminDAOImpl();
	}
	@Bean
   public AdminService adminService() {
	   return new AdminServiceImpl();
   }
	@Bean
   public ContractDAO contractDao() {
	   return new ContractDAOImpl();
   }
	@Bean
	public ContractService contractService() {
		return new ContractServiceImpl();
	}
	
	@Bean
	public CustomerDAO customerDao() {
		return new CustomerDAOImpl();
	}
	@Bean
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}
   @Bean
   public InventoryDAO inventoryDao() {
	   return new InventoryDAOImpl();
	   
   }
   @Bean
   public InventoryService inventoryService() {
	   return new InventoryServiceImpl();
   }
   @Bean
   public LandDAO landDao() {
	   return new LandDAOImpl();
   }
   @Bean
   public LandService landService() {
	   return new LandServiceImpl();
   }
   @Bean
   public LoginDAO loginDao() {
	   return new LoginDAOImpl();
   }
   @Bean
   public LoginService loginService() {
	   return new LoginServiceImpl();
	   
   }
   @Bean
   public ScheduleDAO scheduleDao() {
	   return new ScheduleDAOImpl();
   }
   @Bean
   public ScheduleService scheduleService() {
	   return new ScheduleServiceImpl();
   }
}
