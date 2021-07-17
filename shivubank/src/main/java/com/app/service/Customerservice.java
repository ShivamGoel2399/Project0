package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;

public interface Customerservice {
	 
	public Customer registercustomer(Customer customer) throws BusinessException;
	
	public String getpasswordbycustomerid(long customerid) throws BusinessException;
	
	public Account createAccount(Account account) throws BusinessException;
	public long getcustomerid(long customerid) throws BusinessException;
}
