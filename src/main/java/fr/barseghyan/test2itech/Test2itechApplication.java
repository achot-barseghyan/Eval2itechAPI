package fr.barseghyan.test2itech;

import fr.barseghyan.test2itech.Entity.Commercial;
import fr.barseghyan.test2itech.Entity.User;
import fr.barseghyan.test2itech.Repository.CommercialRepository;
import fr.barseghyan.test2itech.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class Test2itechApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test2itechApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappLineRunner(CommercialRepository commercialRepository, UserRepository userRepository) {
		return args -> {
			Commercial Pignon = new Commercial(
					"François Pignon",
					"francois.pignon@dinner.com",
					"0123456789"
			);
			Commercial Leblanc = new Commercial(
					"Juste Leblanc",
					"juste.leblanc@dinner.com",
					"987654312"
			);
			Commercial Sassoeur = new Commercial(
					"Marlène Sassoeur",
					"marlene.sassoeur@dinner.con",
					"346789654"
			);

			commercialRepository.saveAll(Arrays.asList(Pignon, Leblanc, Sassoeur));


			User Achot = new User(
					"Achot Barseghyan",
					"achot@gmail.com",
					"123"
			);

			userRepository.save(Achot);
		};
	}

}
