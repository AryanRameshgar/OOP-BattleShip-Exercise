public class GameOver
{

    Player p1;
    Player p2;

    public GameOver(Player P1 , Player P2)
    {
        p1 = P1;
        p2 = P2;
    }
    public boolean isGameOver()
    {
        if(p1.S_baghimande == 0 || p2.S_baghimande ==0)
        {
            return true;
        }
        return false;
    }
}
