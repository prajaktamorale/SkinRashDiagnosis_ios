package com.appsquad.db;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.appsquad.model.Patients;

public class PatientOperations {

	ApplicationContext dbContext;

	public PatientOperations(ApplicationContext dbContext) {
		this.dbContext = dbContext;
	}

	public void computeDatabaseOperation(Patients patient) {
		PatientsJDBCTemplate patientJDBCTemplate = (PatientsJDBCTemplate) dbContext.getBean("patientJDBCTemplate");

		String computeTable = "appsquad";
		patientJDBCTemplate.createTable(computeTable);

		System.out.println("------Records Creation--------");
		patientJDBCTemplate.createInstances(computeTable, patient);

		System.out.println("------Listing Multiple Records--------");
		List<Patients> instances = patientJDBCTemplate.listInstances(computeTable);
		for (Patients record : instances) {
			System.out.print("Name : " + record.getName());
		}
	}
}