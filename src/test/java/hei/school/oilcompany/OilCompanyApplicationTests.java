package hei.school.oilcompany;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OilCompanyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testSum(){
		int result =  1 + 1;
		assertEquals(2, result, "Sum of 1 + 1 should be 2");
	}

}
