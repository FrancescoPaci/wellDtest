package FrancescoPaci.wellDtest.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeDb {

    private final Point point1 = new Point(new BigDecimal("3"), new BigDecimal("9"));
    private final Point point2 = new Point(new BigDecimal("-2"), new BigDecimal("-16"));
    private final Point point3 = new Point(new BigDecimal("0.2"), new BigDecimal("-5"));
    private final Point point4 = new Point(new BigDecimal("31"), new BigDecimal("34"));
    private final Point point5 = new Point(new BigDecimal("12"), new BigDecimal("11"));

    private List<Point>  points = new ArrayList<>(Arrays.asList(point1, point2, point3, point4, point5));

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

}
