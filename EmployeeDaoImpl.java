package employeeApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void addEmployee(Employee obj) throws SQLException {
        try (Connection con = DatabaseConnection.getCustConnection()) {
            String query = "INSERT INTO employees (employee_name, employee_age, employee_department, employee_salary) VALUES (?, ?, ?, ?)";
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.setString(1, obj.getEmployee_name());
                st.setInt(2, obj.getEmployee_age());
                st.setString(3, obj.getEmployee_department());
                st.setFloat(4, obj.getEmployee_salary());
                
                int i = st.executeUpdate();
                if (i != 0) {
                    System.out.println("Insertion successful");
                } else {
                    System.out.println("Insertion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee obj) throws SQLException {
       
        Employee existingEmployee = readEmployee(obj.getEmployee_id());

        if (existingEmployee != null) {
            
            String query = "UPDATE employees SET employee_name=?, employee_age=?, employee_department=?, employee_salary=? WHERE employee_id=?";
            try (Connection con = DatabaseConnection.getCustConnection(); PreparedStatement st = con.prepareStatement(query)) {
                st.setString(1, obj.getEmployee_name());
                st.setInt(2, obj.getEmployee_age());
                st.setString(3, obj.getEmployee_department());
                st.setFloat(4, obj.getEmployee_salary());
                st.setInt(5, obj.getEmployee_id());
                
                int i = st.executeUpdate();
                if (i > 0) {
                    System.out.println("Update successful");
                } else {
                    System.out.println("Update failed");
                }
            }
        } else {
          
            addEmployee(obj);
        }
    }

    @Override
    public void deleteEmployee(int employee_id) throws SQLException {
        try (Connection con = DatabaseConnection.getCustConnection()) {
            String query = "DELETE FROM employees WHERE employee_id=?";
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.setInt(1, employee_id);
                int n = st.executeUpdate();
                if (n > 0) {
                    System.out.println("Deletion successful");
                } else {
                    System.out.println("Deletion failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee readEmployee(int employee_id) throws SQLException {
        try (Connection con = DatabaseConnection.getCustConnection()) {
            String query = "SELECT * FROM employees WHERE employee_id=?";
            try (PreparedStatement st = con.prepareStatement(query)) {
                st.setInt(1, employee_id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("employee_id");
                    String name = rs.getString("employee_name");
                    int age = rs.getInt("employee_age");
                    String dept = rs.getString("employee_department");
                    float salary = rs.getFloat("employee_salary");

                    return new Employee(id, name, age, dept, salary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> list = new ArrayList<>();
        try (Connection con = DatabaseConnection.getCustConnection()) {
            String query = "SELECT * FROM employees";
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("employee_id");
                    String name = rs.getString("employee_name");
                    int age = rs.getInt("employee_age");
                    String dept = rs.getString("employee_department");
                    float salary = rs.getFloat("employee_salary");

                    list.add(new Employee(id, name, age, dept, salary));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}