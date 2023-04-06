package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department department1 = new Department("Mathmetics");

		List<Grade> gradeList1 = new ArrayList<>();
		gradeList1.add(new Grade("A+", new Course ("Discrete Mathematics")));
		gradeList1.add(new Grade("A-", new Course("Theory of Computation")));

		Student student1 = new Student("Michael Faraday" , department1, gradeList1);
		studentRepository.save(student1);


		Department department2 = new Department("Literature");

		List<Grade> gradeList2 = new ArrayList<>();
		gradeList1.add(new Grade("B+", new Course ("English Literature")));
		gradeList1.add(new Grade("A+", new Course("Sanskrit")));

		Student student2 = new Student("Kushal Shrestha" , department2, gradeList2);
		studentRepository.save(student2);


		//read
		System.out.println("=========OUTPUT=========");
		List<Student> studentListForDepartment = studentRepository.findStudentsByDeparment("Literature");
		studentListForDepartment.stream().forEach(student -> System.out.println(student));


		List<Student> studentListForCourse = studentRepository.findStudentsByCourse("Theory of Computation");
		studentListForCourse.stream().forEach(student -> System.out.println(student));

	}


}
