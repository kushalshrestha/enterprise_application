package domain;

import javax.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private int id;
    private String grade;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Course course;

    protected Grade(){}

    public Grade(String grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", course=" + course +
                '}';
    }
}