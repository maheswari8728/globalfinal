package com.capgemini.contactbook.ul;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.PropertyConfigurator;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookServiceImpl;
import com.capgemini.contactbook.service.IContactBookService;
import com.igate.contactbook.bean.EnquiryBean;

public class Client {
	
	static Scanner sc=new Scanner(System.in);
	static IContactBookService contactBookService=null;
	static ContactBookServiceImpl contactBookServiceImpl=null;
	static Logger logger = Logger.getRootLogger();

	
	public static void main(String args[]) throws SQLException, IOException
	{
		PropertyConfigurator.configure("Resources//log4j.properties");
		EnquiryBean enqry=new EnquiryBean();
		int option=0;
		while(true)
		{
			System.out.println("********************Global Recruitments****************");
			System.out.println("Choose an operation");
			System.out.println("1.Enter Enquiry Details");
			System.out.println("2.View Enquiry Details");
			System.out.println("0.exit");
			System.out.println("*******************************************************");
			System.out.println("Please enter a choice:");
			try {
			option=sc.nextInt();
			System.out.println("*******************************************************");
			switch(option)
			{
			case 1: while(enqry==null) {
			
				    enqry=populateEnquiryBean();
			
			}
			try {
				contactBookService=new ContactBookServiceImpl();
				     int enqryId = contactBookService.addEnquiry(enqry);
					 System.out.println("*******************************************************");
					 System.out.println("Thank you"+ enqry.getfName() + enqry.getiName()+"your Unique Id is"+ enqry.getEnqryId()+"we will contact you shortly\n");
					 System.out.println("*******************************************************");
			}catch(ContactBookException contactBookException) {
				logger.error("Exception occured",contactBookException);
				System.err.println("ERROR"+contactBookException.getMessage());
			}
			finally {
				contactBookService = null;
				enqry = null;
			}
			break;
			
			case 2:  contactBookService=new ContactBookServiceImpl();
			         System.out.println("Enter the enquiry id to be viewed\n");
			         int enqryId=sc.nextInt();
			         EnquiryBean view=contactBookService.getEnquiryDetails(enqryId);
			         if(view==null)
			         {
			        	 System.out.println("sorry no details found");
			         }
			        	 else
			        	 {
			        		 System.out.println(" id"+enqryId);
			        		 System.out.println("first name"+view.getfName());
			        		 System.out.println("last name"+view.getiName());
			        		 System.out.println("contactno"+view.getContactNo());
			        		 System.out.println("preferred domain"+view.getpDomain());
			        		 System.out.println("preferred location"+view.getpLocation());
			        	 }
			         break; 
			case 3:System.exit(0);
			default:
				System.out.println("Please choose the value from given options only\n and try again\n");
				break;
			}
			}catch (ContactBookException e) {
				System.err.println("Please choose the value from given options only\n and try again\n");
				
			}
			
		}
		
	}

	private static EnquiryBean populateEnquiryBean() {
		
		EnquiryBean enqry=new EnquiryBean();
		System.out.println("Enter the first name");
		enqry.setfName(sc.next());
		System.out.println("Enetr last name");
		enqry.setiName(sc.next());
		System.out.println("Enetr contactNumber");
		enqry.setContactNo(sc.next());
		System.out.println("Enter preferred Domain");
		enqry.setpDomain(sc.next());
		System.out.println("Enter preferred Location");
		enqry.setpLocation(sc.next());
		
		contactBookServiceImpl=new ContactBookServiceImpl();
		try {
			contactBookServiceImpl.isValidEnquiry(enqry);
			return enqry;
		}
		catch(Exception e) {
			
			logger.error("exception occured ", e);
			System.err.println("Invalid data");
		}
		return enqry;
	}

}
