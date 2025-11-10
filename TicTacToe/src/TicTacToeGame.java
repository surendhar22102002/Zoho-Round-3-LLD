import java.util.Scanner;

public class TicTacToeGame {
    Board board = new Board();
    Player player1;
    Player player2;
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Tic Tac Teo Game...");
        board.printBoard();

        // Player Setup
        getPlayerNames();

        Player currentPlayer = player1;

        while (true) {
            System.out.println();
            board.printBoard();
            System.out.println(currentPlayer.getPlayerName() + " ( " + currentPlayer.getPlayerSymbol() + " ) its Your Turn...");

            int row;
            int col;

            while (true) {
                System.out.println();
                System.out.println("------------------");

                System.out.print("Enter row (1-3) : ");
                row = sc.nextInt() - 1;

                System.out.print("Enter col (1-3) : ");
                col = sc.nextInt() - 1;

                if (board.makeMove(row, col, currentPlayer.getPlayerSymbol())) {
                    System.out.println("Super Move " + currentPlayer.getPlayerName());

                    System.out.println();
                    System.out.println("------------------");
                    break;
                } else {
                    System.out.println();

                    System.out.println("Invalid Move Please Try Again....");

                    System.out.println();
                }
            }

            // check is win
            if (board.isWin(currentPlayer.getPlayerSymbol())) {
                System.out.println();
                System.out.println("------------------");

                board.printBoard();
                System.out.println(currentPlayer.getPlayerName() + " You Win the Game....");

                System.out.println();
                System.out.println("------------------");
                break;
            }

            // check is draw
            if (board.isDraw()) {
                System.out.println();
                System.out.println("------------------");

                board.printBoard();
                System.out.println("It's Draw...!");

                System.out.println();
                System.out.println("------------------");
                break;
            }

            currentPlayer = currentPlayer == player1 ? player2 : player1;

        }
    }

    private void getPlayerNames() {
        System.out.println();
        System.out.println("---------------------------------");

        System.out.print("Enter Player1 Name : ");
        String p1 = sc.nextLine();
        player1 = new Player(Symbol.X, p1);
        System.out.println("Hii " + player1.getPlayerName() + " your symbol is " + player1.getPlayerSymbol());

        System.out.println();
        System.out.println("---------------------------------");


        System.out.print("Enter Player2 Name :");
        String p2 = sc.nextLine();
        player2 = new Player(Symbol.O, p2);
        System.out.println("Hii " + player2.getPlayerName() + " your symbol is " + player2.getPlayerSymbol());


        System.out.println();
        System.out.println("---------------------------------");
    }
}
