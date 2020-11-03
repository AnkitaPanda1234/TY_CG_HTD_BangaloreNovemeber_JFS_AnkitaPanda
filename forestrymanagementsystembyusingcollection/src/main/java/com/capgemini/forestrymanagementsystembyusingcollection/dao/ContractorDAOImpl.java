package com.capgemini.forestrymanagementsystembyusingcollection.dao;

import java.util.HashMap;

import com.capgemini.forestrymanagementsystembyusingcollection.baen.ContractorBean;
import com.capgemini.forestrymanagementsystembyusingcollection.baen.ProductBean;
import com.capgemini.forestrymanagementsystembyusingcollection.exception.ContractException;
import com.capgemini.forestrymanagementsystembyusingcollection.factory.ForestDaoManager;
public class ContractorDAOImpl implements ContractorDAO {

	static HashMap<Integer, ContractorBean> h2 = new HashMap<Integer, ContractorBean>();
	static ProductDAO productDAO = ForestDaoManager.instanceofProductDAOImpl();

	@Override
	public boolean addContarctor(ContractorBean contractor, int contractNo) throws ContractException {

		h2.put(contractNo, contractor);
		if (h2.containsKey(contractNo)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteContarctor(int contractNo) throws ContractException {

		ContractorBean contractorBean = searchContract(contractNo);
		if (contractorBean != null) {

			int productId = contractorBean.getProductId();
			long returnQuantity = contractorBean.getQunatity();

			ProductBean productBean = productDAO.searchProduct(productId);
			String prodName = productBean.getProductName();
			long actualQuantity = productBean.getProductQuantity();
			long totalQuantity = returnQuantity + actualQuantity;

			ProductBean updatedProdctBean = new ProductBean();
			updatedProdctBean.setProductId(productId);
			updatedProdctBean.setProductName(prodName);
			updatedProdctBean.setProductQuantity(totalQuantity);

			productDAO.modifyproduct(productId, updatedProdctBean);
			h2.remove(contractNo);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public void getAllContracts() throws ContractException {
		if (!h2.isEmpty()) {
			System.out.println(h2);
		} else {
			System.out.println("Currently There is no contract to View ");
		}

	}

	@Override
	public ContractorBean searchContract(int contractNo) throws ContractException {
		if (h2.containsKey(contractNo)) {
			return h2.get(contractNo);
		} else {
			return null;
		}
	}

	@Override
	public boolean modifyContract(int contractNo, ContractorBean contractorBean) throws ContractException {
		ContractorBean contrctBean = searchContract(contractNo);
		if (contrctBean != null) {
			h2.replace(contractNo, contractorBean);
			return true;
		} else {
			System.out.println("Contract Id Not Found To Modify");
			return false;
		}
	}

}
