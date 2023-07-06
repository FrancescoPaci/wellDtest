package FrancescoPaci.wellDtest.controller;

import FrancescoPaci.wellDtest.model.FakeDb;
import FrancescoPaci.wellDtest.model.Line;
import FrancescoPaci.wellDtest.model.Point;
import FrancescoPaci.wellDtest.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    @Autowired
    private PointService pointService;

    @Autowired
    private FakeDb fakeDb;

    @GetMapping("/getLines")
    public List<Line> getLines() {

        List<Point> points = fakeDb.getPoints();

        List<Line> lines = new ArrayList<>();
        List<BigDecimal> slopes = new ArrayList<>(Arrays.asList(BigDecimal.ZERO));

        for(int i = 0; i < points.size(); i++) {
            Point point1 = points.get(i);

            for(int j = i+1; j < points.size(); j++) {
                Point point2 = points.get(j);
                BigDecimal slope = pointService.getSlope(point1, point2);

                if(slopes.contains(slope)) {
                    continue;
                }
                slopes.add(slope);
                List<Point> linePoints = new ArrayList<>();
                linePoints.add(point1);
                linePoints.add(point2);
                Line line = new Line();

                for(int w = i+1; w < points.size(); w++) {
                    if(w != j) {
                        Point point3 = points.get(w);
                        BigDecimal slope2 = pointService.getSlope(point1, point3);
                        if(slope.compareTo(slope2) == 0) {
                            linePoints.add(point3);
                        }
                    }
                }
                line.setPoints(linePoints);
                lines.add(line);
            }
        }
        return lines;
    }

}