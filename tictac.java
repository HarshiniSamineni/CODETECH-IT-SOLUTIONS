
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n---------");
        }
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (char[] row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public static int[] playerMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        
        while (true) {
            try {
                System.out.print("Enter the row (0, 1, or 2) for player " + player + ": ");
                move[0] = scanner.nextInt();
                System.out.print("Enter the column (0, 1, or 2) for player " + player + ": ");
                move[1] = scanner.nextInt();

                if (isValidMove(board, move[0], move[1])) {
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return move;
    }

    public static int[] computerMove(char[][] board, char player) {
        System.out.println("Computer's turn (" + player + "):");
        Random random = new Random();
        int[] move = new int[2];

        do {
            move[0] = random.nextInt(3);
            move[1] = random.nextInt(3);
        } while (!isValidMove(board, move[0], move[1]));

        return move;
    }

    public static void playTicTacToe() {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        char[] players = {'X', 'O'};
        char currentPlayer = players[new Random().nextInt(players.length)];

        printBoard(board);

        while (true) {
            int[] move;
            if (currentPlayer == 'X') {
                move = playerMove(board, currentPlayer);
            } else {
                move = computerMove(board, currentPlayer);
            }

            board[move[0]][move[1]] = currentPlayer;
            printBoard(board);

            if (checkWinner(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull(board)) {
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void main(String[] args) {
        playTicTacToe();
    }
}