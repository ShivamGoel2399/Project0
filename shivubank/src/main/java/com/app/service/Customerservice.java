package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;

public interface Customerservice {
	 
	public Customer registercustomer(Customer customer) throws BusinessException;
	
	public String getpasswordbycustomerid(long customerid) throws BusinessException;
	
	public Account createAccount(Account account) throws BusinessException;
	public long getcustomerid(long customerid) throws BusinessException; 
	public long getaccountno(long accountno)throws BusinessException;
	public float checkbalancebyaccountno(long accountno) throws BusinessException;
	public String getcustomernamebyaccountno(long accountno)throws BusinessException;
	public float withdraw(float balance,float amount,long accountno) throws BusinessException;
	public float deposit(float balance,float amount,long accountno) throws BusinessException;
}
