package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @MapKey(name="studentid") // This mapkey should match the name of the property in Student class. Case-Sensitive!!!
    private Map<Long,Student> student = new HashMap<>();


    protected School(){}

    public School(String name) {
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

    public Map<Long, Student> getStudent() {
        return student;
    }

    public void setStudent(Map<Long, Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
