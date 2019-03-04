package com.appsquad.dao;

import java.util.List;

import javax.sql.DataSource;

import com.appsquad.model.Patients;

public interface PatientsDAO {
		
	   public void setDataSource(DataSource ds);
	   public void createInstances(String table, Patients patient);
	   
	   public List<Patients> listInstances(String table);
}
