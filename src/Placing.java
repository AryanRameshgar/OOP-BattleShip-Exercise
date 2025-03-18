import java.util.Random;
import java.util.Scanner;

public class Placing
{
    int n;
    Scanner input = new Scanner(System.in);
    String chooser;
    public  void placeShips(Board B , Player p , int N)
    {
        n = N;
        Random rand = new Random();
        char[][] currentBoard = B.board;
        int tedad_kashti_gharar_gerefte = 0;

        while (tedad_kashti_gharar_gerefte < 4)
        {
            int shipLength = p.shipLength[tedad_kashti_gharar_gerefte];
            int row=0;
            int col=0;
            char direction =' ';
            int choose;
            //
            if(p.kind.equals("AI") )
            {
                do
                {
                    row = (int) (Math.random() * n);
                    col = (int) (Math.random() * n);
                    int dir = (int)(Math.random() * 2);
                    if(dir==0){direction = 'h';}
                    if(dir==1){direction = 'v';}
                }while(!harketGhabaleGhabool(currentBoard, row, col, shipLength, direction));
            }
            else
            {
                do
                {
                    System.out.println("che kasi in kashti ra gharar dahad(andaze kashti feli: " + shipLength + ")? 1-khodam 2-AI");
                    choose = input.nextInt();
                } while (choose != 1 && choose != 2);

                if (choose == 1)
                {
                    chooser = "PLAYER";
                    B.printBoard();
                    do
                    {
                        System.out.print("row ra vared konid: ");
                        row = input.nextInt();
                    } while (row < 0 || row > n);

                    do
                    {
                        System.out.print("col ra vared konid: ");
                        String Col = input.next().toUpperCase();
                        char column = Col.charAt(0);
                        col = column - 65;
                    } while (col < 0 || col > 25);

                    System.out.println("jahat ra vared konid (zoj=ofoghi , fard=amoodi) : ");
                    int dir = input.nextInt();
                    dir = dir % 2;
                    if (dir == 0)
                    {
                        direction = 'h';
                    }
                    if (dir == 1)
                    {
                        direction = 'v';
                    }
                }
                else
                {
                    chooser = "AI";
                    do
                    {
                        row = (int) (Math.random() * n);
                        col = (int) (Math.random() * n);
                        int dir = (int) (Math.random() * 2);
                        if (dir == 0) {
                            direction = 'h';
                        }
                        if (dir == 1) {
                            direction = 'v';
                        }
                    } while (!harketGhabaleGhabool(currentBoard, row, col, shipLength, direction));
                }
            }
            if (harketGhabaleGhabool(currentBoard, row, col, shipLength, direction))
            {
                placeShip(currentBoard, row, col, shipLength, direction);
                tedad_kashti_gharar_gerefte++;
            }
        }
    }


    public boolean harketGhabaleGhabool(char[][] board, int row, int col, int length, char direction)
    {
        if (direction == 'h')
        {
            if (col + length > n)
            {
                if(chooser.equals("PLAYER")) System.out.println("invalid choice. Please try again");
                return false;
            }
            for (int i = 0; i < length; i++)
            {
                if (board[row][col + i] != '~')
                {
                    if(chooser.equals("PLAYER")) System.out.println("invalid choice. Please try again");
                    return false;
                }
            }
        }
        else if (direction == 'v')
        {
            if (row + length > n)
            {
                if(chooser.equals("PLAYER")) System.out.println("invalid choice. Please try again");
                return false;
            }
            for (int i = 0; i < length; i++)
            {
                if (board[row + i][col] != '~')
                {
                    if(chooser.equals("PLAYER")) System.out.println("invalid choice. Please try again");
                    return false;
                }
            }
        }
        return true;
    }


    public static void placeShip(char[][] board, int row, int col, int length, char direction)
    {
        if (direction == 'h')
        {
            for (int i = 0; i < length; i++)
            {
                board[row][col + i] = 'S';  // قرار دادن کشتی افقی
            }
        }
        else if (direction == 'v')
        {
            for (int i = 0; i < length; i++)
            {
                board[row + i][col] = 'S';  // قرار دادن کشتی عمودی
            }
        }
    }
}