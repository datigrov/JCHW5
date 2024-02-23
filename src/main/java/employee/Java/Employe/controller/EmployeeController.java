package employee.Java.Employe.controller;
import employee.Java.Employe.Employee;
import employee.Java.Employe.EmployeeService;
import employee.Java.Employe.Exception.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee (String firstName,String lastName,int department, int salary){
        if (!StringUtils.isAlpha(firstName) && !StringUtils.isAlpha(lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employeeService.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(String firstName, String lastName){
        if (!StringUtils.isAlpha(firstName) && !StringUtils.isAlpha(lastName)) {
            throw new EmployeeNotFoundException();
        }
            return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(String firstName,String lastName){
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("all")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}
