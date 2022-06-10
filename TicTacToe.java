import java.util.Random;
import java.util.Scanner;

public  class TicTacToe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = {  {' ', ' ', ' '},
                            {' ', ' ', ' '},
                            {' ', ' ', ' '}};

        printBoard(board);

        while (true) {
            playerTurn(board, scanner);
            if ( isGameFinished(board)) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            if ( isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
//        printBoard(board);
    }

    private static boolean isGameFinished(char[][] board) {

        if ( hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player Wins !");
            return true;
        }

        if ( hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer Wins !");
            return true;
        }


        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie !");
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;

        while (true) {
             computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board,Integer.toString(computerMove))){
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove(char[][] board , String position){

        return switch (position) {
            case "1" -> board[0][0] == ' ';
            case "2" -> board[0][1] == ' ';
            case "3" -> board[0][2] == ' ';
            case "4" -> board[1][0] == ' ';
            case "5" -> board[1][1] == ' ';
            case "6" -> board[1][2] == ' ';
            case "7" -> board[2][0] == ' ';
            case "8" -> board[2][1] == ' ';
            case "9" -> board[2][2] == ' ';
            default -> false;
        };
    }

    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("where would yo like to play ? (1:9)");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            }else {
                System.out.println(userInput + " is not a valid move");
            }
        }
            placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position , char symbol) {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> System.out.println(":(");
        }
    }


    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}