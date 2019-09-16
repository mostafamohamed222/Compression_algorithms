package lzw;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class decompression {
       
    public static void decomp()
    {
        Map<Integer, String > mp = new HashMap <Integer, String >() ;
        int nmb = 0 ;
        for (int i = 0; i < 128; i++)
        {
            mp.put( i , Character.toString((char) i));
        }
        
        try
        {
            Scanner x = new Scanner(new File("tags.txt"));
            int ind = 127;
            
            String last = null  , ne ;
            String  data="";
            
            int w ;
            
            while(x .hasNext() )
            {
                 w=x.nextInt();
                
                 if(nmb == 0)
                 {
                     last=mp.get(w);
                     data+=last;
                     System.out.print(last);
                     nmb++;
                 }
                 else 
                 {
                    ne=mp.get(w);
                    if(ne == null)
                    {
                        ne = last + last.substring(0,1);
                        data+=ne;
                        System.out.print(ne);
                        mp.put(++ind, ne);
                    }
                    else 
                    {
                         data+=ne;
                         System.out.print(ne);
                         String sub = last+ne.substring(0,1);
                         mp.put(++ind, sub);
                    }
                    last=ne;
                 }
            }
            
            System.out.println("");
            
                 File f = new File("data.txt");
                
                if(!f.exists())
                {
                    f.createNewFile();
                }
                PrintWriter pw = new PrintWriter(f);
                pw.println(data);
                pw.close();
                
            x.close();
        }
        catch(Exception ex){}
    }   
}
