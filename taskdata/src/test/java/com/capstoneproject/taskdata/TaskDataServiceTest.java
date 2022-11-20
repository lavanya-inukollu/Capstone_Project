//package com.capstoneproject.taskdata;
//
//import com.capstoneproject.taskdata.domain.CommonUser;
//import com.capstoneproject.taskdata.domain.EmployeeData;
//import com.capstoneproject.taskdata.domain.TaskData;
//import com.capstoneproject.taskdata.exception.EmployeeAlreadyExistsException;
//import com.capstoneproject.taskdata.exception.EmployeeNotFoundException;
//import com.capstoneproject.taskdata.proxy.EmployeeProxy;
//import com.capstoneproject.taskdata.repository.EmployeeDataRepository;
//import com.capstoneproject.taskdata.service.EmployeeDataServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskDataServiceTest {
//
//    @Mock
//    private EmployeeProxy employeeProxy;
//@Mock
//    private EmployeeDataRepository employeeDataRepository;
//
//  @InjectMocks
//    private EmployeeDataServiceImpl employeeDataServiceIml;
//
//  private TaskData taskData;
//  private EmployeeData employeeData;
//  private CommonUser commonUser;
//
//  @BeforeEach
//    public void init(){
//      taskData =new TaskData("9-10-1997","Artificial Intelligence","to-do","sathya","artifical intelligence and machine learning","high");
//      employeeData =new EmployeeData("sathya","sathya@gmail.com","backend",new ArrayList<>());
//      commonUser=new CommonUser("sathya","backend","sathya@gmail.com","abc");
//  }
//  @AfterEach
//    public void clear(){
//      employeeData=null;
//      taskData=null;
//  }
//
//  @Test
//    public void addUserSuccess() throws EmployeeNotFoundException, EmployeeAlreadyExistsException {
//
//      when(employeeDataRepository.findById(employeeData.getEmployeeName())).thenReturn(Optional.ofNullable(null));
//      when(employeeDataRepository.insert(employeeData)).thenReturn(employeeData);
//        assertEquals(employeeData,employeeDataServiceIml.addUser(commonUser));
//
//        verify(employeeDataRepository,times(1)).findById(employeeData.getEmployeeName());
//        verify(employeeDataRepository,times(1)).insert(employeeData);
//  }
//
//  @Test
//  public void addUserFailure() {
//
//    when(employeeDataRepository.findById(employeeData.getEmployeeName())).thenReturn(Optional.ofNullable(employeeData));
//    assertThrows(EmployeeAlreadyExistsException.class, ()->employeeDataServiceIml.addUser(commonUser));
//    verify(employeeDataRepository,times(1)).findById(employeeData.getEmployeeName());
//    verify(employeeDataRepository,times(0)).insert(employeeData);
//
////  }
////  @Test
////  public void deleteTaskByNameSuccess() throws EmployeeNotFoundException {
////
////    employeeData.getTaskDataList().add(taskData);
////
////    when(employeeDataRepository.findById(employeeData.getEmployeeName())).thenReturn(Optional.ofNullable(employeeData));
//////    when(employeeData.getTaskDataList().remove(taskData)).thenReturn(true);
////    assertEquals(true,employeeDataServiceIml.deleteTaskByName(employeeData.getEmployeeName(),taskData));
////    verify(employeeDataRepository,times(2)).findById(employeeData.getEmployeeName());
////
////  }
//
////  @Test
////  public void deleteTaskByNameFail(){
////
////    employeeData.getTaskDataList().add(taskData);
////    when(employeeDataRepository.findById(employeeData.getEmployeeName())).thenReturn(Optional.ofNullable(null));
////    assertThrows(EmployeeNotFoundException.class,()->employeeDataServiceIml.deleteTaskByName(employeeData.getEmployeeName(),taskData));
////  }
////
////}
