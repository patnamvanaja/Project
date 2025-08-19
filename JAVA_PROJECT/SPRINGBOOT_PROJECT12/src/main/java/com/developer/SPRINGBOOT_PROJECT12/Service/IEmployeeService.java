package com.developer.SPRINGBOOT_PROJECT12.Service;

import java.util.List;

import com.developer.SPRINGBOOT_PROJECT12.Entity.EmployeeDetails;

public interface IEmployeeService {
	

	    // 1. Fetch all records
	    List<EmployeeDetails> fetchAllRecords();

	    // 2. Insert a new record
	    EmployeeDetails insertNewRecord(EmployeeDetails details);

	    // 3. Fetch a record by ID
	    EmployeeDetails fetchRecordById(long id);

	    // 4. Delete record by ID
	    void deleteRecordById(long id);

	    // 5. Update record by ID
	    EmployeeDetails updateRecordById(long id, EmployeeDetails newDetails);

		void deleteById(long id);
	}



