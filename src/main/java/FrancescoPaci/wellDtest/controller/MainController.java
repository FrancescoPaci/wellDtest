package FrancescoPaci.wellDtest.controller;

import FrancescoPaci.wellDtest.model.FakeDb;
import FrancescoPaci.wellDtest.model.Line;
import FrancescoPaci.wellDtest.model.Point;
import FrancescoPaci.wellDtest.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController implements BasicController {

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

    @PostMapping("/addPoint")
    public void addPoint(@RequestBody Point point) {
        fakeDb.getPoints().add(point);
    }

    @GetMapping("/getAllPoints")
    public List<Point> getAllPoints() {
        return fakeDb.getPoints();
    }

    @DeleteMapping("/removePoints")
    public void removePoints() {
        fakeDb.removePoints();
    }

    @GetMapping("/reinitPoints")
    public void reinitPoints() {
        fakeDb.reinitPoints();
    }

    @GetMapping("/getLinesWithXPoints/{pointsNumber}")
    public List<Line> getLinesWithXPoints(@PathVariable Integer pointsNumber) {
        return getLines().stream()
                .filter(line -> line.getPoints().size() == pointsNumber)
                .collect(Collectors.toList());
    }

}
