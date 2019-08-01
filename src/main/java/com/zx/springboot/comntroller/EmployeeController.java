package com.zx.springboot.comntroller;

import com.zx.springboot.dao.DepartmentDao;
import com.zx.springboot.dao.EmployeeDao;
import com.zx.springboot.entities.Department;
import com.zx.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域
        model.addAttribute("emps", employees);
        System.out.println(employees.toString());
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    //Spring集成，保证提交的name和bean相同
    public String addEmp(Employee employee) {
        //来到员工列表页面
        System.out.println("11111111111111111111         "+employee.toString());
        employeeDao.save(employee);
        Date date  = employee.getBirth();
        System.out.println(date);
        //redirect：重定向
        //forward转发
        return "redirect:emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
       Employee employee =  employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        model.addAttribute("emp",employee);
        return "emp/add";

    }
    @PutMapping("/emp")
    public  String updateEmployee (Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";

    }
}
