package com.aureus;

import com.aureus.support.TestcontainerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestcontainerConfiguration.class)
class AureusApplicationTests {

	@Test
	void contextLoads() {
	}

}
