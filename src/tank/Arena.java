package tank;

public class Arena 
{   
    int[][] plansza;
     
    Arena()
    {
        plansza=new int[550][550];
        for(int i=0;i<550;i++)
        {
            for(int j=0;j<550;j++)
            {
              plansza[i][j]=0;
            }
        }   
    }
    
    void wpisz(TabKlockow klocki)
    {
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
