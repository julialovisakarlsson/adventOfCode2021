import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Dive {
    public static void main(String[] args) throws IOException {

        System.out.println("Del 1: ");
        part1();

        System.out.println("Del 2: ");
        part2();

    }

    public static void part1() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("lucka2/input.txt"))) {
            String line;
            int horizontal = 0;
            int depth = 0;
            while ((line = br.readLine()) != null) {
                String command = line.split(" ")[0];

                switch (command) {
                    case "forward": {
                        horizontal += Integer.parseInt(line.split(" ")[1]);
                        break;
                    }
                    case "down": {
                        depth += Integer.parseInt(line.split(" ")[1]);
                        break;
                    }
                    case "up": {
                        depth -= Integer.parseInt(line.split(" ")[1]);
                        break;
                    }
                    default:
                }
            }

            System.out.println(depth + " " + horizontal);

            System.out.println(depth * horizontal);
        }
    }
    public static void part2() throws IOException {
        int aim         = 0;
        int horizontal  = 0;
        int depth       = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String command = line.split(" ")[0];

                switch (command) {
                    case "forward": {
                        horizontal += Integer.parseInt(line.split(" ")[1]);
                        depth += aim * Integer.parseInt(line.split(" ")[1]);
                        break;
                    }
                    case "down": {
                        aim += Integer.parseInt(line.split(" ")[1]);
                        break;
                    }
                    case "up": {
                        aim -= Integer.parseInt(line.split(" ")[1]);
                        break;
                    }
                    default:
                }
            }

            System.out.println(depth + " " + horizontal);

            System.out.println(depth * horizontal);
        }


    }
}