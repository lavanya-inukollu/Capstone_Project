package com.capstoneproject.taskdata.service;

import com.capstoneproject.taskdata.domain.CommonUser;
import com.capstoneproject.taskdata.domain.EmployeeData;
import com.capstoneproject.taskdata.domain.TaskData;
import com.capstoneproject.taskdata.exception.EmployeeAlreadyExistsException;
import com.capstoneproject.taskdata.exception.EmployeeNotFoundException;
import com.capstoneproject.taskdata.proxy.EmployeeProxy;
import com.capstoneproject.taskdata.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    private EmployeeProxy employeeProxy;


//    @Override
//    public EmployeeData addUser(EmployeeData employeeData) throws EmployeeAlreadyExistsException {
//        if(employeeDataRepository.findById(employeeData.getEmployeeName()).isPresent()) {
//            throw new EmployeeAlreadyExistsException();
//        }
//        employeeData.setTaskDataList(new ArrayList<>());
//        return employeeDataRepository.insert(employeeData);
//    }


    @Override
    public EmployeeData addUser(CommonUser commonUser) throws EmployeeAlreadyExistsException {

        ResponseEntity<?> response=employeeProxy.sendEmployeeObjectToAuthApp(commonUser);
        System.out.println(response);

        if(employeeDataRepository.findById(commonUser.getEmployeeName()).isPresent()) {
            throw new EmployeeAlreadyExistsException();
        }
        else {
        EmployeeData employeeData= new EmployeeData(commonUser.getEmployeeName(), commonUser.getEmailId(),commonUser.getRole(),commonUser.getProject(),new ArrayList<>());
            return employeeDataRepository.insert(employeeData);
        }

    }

    @Override
    public EmployeeData addtask(String employeeName,TaskData taskData) throws EmployeeNotFoundException{
        if(employeeDataRepository.findById(employeeName).isPresent()){
          EmployeeData employeeData=  employeeDataRepository.findById(employeeName).get();
          employeeData.getTaskDataList().add(taskData);
          return employeeDataRepository.save(employeeData);

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<TaskData> getTaskByName(String employeeName) throws EmployeeNotFoundException {
        if(employeeDataRepository.findById(employeeName).isPresent()){
        EmployeeData emp =employeeDataRepository.findById(employeeName).get();
        return emp.getTaskDataList();
        }

    throw  new EmployeeNotFoundException();
    }

    @Override
    public boolean deleteTaskByName(String employeeName,TaskData taskData) throws EmployeeNotFoundException{
        if(employeeDataRepository.findById(employeeName).isPresent()){
          EmployeeData employeeData =  employeeDataRepository.findById(employeeName).get();
           employeeData.getTaskDataList().remove(taskData);
            return true;
        }
       throw new EmployeeNotFoundException();
    }

    @Override
    public EmployeeData upateTask(String employeeName, TaskData taskData) throws EmployeeNotFoundException {
        if(employeeDataRepository.findById(employeeName).isPresent()){
           EmployeeData emp = employeeDataRepository.findById(employeeName).get();
           emp.getTaskDataList().add(taskData);
            return employeeDataRepository.save(emp);
        }
        throw new EmployeeNotFoundException();
    }
}
