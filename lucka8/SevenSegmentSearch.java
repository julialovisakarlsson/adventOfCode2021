import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SevenSegmentSearch {

    public SevenSegmentSearch() throws IOException {
        readInput();
    }

    public void readInput() throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader("lucka8/input.txt"));
        int count = 0;

        while ((line = br.readLine()) != null) {

            String[] outputs = line.split(" ");

            for (int i = 11; i < outputs.length; i++) {
                if (outputs[i].length() == 7 || outputs[i].length() == 4 || outputs[i].length() == 3 || outputs[i].length() == 2) {
                    count ++;
                }
            }

        }
        System.out.println(count);

    }


    public static void main(String[] args) throws IOException {
        new SevenSegmentSearch();
    }

}
