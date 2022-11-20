package com.capstoneproject.taskdata.service;

import com.capstoneproject.taskdata.domain.CommonUser;
import com.capstoneproject.taskdata.domain.EmployeeData;
import com.capstoneproject.taskdata.domain.Project;
import com.capstoneproject.taskdata.domain.TaskData;
import com.capstoneproject.taskdata.exception.EmployeeAlreadyExistsException;
import com.capstoneproject.taskdata.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeDataService {

    public abstract EmployeeData addUser(CommonUser commonUser) throws EmployeeAlreadyExistsException;
    public abstract EmployeeData addtask(String employeeName,TaskData taskData) throws EmployeeNotFoundException;
    public abstract List<TaskData> getTaskByName(String employeeName) throws EmployeeNotFoundException;
    public abstract boolean deleteTaskByName(String employeeName,TaskData taskData) throws EmployeeNotFoundException;
    public abstract EmployeeData upateTask(String employeeName, TaskData taskData) throws EmployeeNotFoundException;
//    public abstract EmployeeData addProject(String employeeName, Project project) throws EmployeeNotFoundException;
}
