package customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {


    List<Student> findByName(@Param("name") String name);


    List<Student> findByPhoneNumber(@Param("phoneNumber") long phoneNumber);

    @Query("{'address.city' : :#{#city}}")
    List<Student> findStudentWithCity(@Param("city") String city);

    @Query("{'grade.courseName' : :#{#course}}")
    List<Student> findStudentWithCourse(@Param("course") String course);

    @Query("{'grade.grade' : :#{#grade}}")
    List<Student> findStudentWithAPlus(@Param("grade") String grade);


}
