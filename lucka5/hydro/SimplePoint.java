package hydro;

import java.util.List;
import java.util.Objects;

public class SimplePoint {
    private int x;
    private int y;

    public SimplePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void createYLineTo(SimplePoint other, List<SimplePoint> allPoints) {
        if (this.y < other.y) {
            createPointsY(this, other, allPoints);
        }
        else {
            createPointsY(other, this, allPoints);
        }
    }

    private void createPointsY(SimplePoint small, SimplePoint big, List<SimplePoint> allPoints) {
        int between = small.y;

        while (between <= big.y) {
            allPoints.add(new SimplePoint(small.x, between));
            between++;
        }
    }

    public void createXLineTo(SimplePoint other, List<SimplePoint> allPoints) {
        if (this.x < other.x) {
            createPointsX(this, other, allPoints);
        }
        else {
            createPointsX(other, this, allPoints);
        }
    }

    private void createPointsX(SimplePoint small, SimplePoint big, List<SimplePoint> allPoints) {
        int between = small.x;

        while (between <= big.x) {
            allPoints.add(new SimplePoint(between, small.y));
            between++;
        }
    }

    public void createDiagonalTo(SimplePoint other, List<SimplePoint> allPoints) {
        if (this.x < other.x) {
            createPointsDiagonal(this, other, allPoints);
        }
        else {
            createPointsDiagonal(other, this, allPoints);
        }
    }

    private void createPointsDiagonal(SimplePoint left, SimplePoint right, List<SimplePoint> allPoints) {
        int x = left.x;
        int y = left.y;
        if (left.y < right.y) {         //snett nedåt, y och x ÖKAR
            while (x <= right.x) {
                allPoints.add(new SimplePoint(x, y));
                x++;
                y++;
            }
        }
        else {                          //snett uppåt, y MINSKAR, x ÖKAR
            while (x <= right.x) {
                allPoints.add(new SimplePoint(x, y));
                x++;
                y--;
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePoint that = (SimplePoint) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
