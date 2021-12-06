import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CalculateDepthIncrease {
    public static void main(String[] args) throws IOException {

        System.out.println("Jämförelse av två nummer");
        compare1();
        System.out.println("Jämförelse av 3-sliding window");
        compare2();
    }

    private static void compare1() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int one = 0;
            int two;
            int result = 0;
            while ((line = br.readLine()) != null) {
                two = one;
                one = Integer.parseInt(line);
                if (one > two && two != 0) result++;
            }
            System.out.println(result);
        }
    }

    private static void compare2() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int one     = 0;
            int two     = 0;
            int three   = 0;
            int four    = 0;

            int result  = 0;

            if ((line = br.readLine()) != null) {
               one = Integer.parseInt(line);
               if ((line = br.readLine()) != null) {
                   two = Integer.parseInt(line);
                   if ((line = br.readLine()) != null) {
                       three = Integer.parseInt(line);
                       if ((line = br.readLine()) != null) {
                           four = Integer.parseInt(line);
                           if (one + two + three < two + three + four) result++;
                       }
                   }
               }
            }
            while ((line = br.readLine()) != null) {
                one = two;
                two = three;
                three = four;
                four = Integer.parseInt(line);
                if (one + two + three < two + three + four) result++;
            }
            System.out.println(result);
        }

    }
}