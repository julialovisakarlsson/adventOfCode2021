import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class BinaryDiagnostic {
    public static void main(String[] args) throws IOException {
        System.out.println("Del 1: ");
        powerConsumption();

        System.out.println("Del 2: ");
        lifeSupportRating();
    }

    public static void powerConsumption() throws IOException {
        StringBuilder[] builders = createBinary();

        int gamma = decimal(builders[0].reverse().toString());
        int epsilon = decimal(builders[1].reverse().toString());

        System.out.println(gamma * epsilon);
    }

    public static StringBuilder[] createBinary() throws IOException {
        BufferedReader br;
        String line;

        int number;
        int half;

        StringBuilder gammaString = new StringBuilder();
        StringBuilder epsilonString = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            br = new BufferedReader(new FileReader("lucka3/input.txt"));
            half = 0;
            number = 0;
            while ((line = br.readLine()) != null) {
                number += Integer.parseInt(String.valueOf(line.charAt(i)));
                half++;
            }
            half = half/2;
            if (number > half) {
                gammaString.append(1);
                epsilonString.append(0);
            } else {
                gammaString.append(0);
                epsilonString.append(1);
            }
        }
        StringBuilder[] result = new StringBuilder[2];
        result[0] = gammaString;
        result[1] = epsilonString;
        return result;
    }

    public static void lifeSupportRating() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lucka3/input.txt"));
        String line;
        List<String> O2 = new ArrayList<>();
        List<String> CO2 = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            O2.add(line);
            CO2.add(line);
        }

        List<String> o2Filter = filter(O2, true);
        List<String> co2Filter = filter(CO2, false);

        StringBuilder sb = new StringBuilder();

        sb.append(o2Filter.get(0));

        int O2GenRating = decimal(sb.reverse().toString());

        sb.delete(0, 12);

        sb.append(co2Filter.get(0));

        int CO2ScrubberRating = decimal(sb.reverse().toString());

        System.out.println(O2GenRating * CO2ScrubberRating);
    }

    private static List<String> filter(List<String> list, boolean o2) {
        int number;
        double half;
        for (int i = 0; i < 11; i++) {
            half = 0;
            number = 0;
            for (String binary : list) {
                number += Integer.parseInt(String.valueOf(binary.charAt(i)));
                half++;
            }
            half = half / 2;
            int index = i;
            if (o2) {
                if (number >= half) {
                    list = list.stream().filter(s -> s.charAt(index) == '1').collect(Collectors.toList());
                }
                else {
                    list = list.stream().filter(s -> s.charAt(index) == '0').collect(Collectors.toList());
                }
            }
            else {
                if (number >= half) {
                    list = list.stream().filter(s -> s.charAt(index) == '0').collect(Collectors.toList());
                }
                else {
                    list = list.stream().filter(s -> s.charAt(index) == '1').collect(Collectors.toList());
                }
            }
            if (list.size() == 1) {
                return list;
            }
        }
        return list;
    }


    public static int decimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, i);
        }
        return decimal;
    }


}