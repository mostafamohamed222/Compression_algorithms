package arithmetic.coding;

import java.io.File;
import java.io.PrintWriter;

public class comp {
        
    public static void com(String data)
    {
        int [] count = new int[128];
        float [] lower = new float[128];
        float [] upper= new float[128];
        float [] prol = new float[128];
        float [] prou = new float[128];
        float [] pro = new float[128];
        
        //String data ;
        
        //Scanner in = new Scanner(System.in);
        //data = in.next();
        
        for(int i = 0 ; i < data.length(); i ++)
        {
            char x= data.charAt(i);
            count[x]++;
        }
        
        float last = 0;
        
        float z=0 ;
        for(int i = 0 ; i < 128 ; i++)
        {
            if(count[i] != 0)
            {
                pro[i] = count[i]/(float)data.length();
                if(i == 0)
                {
                    lower[i] = 0;
                    upper[i] = pro[i];
                    prol[i]=lower[i];
                    prou[i]=upper[i];
                    last = upper[i];
                }
                else 
                {
                    lower[i] = last ;
                    upper[i] = lower[i] + pro[i];
                    
                    //System.out.println(last + " " + lower[i] + " " + pro[i] + " " + upper[i]);
                    prol[i]=lower[i];
                    prou[i]=upper[i];
                    last = upper[i];
                }
               
            }
        }
       // System.out.println(z);
    
    float low = 0 , up= 1;
    
    for(int i = 0 ; i < data.length()-1 ; i ++)
    {
        low = lower[data.charAt(i)];
        up = upper[data.charAt(i)];
        
        for(int j = 0 ; j < 128 ; j++)
        {
                lower[j] = low + ((up - low ) * prol[j]);
                upper[j] = low + ((up - low ) * prou[j]);
        }
       // System.out.println(low + " " + up + " " + data.charAt(i));
    }
    
    char x = data.charAt(data.length()-1);
        
    low = lower[(int) x ];
    up = upper[(int)x ];
    
    
    double code = (low + up)  / 2;
    //System.out.println(code);    

    try
    {
        File f = new File("tags.txt");
                
        if(!f.exists())
        {
            f.createNewFile();
        }
        PrintWriter pw = new PrintWriter(f);
        
        pw.println(data.length());
        pw.println(code);
        
        for(int i = 0 ; i < 128 ; i ++)
        {
            if(count[i] != 0)
            {
                pw.println(i);
                pw.println(prol[i]);
                pw.println(prou[i]);
            }
        }
        pw.close();
    }
    catch(Exception ex){}
    
    }
    
    
}