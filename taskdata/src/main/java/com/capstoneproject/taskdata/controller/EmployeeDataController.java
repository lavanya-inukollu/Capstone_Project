package com.capstoneproject.taskdata.controller;

import com.capstoneproject.taskdata.domain.CommonUser;
import com.capstoneproject.taskdata.domain.EmployeeData;
import com.capstoneproject.taskdata.domain.TaskData;
import com.capstoneproject.taskdata.exception.EmployeeAlreadyExistsException;
import com.capstoneproject.taskdata.exception.EmployeeNotFoundException;
import com.capstoneproject.taskdata.service.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-details/v1")
public class EmployeeDataController {
    @Autowired
    private EmployeeDataService employeeDataService;

//    http://localhost:9999/employee-details/v1/add-user
    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody CommonUser commonUser) throws EmployeeAlreadyExistsException{
        try{
            return new ResponseEntity<>(employeeDataService.addUser(commonUser),HttpStatus.OK);
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsException();
        }
    }

//    http://localhost:9999/employee-details/v1/add-task
    @PostMapping("/add-task/{employeeName}")

    public ResponseEntity<?> addtask(@PathVariable String employeeName, @RequestBody TaskData taskData) throws EmployeeNotFoundException {
        try{
           EmployeeData e= employeeDataService.addtask(employeeName,taskData);
           return new ResponseEntity<>(e, HttpStatus.OK);
        } catch (EmployeeNotFoundException ex) {
            throw new EmployeeNotFoundException();
        }

    }
//    http://localhost:9999/employee-details/v1/task-name
    @GetMapping("/task-name/{employeeName}")
    public ResponseEntity<?> getTaskByName(@PathVariable String employeeName) throws EmployeeNotFoundException{
        try{
            return new ResponseEntity<>( employeeDataService.getTaskByName(employeeName),HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }

    }

//    http://localhost:9999/employee-details/v1/delete-task-by-name/Kavya
    @DeleteMapping("/delete-task-by-name/{employeeName}")
    public ResponseEntity<?> deleteTaskByName(@PathVariable String employeeName,@RequestBody TaskData taskData) throws EmployeeNotFoundException{
        try{
            employeeDataService.deleteTaskByName(employeeName,taskData);
            return new ResponseEntity<>("task deleted suucesfully",HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }

//    http://localhost:9999/employee-details/v1/update-task/seetha
    @PutMapping("/update-task/{employeeName}")
    public ResponseEntity<?> updateTaskByName(@PathVariable String employeeName,@RequestBody TaskData taskData) throws EmployeeNotFoundException {
        try{
           EmployeeData update = employeeDataService.upateTask(employeeName,taskData);
           return new ResponseEntity<>(update,HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }
}
