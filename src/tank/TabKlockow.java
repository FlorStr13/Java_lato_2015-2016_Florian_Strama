

package tank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TabKlockow {
    public Klocki[] klocki;
    Map mapa=new Map();
    TabKlockow(int lvl) throws FileNotFoundException 
    {   
        Scanner in = new Scanner(new File(mapa.in[lvl-1]));
        int i=  Integer.parseInt(in.next());
        klocki =new Klocki[i];
        for (int j=0;j<i;j++)
        {
            klocki[j]= new Klocki(Integer.parseInt(in.next()),Integer.parseInt(in.next()),50,50);
        }
    }
}
