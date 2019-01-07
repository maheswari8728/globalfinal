package com.capgemini.contactbook.service;

import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.contactbook.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface IContactBookService {
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, SQLException, IOException;
	public EnquiryBean getEnquiryDetails(int enqryId) throws ContactBookException, SQLException, IOException;
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException;
	

}
