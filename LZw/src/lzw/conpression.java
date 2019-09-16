package lzw;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class conpression {
    
   static Map mp = new HashMap();
   static String data ;
   
   static  String sub;
   
   public static void comp(String data) {
        
            int ind = 127;
            Scanner input = new Scanner(System.in);
            //data = input.next();
            Map<String, Integer> mp = new HashMap <String, Integer>() ;
            for (int i = 0; i < 128; i++)
            {
                mp.put(Character.toString((char) i), i);
            }
            try
            {
                int s = 0  , e= 0 ;
                File f = new File("tags.txt");
                
                if(!f.exists())
                {
                    f.createNewFile();
                }
                PrintWriter pw = new PrintWriter(f);
                while(s < data.length())
                {
                    e=s +1 ;
                    sub = data.substring(s,e);
                    while(e < data.length() && mp.get(sub) != null)
                    {
                        e++;
                        sub = data.substring(s,e);
                    }
                    if(mp.get(sub) !=null)
                    {
                        pw.println(mp.get(sub));
                        //System.out.println(mp.get(sub));
                        break;
                    }
                    else 
                    {
                        mp.put(sub,++ind);
                        sub = data.substring(s,(e-1));
                        pw.println(mp.get(sub));
                        //System.out.println(mp.get(sub));
                    }
                    s=e-1;
                }
                pw.close();
            }
            catch(Exception ex){}
        }
   }
   