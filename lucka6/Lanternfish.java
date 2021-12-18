import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lanternfish {
    String[] numbers;
    List<Integer> fishes;
    Map<Integer, Long> groupOfFishes;

    public Lanternfish() throws IOException {
        readInput();
        mapFishes();

        for (int i = 0; i < 18; i++) {
            calculatePt1();
            addFish();
        }
        System.out.println("Del 1: " + fishes.size());

        for (int i = 0; i < 256; i++) {
            calculatePt2();
        }

        long sum = 0;
        for (int i = -1; i < 9; i++) {
            sum += groupOfFishes.getOrDefault(i, 0L);
        }

        System.out.println("Del 2: " + sum);

    }

    private void readInput() throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader("lucka6/input.txt"));

        while ((line = br.readLine()) != null) {
            numbers = line.split(",");
        }

        fishes = new ArrayList<>();
        for (String number : numbers) {
            fishes.add(Integer.parseInt(number));
        }
    }

    private void calculatePt1() {
        for (int i = 0; i < fishes.size(); i++) {
            if (fishes.get(i) >= 0) fishes.set(i, fishes.get(i)-1);
        }
    }

    private void addFish() {
        for (int i = 0; i < fishes.size(); i++) {
            if (fishes.get(i) < 0) {
                fishes.add(8);
                fishes.set(i, 6);
            }
        }
    }

    private void mapFishes() {
        long aCount = 0;
        long bCount = 0;
        long cCount = 0;
        long dCount = 0;
        long eCount = 0;

        groupOfFishes = new HashMap<>();
        for (Integer fish : fishes) {

            switch (fish) {
                case 1: {
                    aCount++;
                    break;
                }
                case 2: {
                    bCount++;
                    break;
                }
                case 3: {
                    cCount++;
                    break;
                }
                case 4: {
                    dCount++;
                    break;
                }
                case 5: {
                    eCount++;
                    break;
                }
                default:
                    System.out.println("fel");
            }
        }
        groupOfFishes.put(0, 0L);
        groupOfFishes.put(1, aCount);
        groupOfFishes.put(2, bCount);
        groupOfFishes.put(3, cCount);
        groupOfFishes.put(4, dCount);
        groupOfFishes.put(5, eCount);
        groupOfFishes.put(6, 0L);
        groupOfFishes.put(7, 0L);
        groupOfFishes.put(8, 0L);
    }

    private void calculatePt2() {
        long regenerating = groupOfFishes.get(0);
        groupOfFishes.put(0, 0L);
        for (int i = 1; i < 9; i++) {
            groupOfFishes.put(i - 1, groupOfFishes.getOrDefault(i, 0L));
        }
        groupOfFishes.put(8, regenerating);
        groupOfFishes.put(6, groupOfFishes.get(6) + regenerating);
    }


    public static void main(String[] args) throws IOException {
        new Lanternfish();
    }
}
