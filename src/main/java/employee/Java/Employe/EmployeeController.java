package employee.Java.Employe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService() {
        @Override
        public Employee add(String name, String lastName) throws EmployeeNotFoundException {
            return null;
        }
        @Override
        public Employee remove(String name, String lastName) throws EmployeeNotFoundException {
            return null;
        }
        @Override
        public Employee find(String name, String lastName) throws EmployeeNotFoundException {
            return null;
        }
        @Override
        public List<Employee> getAll() {
            return null;
        }
    };

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return EmployeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return EmployeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName){
        return EmployeeService.findEmployee(firstName, lastName);
    }


}
