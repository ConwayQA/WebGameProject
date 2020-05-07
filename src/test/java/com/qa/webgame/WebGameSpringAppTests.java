package com.qa.webgame;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebGameSpringAppTests {

	@Test
	public void shouldAnswerWithTrue(){
		WebGameSpringApp app = new WebGameSpringApp();
		String[] args = null;
		WebGameSpringApp.main(args);
		assertTrue(app instanceof WebGameSpringApp);
	}

}
