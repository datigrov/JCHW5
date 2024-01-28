package employee.Java.Employe;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalaryEmployee(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() ==departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() ==departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployeesOfDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getGroupEmployeesOfDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
