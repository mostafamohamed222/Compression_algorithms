package arithmetic.coding;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class decom {

     public static void dcom()
     {
         double code = 0.0 ;
         double [] lower = new double[128];
         double [] upper= new double[128];
         double [] prol = new double[128];
         double [] prou = new double[128];
         int len = 0  ;
        
        try
        {
             Scanner x = new Scanner(new File("tags.txt"));
             len=x.nextInt();
             code=x.nextDouble();
             
             while(x.hasNext())
             {
                 int i = x.nextInt();
                 lower[i]=x.nextDouble();
                 upper[i]=x.nextDouble();
                 System.out.println((char) i  + " " + lower[i] + " " + upper[i]);
                 prol[i] = lower[i];
                 prou[i] = upper[i];
             }
             x.close();    
        }
        catch(Exception ex)
        {}
        
        double low = 0 , up= 1;
        String data ="";
        for(int i = 0 ; i < len ; i ++)
        {
            for(int j = 0 ;j < 128 ; j ++)
            {   
                if(lower[j] <= code && upper[j] >= code)
                {
                    low = lower[j];
                     up = upper[j];
                     data+=(char) j;
                    System.out.print ( (char) j );
                    for(int k = 0 ; k < 128 ; k ++)
                    {
                        lower[k] = low + ((up - low ) * prol[k]);
                        upper[k] = low + ((up - low ) * prou[k]);
                    }
                    break;
                }
            }
        }
        
        System.out.println("");
        
        try
        {
          File f = new File("data.txt");
                
            if(!f.exists())
            {
                f.createNewFile();
            }
            PrintWriter pw = new PrintWriter(f);
            
            pw.println(data);
            pw.close();
        }
        catch(Exception ex)
        {}
        
     }
}
