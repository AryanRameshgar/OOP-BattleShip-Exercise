public class Board
{
    int n;
    char[][] board;
    public Board(int N)
    {
        n = N;
        board = new char[n][n];
    }
    public void initiate()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '~';
        }
    }
    public void printBoard()
    {
        System.out.print("  ");
        for (int i = 0; i < n; i++)
        {
            System.out.print((char)(i+65)+ " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            System.out.print(i + " ");
            for (int j = 0; j < n; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
