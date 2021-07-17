package com.app.service.impl;

import com.app.dao.Bankdao;
import com.app.dao.impl.Bankdaoimpl;
import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.service.Customerservice;

public class Customerserviceimpl implements Customerservice {
	
	private Bankdao bankdao= new Bankdaoimpl();

	@Override
	public Customer registercustomer(Customer customer) throws BusinessException {
		if(customer!=null) {
			customer =bankdao.registercustomer(customer);
			}
		else 
			{
				throw new BusinessException("not registered");
			}
		return customer;
		
	}

	

	@Override
	public String getpasswordbycustomerid(long customerid) throws BusinessException {
		if(customerid == 0) {
			throw new BusinessException("\n Enter Correct Customerid. Exception From CustomerServiceimpl. ");
		}else {
			return bankdao.getpasswordbycustomerid(customerid);
		}
		
		
	}

	@Override
	public Account createAccount(Account account) throws BusinessException {
		if(account!=null) {
			account=bankdao.createAccount(account);
		}else {
			throw new BusinessException("Account Not Opened. Please, Try Again. Exception From CustomerServiceimpl.");
		}
			return account;
	}



	@Override
	public long getcustomerid(long customerid) throws BusinessException {
		if(customerid == 0) {
			throw new BusinessException("\nEnter Correct Customerid. Exception from CustomerServiceimpl. ");
		}else {
		return bankdao.getcustomerid(customerid);
		}
	
	}

}
