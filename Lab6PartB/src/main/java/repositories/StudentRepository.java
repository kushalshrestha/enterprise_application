package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s.* from student s left join department d on s.department_id=d.id where d.name= :department_name", nativeQuery = true)
    List<Student> findStudentsByDeparment(@Param("department_name") String department_name);

    @Query(value = "select s.student_number, s.name, s.department_id\n" +
            " from student s \n" +
            " inner join grade g \n" +
            " on s.student_number = g.student_id \n" +
            " inner join course c \n" +
            " on g.course_id = c.id\n" +
            "where c.name= :course_name\n" +
            "group by student_number, name, department_id ", nativeQuery = true)
    List<Student> findStudentsByCourse(@Param("course_name") String course_name);
}
