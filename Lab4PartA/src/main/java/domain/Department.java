package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    //mappedBy attribute tells Spring Boot to use the department property in the 'Student' class to map the relationship
    @OneToMany(mappedBy = "department", fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Employee> employeeList = new ArrayList<Employee>();

    protected Department(){}

    public Department(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
