package FrancescoPaci.wellDtest;

import FrancescoPaci.wellDtest.controller.LineController;
import FrancescoPaci.wellDtest.model.Line;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class WellDtestApplicationTests {

	@Autowired
	LineController lineController;

	@Test
	void getLines() {
		List<Line> lines =  lineController.getLines();
		Assert.isTrue(lines.size() > 0, "OK");
	}

}
