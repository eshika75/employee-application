package employeeApplication;


import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void addEmployee(Employee obj) throws SQLException; 

    void updateEmployee(Employee obj) throws SQLException;

    void deleteEmployee(int employee_id) throws SQLException; 

    Employee readEmployee(int employee_id) throws SQLException; 

    List<Employee> getAllEmployee() throws SQLException;
}
