package com.developer.SPRINGBOOT_PROJECT12.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.SPRINGBOOT_PROJECT12.Entity.EmployeeDetails;
import com.developer.SPRINGBOOT_PROJECT12.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<EmployeeDetails> fetchAllRecords() {
        return repository.findAll();
    }

    @Override
    public EmployeeDetails insertNewRecord(EmployeeDetails details) {
        return repository.save(details);
    }

    @Override
    public EmployeeDetails fetchRecordById(long id) {
        Optional<EmployeeDetails> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteRecordById(long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeDetails updateRecordById(long id, EmployeeDetails newDetails) {
        Optional<EmployeeDetails> optional = repository.findById(id);
        if (optional.isPresent()) {
            EmployeeDetails existing = optional.get();
            existing.setFirstName(newDetails.getFirstName());
            existing.setLastName(newDetails.getLastName());
            existing.setEmailId(newDetails.getEmailId());
            return repository.save(existing);
        } else {
            return null; // or throw exception
        }
    }

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
}
