package app;

import domain.Person;
import domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;
import repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	

	@Autowired
	PersonRepository personRepository;

	long insertTotaltime;
	long readTotaltime;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addPersons();
		readPersons();
		System.out.println("Insert total time : " +  insertTotaltime + "(ms)");
		System.out.println("Read total time : " +  readTotaltime + "(ms)");




	}

	public void addPersons(){
		StopWatch sw = new StopWatch();
		sw.start();
		for (int x=0; x< 10000; x++) {
			List<Pet> petList = new ArrayList<>();
			for(int y=0; y<10; y++){
				Pet p = new Pet("Pet" + y);
				petList.add(p);
			}
			Person p = new Person("Person - " + x, petList);
			personRepository.save(p);
		}

		sw.stop();
		 insertTotaltime=sw.getTotalTimeMillis();
		System.out.println("Time taken to insert all persons "+insertTotaltime+" ms");

	}

	private void readPersons() {
		StopWatch sw = new StopWatch();
		sw.start();

		List<Person> personList = personRepository.findAll();
		personList.stream().forEach(p-> System.out.println(p));
		sw.stop();
		readTotaltime=sw.getTotalTimeMillis();
		System.out.println("Time taken to retrieve all persons "+readTotaltime+" ms");
	}

}

