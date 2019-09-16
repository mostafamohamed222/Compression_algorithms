package huffman;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class decompression {

    
    public static void decomp() 
    {
        String data="" ;
        String [] code = new String[128];
    
        try
        {
            Scanner x = new Scanner(new File("tags.txt"));
            data=x.next();
            
           int ch;
            
            String cod;
            while(x.hasNext())
            {
                ch=x.nextInt();
                cod=x.next();
                
                code[ch]=cod;
            }
            
            File f = new File("data.txt");
                
            if(!f.exists())
            {
                f.createNewFile();
            }
            PrintWriter pw = new PrintWriter(f);
            
            String sea="";
            for(int i = 0 ; i < data.length() ; i ++)
            {
                sea+=data.charAt(i);
                for(int j = 1 ; j < 128 ; j ++)
                {
                    if(sea == null ? code[j] == null : sea.equals(code[j]))
                    {
                        pw.print((char)j);
                        sea="";
                        break;
                    }
                }
            }
            
            pw.close();
        }
        catch(Exception ex){}
    }
}
