import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreacherousWhales {
    List<Integer> positions;
    List<Integer> distances;
    String[] numbers;
    int shortestDist;
    int foundDist;

    public TreacherousWhales() throws IOException {
        shortestDist = 999999999;
        readInput();
        calculate();
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

    public void calculate() {                   //kolla varje plats som finns mellan 0 och högsta pos, kolla avstånd för alla, spara summa, jämför och spara lägsta varje gång.

        int highest = (int) positions.stream().sorted().toArray()[positions.size()-1];

        for (int pos = 0; pos <= highest; pos++) {
            distances = new ArrayList<>();
            for (Integer i : positions) {
                distances.add(Math.abs(i - pos));
            }
            foundDist = distances.stream().mapToInt(Integer::intValue).sum();
            if (foundDist < shortestDist) shortestDist = foundDist;
        }

        System.out.println(shortestDist);
    }


    public static void main(String[] args) throws IOException {
        new TreacherousWhales();
    }
}
