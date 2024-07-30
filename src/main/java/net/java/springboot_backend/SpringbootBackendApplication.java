package net.java.springboot_backend;

import net.java.springboot_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner { //implements this to insert info through main
																		 //	code

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private net.java.springboot_backend.repository.userRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user_info=new User();
		user_info.setFirstname("puteri");
		user_info.setLastname("ibrahim");
		user_info.setEmail("puteri@gmail.com");
		//save info into database
		userRepository.save(user_info);

		User user_info1=new User();
		user_info1.setFirstname("zami");
		user_info1.setLastname("jaa");
		user_info1.setEmail("zamy@gmail.com");
		userRepository.save(user_info1);
	}
}
