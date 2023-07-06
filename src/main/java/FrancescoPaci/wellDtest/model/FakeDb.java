package FrancescoPaci.wellDtest.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeDb {

    private final Point point1 = new Point(new BigDecimal("3"), new BigDecimal("9"));
    private final Point point2 = new Point(new BigDecimal("-2"), new BigDecimal("-16"));
    private final Point point3 = new Point(new BigDecimal("0.2"), new BigDecimal("-5"));
    private final Point point4 = new Point(new BigDecimal("31"), new BigDecimal("34"));
    private final Point point5 = new Point(new BigDecimal("3"), new BigDecimal("11"));
    private final Point point6 = new Point(new BigDecimal("3"), new BigDecimal("13"));

    private List<Point>  points = new ArrayList<>();

    @PostConstruct
    private void initPoints() {
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);
        points.add(point6);
    }

    public void reinitPoints() {
        points = new ArrayList<>();
        initPoints();
    }

    public void removePoints() {
        points = new ArrayList<>();
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

}
