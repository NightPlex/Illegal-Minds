package nightplex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nightplex.util.ExperienceHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OtherTest {
	
	@Test
	public void testExperienceHandler() {
		
		assertThat(ExperienceHandler.checkForLevel(153, 1)).isEqualTo(2);
		
	}

}
