package tank;

public class Arena 
{   
    private static Arena ourInstance = new Arena();

    public static Arena getInstance() {
        return ourInstance;
    }
    
    
    
    int[][] plansza;
    int lvl;
    Arena()
    {
        lvl=1;
        plansza=new int[502][502];
        for(int i=0;i<502;i++)
        {
            for(int j=0;j<502;j++)
            {
              plansza[i][j]=0;
            }
        }   
    }
    
    void wpisz(TabKlockow klocki)
    {
        for(int i=0;i<501;i++)
        {
            for(int j=0;j<501;j++)
            {
              plansza[i][j]=0;
            }
        }   
        for (Klocki klocki1 : klocki.klocki) {
            int x=klocki1.x;
            int y=klocki1.y;
            int w=klocki1.w;
            int h=klocki1.h;
            for (int i = x; i < x+w; i++) {
                for (int j = y; j < y+h; j++) {
                    plansza[i][j]=1;
                }
            }
        }
    }
    
}
