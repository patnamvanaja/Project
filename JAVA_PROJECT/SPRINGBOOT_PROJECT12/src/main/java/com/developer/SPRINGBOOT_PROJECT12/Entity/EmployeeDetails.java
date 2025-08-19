package com.developer.SPRINGBOOT_PROJECT12.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "field cannot be empty")
	private String firstName;
	@NotEmpty(message = "field cannot be empty")
	private String lastName;
	@NotEmpty(message = "field cannot be empty")
	@Email
	private String emailId;
	
	

}
