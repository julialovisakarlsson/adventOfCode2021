import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanternfish {
    String[] numbers;
    List<Integer> fishes;

    public Lanternfish() throws IOException {
        readInput();

        for (int i = 0; i < 80; i++) {
            calculate();
            addFish();
        }

        System.out.println(fishes.size());
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

    private void calculate() {
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


    public static void main(String[] args) throws IOException {
        new Lanternfish();
    }
}
