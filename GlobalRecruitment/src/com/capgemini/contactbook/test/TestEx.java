package com.capgemini.contactbook.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.*;

import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.dao.IContactBookDao;
import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookServiceImpl;
import com.capgemini.contactbook.service.IContactBookService;
import com.igate.contactbook.bean.EnquiryBean;

public class TestEx 
{
	
	IContactBookService contactBookService = new ContactBookServiceImpl();
	IContactBookDao contactBookDao=new ContactBookDaoImpl();
	EnquiryBean enqry = new EnquiryBean();
	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testaddEnquiry() throws ContactBookException, SQLException, IOException {
		assertNotNull(contactBookDao.addEnquiry(enqry));
	}
	@Test
	public void testaddEnquiry1() throws ContactBookException, SQLException, IOException {
		assertEquals(1,contactBookDao.addEnquiry(enqry));
		
	}
	
   @Test
   public void testaddEnquiry2() throws ContactBookException
	{
	    enqry.setEnqryId(1);
	    enqry.setiName("Narvaneni");
		enqry.setfName("Vinitha");
		enqry.setContactNo("9703612617");
		enqry.setpDomain("Java");
		enqry.setpLocation("Chennai");
	
	assertTrue(contactBookService.isValidEnquiry(enqry));
	}
   
   @Test
   public void testById() throws ContactBookException, SQLException, IOException{
	   assertNotNull(contactBookDao.getEnquiryDetails(1));
   }
   
   @Test
   public void testById1() throws ContactBookException, SQLException, IOException {
			assertEquals("TestName", contactBookDao.getEnquiryDetails(1).getfName());
		}
   
}
