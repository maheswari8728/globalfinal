package com.capgemini.contactbook.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.util.DBConnection;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoImpl implements IContactBookDao{

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException, SQLException, IOException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int queryResult=0;
		try {
			preparedStatement=connection.prepareStatement("insert into table name values");
			preparedStatement.setInt(1, enqry.getEnqryId());
			preparedStatement.setString(2, enqry.getfName());
			preparedStatement.setString(3, enqry.getiName());
			preparedStatement.setString(4, enqry.getContactNo());
			preparedStatement.setString(5, enqry.getpDomain());
			preparedStatement.setString(6, enqry.getpLocation());
			queryResult=preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("select * from table name");
			resultSet=preparedStatement.executeQuery();
			
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			
		}
		
		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				
			}
			
		}
		return queryResult;
	
	}

	@Override
	public EnquiryBean getEnquiryDetails(int enqryId) throws ContactBookException, SQLException, IOException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		EnquiryBean enqry=new EnquiryBean();
		try {
			preparedStatement=connection.prepareStatement("select * from table name");
			preparedStatement.setInt(1,enqryId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				enqry = new EnquiryBean();
				enqry.setEnqryId(resultSet.getInt(1));
				enqry.setfName(resultSet.getString(2));
				enqry.setiName(resultSet.getString(3));
				enqry.setpDomain(resultSet.getString(4));
				enqry.setpLocation(resultSet.getString(5));
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				System.err.println(e);

			}
		}
		return enqry;
	}

}
