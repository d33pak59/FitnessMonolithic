package com.project.fitnessMonolithic;

import com.project.fitnessMonolithic.model.User;
import com.project.fitnessMonolithic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FitnessMonolithicApplicationTests {

	@Autowired
	private  UserRepository userRepository;




    @Test
	void contextLoads() {
	}

	@Test
	void test() {
		User user=userRepository.findByEmail("Amit@gmail.com").orElse(null);
		System.out.println(user);
	}

}
