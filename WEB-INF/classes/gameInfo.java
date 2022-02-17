public class gameInfo
{
    String username;
    String password;
    String score;

    public gameInfo(String u, String s)
    { 
        username=u;
        score=s;
    }
    // public gameInfo(String u, int s)
    // {
    //     int scoree = Integer.parseInt(score);
    //     username=u;
    //     scoree=s;
    // }
    public gameInfo(String u)
    {
        username=u;
    }
    public gameInfo(String u, String p, String s)
    {
        username=u;
        password=p;
        score= s;
    }

    public String toString()
    {
        return  "Username : "+username+ "    Highest Score: "+score;
    }
}