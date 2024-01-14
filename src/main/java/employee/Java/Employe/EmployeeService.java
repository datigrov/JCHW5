package employee.Java.Employe;

import employee.Java.Employe.Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EmployeeService {

    static String addEmployee(String firstName, String lastName) {
        return firstName;
    }

    static String removeEmployee(String firstName, String lastName) {
        return firstName;
    }

    static String findEmployee(String firstName, String lastName) {
        return firstName;
    }

    Employee add(String name, String lastName)
            throws EmployeeNotFoundException, EmployeeAlreadyAddedException;

    Employee remove (String name, String lastName)
            throws EmployeeNotFoundException;

    Employee find (String name, String lastName)
            throws EmployeeNotFoundException;



    List<Employee> getAll();

}
