package employeeApplication;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl() {};
        try {
            // Insert a new employee
           //Employee empobj = new Employee(4, "mayur", 25, "tester", 30000);
            //employeeDao.addEmployee(empobj);

            // Update an existing employee
           //Employee empobj2 = new Employee(5,"radha",22,"developer", 50000);
            //employeeDao.updateEmployee(empobj2);
        	
        	

             //Delete an employee
          // employeeDao.deleteEmployee(3);

            // Read an employee by ID
          // Employee emp = employeeDao.readEmployee(4);
           //if (emp != null) {
               //System.out.println(emp.toString());
         //  }

            //Get all employees
          List<Employee> employees = employeeDao.getAllEmployee();
           for (Employee empObj : employees) {
              System.out.println(empObj.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
