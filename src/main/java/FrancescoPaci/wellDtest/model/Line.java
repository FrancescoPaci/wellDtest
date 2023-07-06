package FrancescoPaci.wellDtest.model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Point> points = new ArrayList<>();

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
