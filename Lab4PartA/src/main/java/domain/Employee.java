package domain;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int employeenumber;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
    private Department department;

    protected Employee(){}

    public Employee(String name)
    {
        this.name = name;
    }

    public int getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(int employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeenumber=" + employeenumber +
                ", name='" + name + '\'' +
                '}';
    }
}
