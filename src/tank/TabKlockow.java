

package tank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TabKlockow {
    public Klocki[] klocki;
    Map mapa=new Map();
    TabKlockow(int lvl)  
    {   
        Scanner in;
        try {
            in = new Scanner(new File(mapa.in[lvl-1]));
            int i =  Integer.parseInt(in.next());
            klocki = new Klocki[i];
            for (int j=0;j<i;j++)
            {
                klocki[j]= new Klocki(Integer.parseInt(in.next()),Integer.parseInt(in.next()),50,50);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabKlockow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
