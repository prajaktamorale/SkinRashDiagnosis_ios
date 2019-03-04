package com.appsquad.db;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.appsquad.dao.PatientsDAO;
import com.appsquad.model.Patients;

public class PatientsJDBCTemplate implements PatientsDAO {
	
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void createTable(String tableName) {
		
		jdbcTemplateObject.execute("DROP TABLE IF EXISTS appsquad");
		jdbcTemplateObject.execute("CREATE TABLE appsquad(" +
                "id SERIAL, name VARCHAR(255), doctor VARCHAR(255), "
                + "height VARCHAR(255), weight VARCHAR(255), bloodType VARCHAR(255), sex VARCHAR(255), "
                + "age VARCHAR(255), apptdate VARCHAR(255))");

		 
		System.out.println("Created table Name " + tableName);
		return;

	}

	@Override
	public void createInstances(String table, Patients patients) {
		String SQL = "insert into " + table + " (name , doctor, height, weight, bloodType, sex, age, apptdate) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
		Object[] values = new Object[] { patients.getName() , patients.getDoctor(), patients.getHeight(), patients.getWeight(), patients.getBloodType(), patients.getSex(), patients.getAge(), patients.getApptdate() };
		jdbcTemplateObject.update(SQL, values);
		System.out.println("Created Record Name = " + patients.getName() );
		return;
	}


	@Override
	public List<Patients> listInstances(String table) {
		 
		String SQL = "select * from " + table;
		List<Patients> patients = jdbcTemplateObject.query(SQL, new PatientMapper());
		return patients;
	}
}