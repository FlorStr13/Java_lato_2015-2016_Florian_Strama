

package tank;

public class TabKlockow {
    public Klocki[] klocki;
    TabKlockow()
    {
        klocki =new Klocki[3];
        klocki[0]= new Klocki(100,100,50,50);
        klocki[1]= new Klocki(300,200,50,50);
        klocki[2]= new Klocki(400,50,50,50);
    }
}
