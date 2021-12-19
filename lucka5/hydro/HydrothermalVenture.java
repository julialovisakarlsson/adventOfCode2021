package hydro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HydrothermalVenture {
    List<SimplePoint> allPoints;
    Set<SimplePoint> distinct;
    Map<SimplePoint, Integer> counts;

    public HydrothermalVenture() throws IOException {
        allPoints = new ArrayList<>();
        readInput();
        calculate();

        int count = 0;
        for (SimplePoint point : distinct) {
            if (counts.get(point) > 1) count++;
        }
        System.out.println(count);
    }


    public void readInput() throws IOException {
        String line;
        SimplePoint startPoint;
        SimplePoint endPoint;
        BufferedReader br = new BufferedReader(new FileReader("lucka5/input.txt"));

        while ((line = br.readLine()) != null) {

            String[] points = line.split(" -> ");
            int x1 = Integer.parseInt(points[0].split(",")[0]);
            int y1 = Integer.parseInt(points[0].split(",")[1]);

            int x2 = Integer.parseInt(points[1].split(",")[0]);
            int y2 = Integer.parseInt(points[1].split(",")[1]);

            startPoint = new SimplePoint(x1, y1);
            endPoint = new SimplePoint(x2, y2);

            addPointsBetween(startPoint, endPoint);
        }
    }

    private void addPointsBetween(SimplePoint start, SimplePoint end) {
        if (start.getY() == end.getY()) {
            start.createXLineTo(end, allPoints);
        }

        else if (start.getX() == end.getX()) {
            start.createYLineTo(end, allPoints);
        }

        else {
            start.createDiagonalTo(end, allPoints);
        }
    }

    public void calculate() {
        distinct = new HashSet<>();
        distinct.addAll(allPoints);
        counts = new HashMap<>();
        int count;

        for (SimplePoint point : distinct) {
            count = 0;
            for (SimplePoint loop : allPoints) {
                if (loop.equals(point)) {
                    count++;
                }
            }
            counts.put(point, count);
        }
    }


    public static void main(String[] args) throws IOException {
        new HydrothermalVenture();
    }
}
