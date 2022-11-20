package com.capstone.authentication.service;

import com.capstone.authentication.domain.EmployeeDetails;
import com.capstone.authentication.exception.EmployeeAlreadyExistsException;
import com.capstone.authentication.exception.EmployeeNotFoundException;
import com.capstone.authentication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDetails addEmployee(EmployeeDetails employeeDetails) throws EmployeeAlreadyExistsException {
        if(employeeRepository.findById(employeeDetails.getEmailId()).isPresent()){
            throw new EmployeeAlreadyExistsException();
        }else {
            return employeeRepository.save(employeeDetails);
        }
        }



    @Override
    public EmployeeDetails loginCheck(String emailId, String password) throws EmployeeNotFoundException {
        if(employeeRepository.findById(emailId).isPresent()){
            EmployeeDetails result=employeeRepository.findById(emailId).get();
            if(result.getPassword().equals(password)){
                result.setPassword("");
                return result;
            }
            throw new EmployeeNotFoundException();
        }

        throw new EmployeeNotFoundException();
    }

}
