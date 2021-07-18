package com.app.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.main.BankMain;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Transaction;
import com.app.model.Account;
import com.app.service.Customerservice;
import com.app.service.impl.Customerserviceimpl;
import com.app.service.Employeeservice;
import com.app.service.impl.Employeeserviceimpl;

public class BankMain {

	private static Logger log = Logger.getLogger(BankMain.class);
	

	public static void main(String[] args) throws BusinessException { //main open
		Scanner sc = new Scanner(System.in);
		Customerservice customerservice = new Customerserviceimpl();
		Employeeservice employeeservice= new Employeeserviceimpl();
		boolean z = false;
		int ch = 0;
		do {  // main.do open 
			log.info("Welcome to ShivuBank V1.0");
			log.info("==================================");
			log.info("\nBANK'S MENU");
			log.info("1)LOGIN");
			log.info("2)REGISTER AS CUSTOMER");
			log.info("3)EXIT");
			log.info("Enter your Choice 1-3");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
			}
			switch (ch) {  // switch ch open
			case 1:
				int s = 0;
				do { // second do open
					log.info("\nBANK'S MENU");
					log.info("============================================");
					log.info("1)LOGIN AS EMPLOYEE");
					log.info("2)LOGIN AS CUSTOMER");
					log.info("3)MAIN MENU");
					log.info("4)EXIT");
					log.info("=============================================");
					log.info("If You Are New Here. Please Register First");
					try {
						s = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						log.warn(e.getMessage());
					}

					switch(s) { // switch s open
					case 1:
						
						log.info("\nWELCOME TO EMPLOYEE LOGIN SCREEN");				
						log.info("=====================================================");
						long employeeid = 0;
						do { z=true;
						log.info("ENTER THE REGISTERED ID FOR EMPLOYEE \n");
						long emp=0;
						try {
							employeeid= Long.parseLong(sc.nextLine());
							emp= employeeservice.getemployeeid(employeeid);
						}catch(NumberFormatException e1){
							log.warn(e1.getMessage());
						}catch (BusinessException e1) {
							log.warn(e1.getMessage());
						}
						if(employeeid==emp) {
							log.info("Employee id found");
						}else {
							log.info("Invalid Employee id... Enter it again");
							z=false;
						}
						}while(!z);
						
						do { z=true;
						log.info("ENTER THE REGISTERED PASSWORD FOR EMPLOYEE \n");
						String employeepassword= sc.nextLine();
						String emp1=null;
						try {
						emp1= employeeservice.getPasswordByemployeeId(employeeid);
						}catch (BusinessException e1) {
							log.warn(e1.getMessage());
						}
						if(employeepassword.equals(emp1)) {
							log.info("Employee password correct");
						}else {
							log.info("Invalid Employee password... Enter it again");
							z=false;
						}
						}while(!z);
						
								log.info("Hello Employee with id no. : " + employeeid);
								int ch2 = 0;
								do {   // third do open
									
									log.info("Employee logged into account" + employeeid);
									log.info("Welcome to ShivuBank Management");
									log.info("You have successfully logged in");
									log.info("Select the operation you want perform");
									log.info("Press 1 to see all customers\n"+"press 2 to enable/disable account\n"+"press 3 to logout");
									try {
										ch2 = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
										log.info(e.getMessage());
									}
									switch (ch2) { // switch ch2 open
									case 1 : 
										List<Customer> customerList=new ArrayList<>();
									if(customerList!=null) {	 
										for(Customer c:customerList) {
											log.info(c);
											}
										}
									break;
									case 2 :break;
									case 3 :
										log.info("Thankyou For Using ShivuBank App.. Have a Nice Day");
										break;
									default:
										log.info("Entered option is invalid... try entering 1-3");
										break;
									} //switch ch2 close
									}while(ch2 != 3); //third do close
						
					break;
				
						
					case 2:
						log.info("\nWELCOME TO CUSTOMER LOGIN SCREEN");				
						log.info("======================================================");
						long customerid = 0;
						do { z=true;
						log.info("ENTER THE REGISTERED ID FOR CUSTOMER \n");
						long cust=0;
						try {
							customerid= Long.parseLong(sc.nextLine());
							cust= customerservice.getcustomerid(customerid);
						}catch(NumberFormatException e2){
							log.warn(e2.getMessage());
						}catch(BusinessException e2){
							log.warn(e2.getMessage());
						}
						if(customerid==cust) {
							log.info("Customer id found");
						}else {
							log.info("Invalid Customer id... Enter it again");
							z=false;
						}
						}while(!z);
						do { z=true;
						log.info("ENTER THE REGISTERED PASSWORD FOR CUSTOMER \n");
						String customerpassword= sc.nextLine();
						String cust1=null;
						try {
						cust1= customerservice.getpasswordbycustomerid(customerid);
						}catch(BusinessException e2){
							log.warn(e2.getMessage());
						}
						if(customerpassword.equals(cust1)) {
							log.info("Customer password correct");
						}else {
							log.info("Invalid Customer password... Enter it again");
							z=false;
						}
						}while(!z);
						log.info("Hello Customer with id no. : " + customerid);	
						int ch1=0;
						do { //do  open
									
									log.info("CUSTOMER LOGGED INTO ACCOUNT WITH ID NO :" + customerid);
									log.info("WELCOME TO SHIVUBANK");
									log.info("YOU HAVE SUCCESSFULLY LOGGED IN");
									log.info("MENU");
									log.info("press 1 to open New Account\n" + "press 2 to Transfer\n"
											+ "press 3 to Withdraw\n" + "press 4 to Deposit\n"
											+ "press 5 to view statements\n" + "press 6 to Logout");
									try {
										ch1 = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
										log.info(e.getMessage());
									}
									switch (ch1) {  // switch ch1 open
									case 1:
										Account account =null;
										long customerid1 =0;
										do { z=true;
										log.info("Enter the registered id");
										try { 
										customerid1 = Long.parseLong(sc.nextLine());
										}catch(NumberFormatException e){
											log.warn("Enter a Valid id");
										}
										long a=customerid1;
										if(!(Long.toString(a).matches("[0-9]{6}"))) {
											log.warn("Enter A Valid Id");
											z=false;
										}
										}while(!z);
										log.info("Enter your Account type Details");
										String accounttype= sc.nextLine();
										float accountbalance =0;
										do { z=true;
										log.info("Enter your Opening Balance Amount");
										try {
										accountbalance = Float.parseFloat(sc.nextLine());
										}catch(NumberFormatException e){
											log.warn("Enter only Value in Numbers");
											z=false;
										}
										}while(!z);
										do { z=true;
										log.info("Enter your aadhar card number");
										String customeraadharno = sc.nextLine();
										if(customeraadharno.matches("[0-9]{12}")) {
											 account=new Account(accountbalance, accounttype,customerid1,customeraadharno);
										}else{
											log.warn("Invalid aadhar Details. Enter Correct Details.");
											z=false;	
										}
										}while(!z);
										try {
											account=customerservice.createAccount(account);
											if(account!=null) {
												log.info("Successfully registered to ShivuBank");
												log.info(account);
											}
										}catch (BusinessException e) {
											log.warn("Account Not Created");
										}
										break;
									case 2: break;
									case 3: 
										long customeraccountno =0;
										do { z=true;
										log.info("Enter the registered Accountno");
										long acc=0;
										try { 
										customeraccountno = Long.parseLong(sc.nextLine());
										long a=customeraccountno;
										if(!(Long.toString(a).matches("[0-9]{12}"))) {
											log.warn("Enter A Valid Accountno");
											z=false;
											continue;
										}
										acc= customerservice.getaccountno(customeraccountno);
										}catch(NumberFormatException e){
											log.warn("Enter a Valid Accountno");
										}catch(BusinessException e) {
											log.warn(e.getMessage());
										}
										if(customeraccountno==acc) {
											log.info("Accountno. id found");
										}else {
											log.info("Invalid Accountno. ... Enter it again");
											z=false;
										}
										}while(!z);
										do{z=true;
										log.info("Enter the Amount you Want to Withdarw");
										float amount=0;
										float balance=0;
										float newbalance=0;
										String customername1=null;
										try {
											amount=Float.parseFloat((sc.nextLine()));
											balance=customerservice.checkbalancebyaccountno(customeraccountno);
											if(amount<=0) {
												log.warn("Enter a positive and Valid Value for Withdrawl");
												continue;
											}
										}catch(NumberFormatException e) {
											log.warn("Enter the amount in Numbers only");	
										}catch(BusinessException e) {
											log.warn(e);
										}
										if(balance < amount) {
											log.warn("Enter the Valid Amount to Withdraw");
											z=false;
										}else {
											newbalance = customerservice.withdraw(balance, amount, customeraccountno);
											customername1=customerservice.getcustomernamebyaccountno(customeraccountno);
											log.info("Amount Withdrawn : "+amount+" from Accountno : "+customeraccountno+" Account holder name : "+customername1+" New Balance is : "+ newbalance);
										}
										
										}while(!z);
										
										
										
										
										break;
									case 4: 
										long customeraccountno1 =0;
										do { z=true;
										log.info("Enter the registered Accountno");
										long acc=0;
										try { 
										customeraccountno1 = Long.parseLong(sc.nextLine());
										long a=customeraccountno1;
										if(!(Long.toString(a).matches("[0-9]{12}"))) {
											log.warn("Enter A Valid Accountno");
											z=false;
											continue;
										}
										acc= customerservice.getaccountno(customeraccountno1);
										}catch(NumberFormatException e){
											log.warn("Enter a Valid Accountno");
										}catch(BusinessException e) {
											log.warn(e.getMessage());
										}
										if(customeraccountno1==acc) {
											log.info("Accountno. id found");
										}else {
											log.info("Invalid Accountno. ... Enter it again");
											z=false;
										}
										}while(!z);
										do{z=true;
										log.info("Enter the Amount you Want to Deposit");
										float amount=0;
										float balance=0;
										float newbalance=0;
										String customername1=null;
										try {
											amount=Float.parseFloat((sc.nextLine()));
											balance=customerservice.checkbalancebyaccountno(customeraccountno1);
											if(amount<=0) {
												log.warn("Enter a positive and Valid Value for Deposition");
												continue;
											}
										}catch(NumberFormatException e) {
											log.warn("Enter the amount in Numbers only");	
										}catch(BusinessException e) {
											log.warn(e);
										}
										if(amount<=0) {
											log.warn("Enter the Valid Amount to Deposit");
											z=false;
										}else {
											newbalance = customerservice.deposit(balance, amount, customeraccountno1);
											customername1=customerservice.getcustomernamebyaccountno(customeraccountno1);
											log.info("Amount Deposited : "+amount+" from Accountno : "+customeraccountno1+" Account holder name : "+customername1+" New Balance is : "+ newbalance);
										}
										
										}while(!z);
										
										break;
									case 5:
										
									case 6:
										log.info("Thank you for using our Banking Services. Goodbye....!");
										break;
									default :
										log.warn("Invalid Choice... Please enter input between 1-4");
										break;
										
									}
						
									}while(ch1!=6); // switch ch1 close
									
					case 3:
						log.info("\n\nGoing to Main Menu............\n\n");
						break;
					case 4:
						log.info("Thanks for using our ShivuBank App.. See you soon. :)");
						System.exit(0);
					default:
						log.warn("Invalid Choice... Please enter input between 1-4");
						break;
					
					
					
					}
					
					}while (s != 4);
						
				break;
			case 2:
				log.info("Welcome to the Registration Page");
				log.info("=============================");
				try {
					Customer customer2 = new Customer();
				
					log.info("Enter your name ");
					String customername = sc.nextLine();
					log.info("Enter your gender (Male/Female/Other) ");
					String customergender= sc.nextLine();
					log.info("Enter your Email Id ");
					String customeremailid = sc.nextLine();
					long customerphoneno = 0;
					do { z=true;
					log.info("Enter your Phone Number");
					try { 
					customerphoneno = Long.parseLong(sc.nextLine());
					}catch(NumberFormatException e){
						log.warn("Enter only Numbers");
					}
					long a=customerphoneno;
					if(!Long.toString(a).matches("[0-9]{10}")) {
						log.warn("Enter valid PhoneNo");
						z=false;
					}
					}while(!z);
					log.info("Enter your password");
					String customerpassword = sc.nextLine();
					log.info("Enter your Pan Card");
					String customerpancard=sc.nextLine();
					if(customerpancard.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
					customer2 = new Customer(customername,customerphoneno,customergender,customeremailid,customerpassword,customerpancard);
					customer2 = customerservice.registercustomer(customer2);
					}
					else{
						log.warn("Invalid Pancard Details");
					}
					if (customer2 != null) {
						log.info("Successfully registered to ShivuBank");
						log.info(customer2);
					}
				} catch (NumberFormatException e) {
					log.warn(e.getMessage());
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 3: 
				log.info("Thanks for using our ShivuBank App.. See you soon. :)");
				break;
			default:
				log.warn("Invalid Choice... Please enter input between 1-3");
				break;	

					
					
							
			}
}while (ch != 3);
				
			}


	
	
		}

