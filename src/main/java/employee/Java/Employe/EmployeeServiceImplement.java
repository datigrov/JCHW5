package employee.Java.Employe;

import employee.Java.Employe.Exception.EmployeeAlreadyAddedException;
import employee.Java.Employe.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Джонни", "Депп"),
            new Employee("Сальма", "Хайек"),
            new Employee("Дмитрий", "Харатьян"),
            new Employee("Александр", "Шепс"),
            new Employee("Бред", "Питт")
    ));

    private final int EMPLOYEES_SIZE = 100;

    @Override
    public Employee add(String firstName, String lastName)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= EMPLOYEES_SIZE) {
            throw new EmployeeStorageIsFullException("Свободных мест нет");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Запрашиваемого сотрудника нет");
    }

    @Override
    public Employee find(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException("Запрашиваемого сотрудника нет");
    }



    @Override
    public List<Employee> getAll() {
        return employees;
    }


}
