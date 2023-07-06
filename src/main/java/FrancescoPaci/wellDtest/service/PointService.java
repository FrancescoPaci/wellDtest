package FrancescoPaci.wellDtest.service;

import FrancescoPaci.wellDtest.model.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PointService {

    public BigDecimal getSlope(Point point1, Point point2) {
        BigDecimal x = point1.getX().subtract(point2.getX());
        BigDecimal y = point1.getY().subtract(point2.getY());
        BigDecimal slope;
        if(y.compareTo(BigDecimal.ZERO) != 0){
            slope =  x.divide(y,2, RoundingMode.HALF_UP);
        } else if(x.compareTo(BigDecimal.ZERO) != 0) {
            slope = y.divide(x,2, RoundingMode.HALF_UP);
        } else {
            slope = BigDecimal.ZERO;
        }
        return slope;
    }
}
