package com.capgemini.contactbook.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.dao.IContactBookDao;
import com.capgemini.contactbook.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookServiceImpl implements  IContactBookService {

	IContactBookDao contactBookDao=new ContactBookDaoImpl();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, SQLException, IOException {
		
		int addseq;
		addseq=contactBookDao.addEnquiry(enqry);
		return addseq;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int enqryId) throws ContactBookException, SQLException, IOException {
		return contactBookDao.getEnquiryDetails(enqryId);
		
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException {

		boolean isvalid=false;
        List<String> validationErrors=new ArrayList<String>();
        
       if(!(isValidenqryId(enqry.getEnqryId())))
		        {
	       validationErrors.add("The id should be a number\n");
	       isvalid=false;
		        }
		
		if(!(isValidfName(enqry.getfName())))
				{
			validationErrors.add("First name should startwith capital letter\n"
					+ "The minimum length should be 5 words\n");
			isvalid=false;
				}
				
		if(!(isValidiName(enqry.getiName())))
				{
			validationErrors.add("Last name should startwith capital letter\n"
					+ "The minimum length should be 5 words\n");
			isvalid=false;
				}
		
	    if(!(isValidcontactNo(enqry.getContactNo())))
				{
			validationErrors.add("The contact number should be in digits and should have a length of 10 digits\n");
			isvalid=false;
				}
	    
	    if(!(isValidpDomain(enqry.getpDomain())))
		       {
	        validationErrors.add("Name Should startwith Capital letter\n");
	        isvalid=false;
		       }

		if(!(isValidpLocation(enqry.getpLocation())))
				{
			validationErrors.add("Name Should startwith Capital letter\n");
			isvalid=false;
				}
		if(isvalid==true)
	        return true;
		else 
			return false;
	}

	private boolean isValidpDomain(String pDomain) {
		
		Pattern pattern=Pattern.compile("^[A-Z][a-z]*");
		Matcher nameMatcher=pattern.matcher(pDomain);
		return nameMatcher.matches();
	}

	private boolean isValidpLocation(String pLocation) {
		
		Pattern pattern=Pattern.compile("^[A-Z][a-z]*");
		Matcher nameMatcher=pattern.matcher(pLocation);
		return nameMatcher.matches();
	}

	private boolean isValidcontactNo(String contactNo) {
		
		Pattern pattern=Pattern.compile("^[0-9]{10}");
		Matcher numberMatcher=pattern.matcher(contactNo);
		return numberMatcher.matches();
	}

	private boolean isValidenqryId(int EnqryId) {
		
		Pattern pattern=Pattern.compile("^[0-9]*{1,}");
		Matcher numberMatcher=pattern.matcher("EnqryId");
		return numberMatcher.matches();
	}

	private boolean isValidiName(String iName) {
		
		Pattern pattern=Pattern.compile("^[A-Z][a-z]{5,}");
		Matcher nameMatcher=pattern.matcher(iName);
		return nameMatcher.matches();
	}

	private boolean isValidfName(String fName) {
		Pattern pattern=Pattern.compile("^[A-Z][a-z]{5,}");
		Matcher nameMatcher=pattern.matcher(fName);
		return nameMatcher.matches();
	}

	
}
