//package com.capstoneproject.taskdata;
//
//import com.capstoneproject.taskdata.controller.EmployeeDataController;
//import com.capstoneproject.taskdata.domain.CommonUser;
//import com.capstoneproject.taskdata.domain.EmployeeData;
//import com.capstoneproject.taskdata.domain.TaskData;
//import com.capstoneproject.taskdata.exception.EmployeeAlreadyExistsException;
//import com.capstoneproject.taskdata.service.EmployeeDataService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class TaskDataControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private EmployeeDataService employeeDataService;
//
//    @InjectMocks
//    private EmployeeDataController employeeDataController;
//
//    private TaskData taskData;
//    private EmployeeData employeeData;
//    private CommonUser commonUser;
//
//
//    @BeforeEach
//    public void init(){
//        taskData=new TaskData("10-9-1998","MySql","pending","priya","Mysql is a database","high");
//        employeeData=new EmployeeData("priya","priya@gmail.com","frontend",new ArrayList<>());
//        commonUser=new CommonUser("priya","backend","priya@gmail.com","abc");
//        mockMvc= MockMvcBuilders.standaloneSetup(employeeDataController).build();
//    }
//    @AfterEach
//    public void clear(){
//        employeeData=null;
//        taskData=null;
//        commonUser=null;
//    }
//
//    private static String convertToJson(final Object obj){
//        String result="";
//        try{
//            ObjectMapper mapper =new ObjectMapper();
//            result =mapper.writeValueAsString(obj);
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    @Test
//    public void addUserSuccess() throws Exception {
//        when(employeeDataService.addUser(commonUser)).thenReturn(employeeData);
//
//        mockMvc.perform( post("/employee-details/v1/add-user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(convertToJson(commonUser)))
//                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(employeeDataService,times(1)).addUser(commonUser);
//
//    }
//    @Test
//    public void addUserFail() throws Exception {
//        when(employeeDataService.addUser(commonUser)).thenThrow(EmployeeAlreadyExistsException.class);
//
//        mockMvc.perform(post("/employee-details/v1/add-user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(convertToJson(commonUser)))
//                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//        verify(employeeDataService,times(1)).addUser(commonUser);
//    }
//
//
//}
