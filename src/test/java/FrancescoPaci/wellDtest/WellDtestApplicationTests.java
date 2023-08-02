package FrancescoPaci.wellDtest;

import FrancescoPaci.wellDtest.controller.LineController;
import FrancescoPaci.wellDtest.model.Line;
import FrancescoPaci.wellDtest.model.MockedData;
import FrancescoPaci.wellDtest.model.Point;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class WellDtestApplicationTests {

	@Autowired
	private LineController lineController;
	@Autowired
	private MockedData mockedData;

	@Test
	void getLines() {
		List<Line> lines =  lineController.getLines();
		Assert.isTrue(lines.size() > 0, "OK");
	}

	@Test
	void addPoint() {
		List<Point> points = mockedData.getPoints();
		int pointsBefore = points.size();
		Point point = new Point(BigDecimal.ONE,BigDecimal.TEN);
		lineController.addPoint(point);
		List<Point> pointsAfter = mockedData.getPoints();
		Assert.isTrue(pointsBefore < pointsAfter.size(), "OK");
	}

	@Test
	void getAllPoints() {
		List<Point> points = lineController.getAllPoints();
		Assert.isTrue(points.size() > 0, "OK");
	}

	@Test
	void removePoints() {
		List<Point> points = mockedData.getPoints();
		int pointsBefore = points.size();
		lineController.removePoints();
		List<Point> pointsAfter = mockedData.getPoints();
		Assert.isTrue(pointsBefore > pointsAfter.size() && pointsAfter.size() == 0, "OK");
	}

	@Test
	void reinitPoints() {
		lineController.removePoints();
		List<Point> points = mockedData.getPoints();
		int pointsBefore = points.size();
		lineController.reinitPoints();
		List<Point> pointsAfter = mockedData.getPoints();
		Assert.isTrue(pointsBefore == 0 && pointsAfter.size() > pointsBefore, "OK");
	}

	@Test
	void getLinesWithXPoints() {
		List<Line> lines = lineController.getLinesWithXPoints(3);
		Assert.isTrue(lines.size() > 0, "OK");
	}

}
