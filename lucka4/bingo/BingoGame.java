package bingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoGame {
    private final List<Board> boards = new ArrayList<>();
    List<Board> winners = new ArrayList<>();
    private final List<Integer> callNumber = new ArrayList<>();

    public BingoGame() throws IOException {
        readInput();
        calculate();
        winners = winners.stream().distinct().collect(Collectors.toList());

        System.out.println("Första vinnare:");

        Board firstWinner = winners.get(0);
        System.out.println("Vinnare: " + firstWinner.getBoardNumber() + ", Poäng: " + firstWinner.finalScore());

        System.out.println("Sista vinnare:");

        Board lastWinner = winners.get(winners.size()-1);
        System.out.println("Vinnare: " + lastWinner.getBoardNumber()  + ", Poäng: " + lastWinner.finalScore());
    }

    public void readInput() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("lucka4/input.txt"));
        String line = br.readLine();
        for (String number : line.split(",")) callNumber.add(Integer.parseInt(number));
        br.readLine();

        int row = 0;
        int number = 0;
        int[][] bingo = new int[5][5];

        while ((line = br.readLine()) != null) {

            if (!line.isBlank()) {
                List<String> filtered = Arrays.stream(line.split(" ")).filter(s -> !s.isBlank()).collect(Collectors.toList());
                for (int i = 0; i < 5; i++) {
                    bingo[row][i] = Integer.parseInt(filtered.get(i));
                }
                row++;
            }
            else {
                boards.add(new Board(bingo, number));
                number++;
                bingo = new int[5][5];
                row = 0;
            }
        }
    }

    private void calculate() {
        for (int number : callNumber) {
            for (Board board : boards) {
                if (!board.win()) {
                    board.addCallNumber(number);
                }
                else {
                    winners.add(board);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BingoGame();
    }
}
