import java.util.Scanner;

import static java.lang.Thread.sleep;

public class PlayGame
{
    int n;
    Board b1_view;
    Board b2_view;
    Board b1;
    Board b2;
    Player p1;
    Player p2;
    GameOver payan ;
    public PlayGame(Board B1_view , Board B2_view , Player P1 , Player P2 , Board B1 , Board B2 , int N)
    {
        n = N;
        b1_view = B1_view;
        b2_view = B2_view;
        p1 = P1;
        p2 = P2;
        b1 = B1;
        b2 = B2;
        payan = new GameOver(p1 , p2);
    }


    public  void playGame()
    {
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;

        if(p2.kind.equals("Human"))
        {
            int currentPlayer = 1;
            while (!gameOver)
            {
                System.out.println("Player " + currentPlayer + "'s turn");
                System.out.println("Opponent's board:");
                if (currentPlayer == 1) {
                    b2_view.printBoard();
                } else {
                    b1_view.printBoard();
                }

                System.out.println("Enter row (0-" + (n - 1) + "): ");
                int row = input.nextInt();
                System.out.print("Enter column (A-" + (char) (n - 1 + 65) + "): ");
                String Col = input.next().toUpperCase();
                char sotoon = Col.charAt(0);
                int col = (int) sotoon - 65;

                if (row >= 0 && row < n && col >= 0 && col < n) {
                    attack(currentPlayer, row, col);
                    gameOver = payan.isGameOver();
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
                else
                {
                    System.out.println("Invalid move. Try again.");
                }
            }

            // اعلام برنده
            if (p1.S_baghimande == 0) {
                System.out.println("Player 2 wins! All Player 1's ships have been destroyed.");
            } else {
                System.out.println("Player 1 wins! All Player 2's ships have been destroyed.");
            }
        }
        if (p2.kind.equals("AI"))
        {
            int row , col;
            while (!gameOver)
            {
                do
                {
                    System.out.println("it's your turn player");
                    System.out.println("Opponent's board:");
                    b2_view.printBoard();
                    System.out.println("Enter row (0-" + (n - 1) + "): ");
                    row = input.nextInt();
                    System.out.print("Enter column (A-" + (char) (n - 1 + 65) + "): ");
                    String Col = input.next().toUpperCase();
                    char sotoon = Col.charAt(0);
                     col = (int) sotoon - 65;

                    if (row >= 0 && row < n && col >= 0 && col < n) {
                        attack(1, row, col);
                        gameOver = payan.isGameOver();
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                }while (!(row >= 0 && row < n && col >= 0 && col < n));

                row = (int) (Math.random() * n);
                col = (int) (Math.random() * n);
                attack(2, row, col);

                System.out.println("your board: ");
                b1.printBoard();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public  void attack(int player, int row, int col)
    {
        char[][] opponentBoard = (player == 1) ? b2.board : b1.board;
        char[][] opponentBoard_view = (player == 1) ? b2_view.board : b1_view.board;

        if (opponentBoard[row][col] == 'S')
        {
            opponentBoard[row][col] = 'X';  //  نشان دهنده ضربه به کشتی است
            opponentBoard_view[row][col] = 'X';
            if (player == 1)
            {
                p2.S_baghimande--;
            }
            else
            {
                p1.S_baghimande--;
            }
            System.out.println("Hit!");
        }
        else if (opponentBoard[row][col] == '~')
        {
            opponentBoard[row][col] = 'O';//  نشان دهنده حمله به آب است
            opponentBoard_view[row][col] = 'O';
            System.out.println("Miss!");
        }
        else
        {
            System.out.println("You already attacked this position.");
        }
    }
}
