package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.model.Employee;

public interface Bankdao {
	
	
	public Customer registercustomer(Customer customer) throws BusinessException;
	
	public String getpasswordbycustomerid(long customerid) throws BusinessException;
	
	public Account createAccount(Account account) throws BusinessException;
	public List<Customer> getAllCustomers() throws BusinessException;
	public String getPasswordByemployeeId(long employeeid) throws BusinessException;

	public long getemployeeid(long employeeid) throws BusinessException;
	public long getcustomerid(long customerid) throws BusinessException;
}
