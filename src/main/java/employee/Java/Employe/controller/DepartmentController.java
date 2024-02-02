package employee.Java.Employe.controller;

import employee.Java.Employe.DepartmentService;
import employee.Java.Employe.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam("department") int departmentId) {
        return departmentService.getMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam("department") int departmentId) {
        return departmentService.getMinSalaryEmployee(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(@RequestParam("department") int departmentId){
        return departmentService.getEmployeesOfDepartment(departmentId);
    }

    public Map<Integer, List<Employee>> getGroupedAllEmployees() {
        return departmentService.getGroupEmployeesOfDepartment();
    }
}
