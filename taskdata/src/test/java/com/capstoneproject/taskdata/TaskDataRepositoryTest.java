package com.capstoneproject.taskdata;

import com.capstoneproject.taskdata.domain.CommonUser;
import com.capstoneproject.taskdata.domain.EmployeeData;
import com.capstoneproject.taskdata.domain.TaskData;
import com.capstoneproject.taskdata.repository.EmployeeDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TaskDataRepositoryTest {

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    private TaskData taskData;

    private EmployeeData employeeData;

    private CommonUser commonUser;

    @BeforeEach
    public void setUp(){
        taskData =new TaskData("12-2-2011","Algorithms","completed","prathyush","algorithms are important","high");
        employeeData=new EmployeeData("prathyush","prathyu@gmail.com","backend",new ArrayList<>());
        commonUser =new CommonUser("prathyush","backend","prathyu@gmail.com","abc");
    }
    @AfterEach
    public void clean(){
        taskData=null;
        employeeData=null;
        employeeDataRepository.deleteById("prathyush");
    }

    @Test
    public void addUser(){
        employeeDataRepository.insert(employeeData);
        List<EmployeeData> employeeDataList=employeeDataRepository.findAll();
        assertEquals(6,employeeDataList.size());


    }

    @Test
    public void getTaskByName(){
        employeeDataRepository.insert(employeeData);
        employeeData.getTaskDataList().add(taskData);
        employeeDataRepository.save(employeeData);
        EmployeeData emp = employeeDataRepository.findById(employeeData.getEmployeeName()).get();
        assertEquals(1,emp.getTaskDataList().size());
    }

    @Test
    public void deleteTaskByName(){
        employeeDataRepository.insert(employeeData);
        employeeData.getTaskDataList().add(taskData);
        employeeDataRepository.save(employeeData);
      EmployeeData employeeData1=  employeeDataRepository.findById(employeeData.getEmployeeName()).get();
        employeeData1.getTaskDataList().remove(taskData);
        assertEquals(0,employeeData1.getTaskDataList().size());


    }

}
