package com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.dto.UserBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.config.controller.exception.UserException;
@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceUnit
	private EntityManagerFactory factory;


	@Override
	public boolean add(UserBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
		manager.persist(bean);
		transaction.commit();
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new UserException("Emial already exit");	
		}
	}

	@Override
	public UserBean auth(String email, String password) {
		
		EntityManager manager=factory.createEntityManager();
		String jpql="from UserBean where email=:email ";
		TypedQuery <UserBean>query=manager.createQuery(jpql,UserBean.class);
		  query.setParameter("email", email);
		 // query.setParameter("password", password);
		  try {
			  UserBean bean= query.getSingleResult();
			  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			 if( encoder.matches(password, bean.getPassword()))
			 {
				 return bean; 
			 }else
			 {
				throw new UserException("password invalid"); 
			 }
			  
		  }catch(Exception e)
		  {
			 throw   new UserException("Email  invalid"); 
		  }
			  
			 
		
		
	}

	@Override
	public boolean changePassword(int id, String password) {
		
		EntityManager manager=factory.createEntityManager();
		  EntityTransaction transaction=manager.getTransaction();
		  transaction.begin();
		  UserBean bean=manager.find(UserBean.class, id);
		  bean.setPassword(password);
		  transaction.commit();
			return true;
		}

}
