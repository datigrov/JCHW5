package employee.Java.Employe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove (String firstName, String lastName);

    Employee find (String firstName, String lastName);

    Collection<Employee> findAll();
}
