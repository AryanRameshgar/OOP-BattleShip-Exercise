
import java.util.Scanner;

public class Main2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            int n;
            do {
                System.out.println("size ra vared konid: (n>4 , n<26)");
                n = input.nextInt();
            } while (n < 5 || n > 26);

            Board player1Board = new Board(n);
            Board player2Board = new Board(n);
            Board player1_view = new Board(n);
            Board player2_view = new Board(n);

            player1Board.initiate();
            player2Board.initiate();
            player1_view.initiate();
            player2_view.initiate();

            Player p1 = new Player("Human", n);
            Player p2 = new Player("Human", n);

            System.out.println("ba che kasi bazi mikonid? (1-player2  2-AI) :");
            int ch = input.nextInt();
            while (ch != 1 && ch != 2) {
                System.out.println("gozine vared shodeh ghabele ghabool nist!");
                ch = input.nextInt();
            }
            if (ch == 1) {
                p1 = new Player("Human", n);
                p2 = new Player("Human", n);
            }
            if (ch == 2) {
                p1 = new Player("Human", n);
                p2 = new AI(n);
            }

            Placing place = new Placing();

            place.placeShips(player1Board, p1, n);
            System.out.println("---------------------------------------");
            place.placeShips(player2Board, p2, n);

            PlayGame play = new PlayGame(player1_view, player2_view, p1, p2, player1Board, player2Board, n);
            play.playGame();
            System.out.println("do you want to replay?");
            String replay = input.next().toLowerCase();
            if(!replay.equals("yes")){break;}
        }
    }
}