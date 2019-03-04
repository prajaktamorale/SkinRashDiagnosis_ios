package com.appsquad.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.appsquad.model.Patients;


public class PatientMapper implements RowMapper {
   public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
	  
	   Patients patientMapper = new Patients();
	   patientMapper.setName(rs.getString("name"));
	   patientMapper.setDoctor(rs.getString("doctor"));
	   patientMapper.setHeight(rs.getString("height"));
	   patientMapper.setWeight(rs.getString("weight"));
	   patientMapper.setSex(rs.getString("sex"));
	   patientMapper.setAge(rs.getString("age"));
	   patientMapper.setApptdate(rs.getString("apptdate"));
	   patientMapper.setBloodType(rs.getString("bloodType"));
	   
      return patientMapper;
   }
}