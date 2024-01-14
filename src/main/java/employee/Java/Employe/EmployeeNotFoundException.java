package employee.Java.Employe;


public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String s) {
        super("Сотрудник не найден");
    }
}
