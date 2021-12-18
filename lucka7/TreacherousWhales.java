import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreacherousWhales {
    List<Integer> positions;
    List<Long> distances;
    String[] numbers;
    Long shortestDist;
    Long foundDist;

    public TreacherousWhales() throws IOException {
        shortestDist = 99999999999999L;
        readInput();
        calculatePt1();
        shortestDist = 99999999999999L;
        calculatePt2();
    }

    private void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lucka7/input.txt"));
        String line = br.readLine();
        numbers = line.split(",");
        positions = new ArrayList<>();

        for (String number : numbers) {
            positions.add(Integer.parseInt(number));
        }
    }

    public void calculatePt1() {                   //kolla varje plats som finns mellan 0 och högsta pos, kolla avstånd för alla, spara summa, jämför och spara lägsta varje gång.

        int highest = (int) positions.stream().sorted().toArray()[positions.size()-1];

        for (int pos = 0; pos <= highest; pos++) {
            distances = new ArrayList<>();
            for (Integer i : positions) {
                distances.add((long) Math.abs(i - pos));
            }
            foundDist = distances.stream().mapToLong(Long::intValue).sum();
            if (foundDist < shortestDist) shortestDist = foundDist;
        }

        System.out.println("Del 1 - kortaste avstånd: " + shortestDist);
    }

    public void calculatePt2() {                   //kolla varje plats som finns mellan 0 och högsta pos, kolla avstånd för alla, spara summa, jämför och spara lägsta varje gång.

        int highest = (int) positions.stream().sorted().toArray()[positions.size()-1];


        for (int pos = 0; pos <= highest; pos++) {
            distances = new ArrayList<>();
            long extraFuel;
            for (Integer i : positions) {
                extraFuel = 0;
                for (int a = 0; a < Math.abs(i - pos); a++) {
                    extraFuel += a;
                }

                distances.add(Math.abs(i - pos) + extraFuel);
            }
            foundDist = distances.stream().mapToLong(Long::intValue).sum();
            if (foundDist < shortestDist) shortestDist = foundDist;
        }

        System.out.println("Del 2 - kortaste avstånd: " + shortestDist);
    }


    public static void main(String[] args) throws IOException {
        new TreacherousWhales();
    }
}
