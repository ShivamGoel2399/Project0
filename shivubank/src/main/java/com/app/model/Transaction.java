package com.app.model;

public class Transaction {
		
	private long transactionid;
	private String transactiontype;
	private String customeraccountno;
	
	public Transaction() {}

	public Transaction(long transactionid, String transactiontype) {
		super();
		this.transactionid = transactionid;
		this.transactiontype = transactiontype;
		}

	public long getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public String getCustomeraccountno() {
		return customeraccountno;
	}

	public void setCustomeraccountno(String customeraccountno) {
		this.customeraccountno = customeraccountno;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactiontype=" + transactiontype
				+ ", customeraccountno=" + customeraccountno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customeraccountno == null) ? 0 : customeraccountno.hashCode());
		result = prime * result + (int) (transactionid ^ (transactionid >>> 32));
		result = prime * result + ((transactiontype == null) ? 0 : transactiontype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (customeraccountno == null) {
			if (other.customeraccountno != null)
				return false;
		} else if (!customeraccountno.equals(other.customeraccountno))
			return false;
		if (transactionid != other.transactionid)
			return false;
		if (transactiontype == null) {
			if (other.transactiontype != null)
				return false;
		} else if (!transactiontype.equals(other.transactiontype))
			return false;
		return true;
	}
	
	
	
	
}
