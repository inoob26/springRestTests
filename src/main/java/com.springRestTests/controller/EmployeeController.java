package com.springRestTests.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @RequestMapping("/employeeAll")
    public String getAllEmployers(){
        return new DBController().getAllEmployee();
    }

    @RequestMapping("/employee")
    public String getEmployerById(@RequestParam(value = "id",defaultValue = "1") String id) {
        return new DBController().getEmployeeById(id);
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(@RequestParam("name") String name,@RequestParam("position") String position){
        if (name != "" && name != null){
            if (position != "" && position != null){
                return new DBController().addEmployeer(name,position);
            } else {
                return "position param is empty";
            }
        } else {
            return "name param is empty";
        }
    }

    @RequestMapping("/editEmployee")
    public String editEmployeeById(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("position") String position){
        if (!id.isEmpty()){
            if (!name.isEmpty()){
                if (!position.isEmpty()){
                    return new DBController().updateEmployeerById(id,name,position);
                } else {
                    return "position param is empty";
                }
            } else {
                return "name param is empty";
            }
        }else {
            return "id param is empty";
        }
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") String id){
        if(id != "" && id != null){
            return new DBController().deleteEmployeer(id);
        }else {
            return "success";
        }
    }
}