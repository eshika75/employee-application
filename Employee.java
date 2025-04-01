package employeeApplication;

public class Employee {
	private int employee_id;
    String employee_name;
    int employee_age;
    String employee_department;
    float employee_salary;

    public Employee() {
    }

    public Employee(int employee_id, String employee_name, int employee_age, String employee_department, float employee_salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_age = employee_age;
        this.employee_department = employee_department;
        this.employee_salary = employee_salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getEmployee_department() {
        return employee_department;
    }

    public void setEmployee_department(String employee_department) {
        this.employee_department = employee_department;
    }

    public float getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(float employee_salary) {
        this.employee_salary = employee_salary;
    }

    @Override
    public String toString() {
        return "employee [employee_id=" + employee_id + ", employee_name=" + employee_name
                + ", employee_age=" + employee_age + ", employee_department=" + employee_department
                + ", employee_salary=" + employee_salary + "]";
    }
}



