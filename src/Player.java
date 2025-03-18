import java.util.Random;

public class Player
{
    String kind ;
    int n;
    int S_baghimande = 14;
    int[] shipLength = {5 ,4 ,3 ,2};
    Random rand = new Random();

    public Player(String Kind , int N)
    {
        kind = Kind;
        n=N;
    }
    public Player(String Kind)
    {
        kind = Kind;
    }




}