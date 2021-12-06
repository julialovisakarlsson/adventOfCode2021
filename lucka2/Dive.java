import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Dive {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
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
}