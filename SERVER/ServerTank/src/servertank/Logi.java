package servertank;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logi {
    public  String DATE_FORMAT_NOW = "yyyy-MM-dd-HH-mm-ss";
    public  String filename;
    public  PrintWriter writer = null;
    
    public  String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
    
    Logi() {     
        filename="Logi\\logi_z_"+now()+".txt";
        try {
            writer = new PrintWriter(filename, "UTF-8");
        } catch (FileNotFoundException ex) {
            
        } catch (UnsupportedEncodingException ex) {
            
        }finally
        {
            writer.close();
        }
    }
    

    public void write(String text)
    {   
        try {
             FileWriter fw = new FileWriter(filename,true);
             fw.write(text+"\t");
             fw.close();
        } catch (IOException ex) {
            
        }
    }
    
}
