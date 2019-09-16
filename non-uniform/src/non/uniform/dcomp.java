package non.uniform;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dcomp {
    public void dcom()
    {
        ArrayList<Integer> q=new ArrayList<Integer>();
        ArrayList<Integer> qs=new ArrayList<Integer>();
        ArrayList<Integer> data =new ArrayList<Integer>();
        int bits=0;  
        try
        {
            Scanner x = new Scanner(new File("tags.txt"));
            bits=x.nextInt();
            bits=(int) Math.pow(2, bits);
            int a;
            for(int i = 0 ; i < bits ; i ++)
            {
                a = x.nextInt();
                q.add(a);
                a=x.nextInt();
                qs.add(a);
            }
            
            while(x.hasNext())
            {
                a=x.nextInt();
                data.add(a);
            }
            File f = new File("data.txt");
                
            if(!f.exists())
            {
                f.createNewFile();
            }
            PrintWriter pw = new PrintWriter(f);

            for(int i = 0 ; i < data.size() ; i ++)
            {
                for(int j = 0 ; j < bits ; j ++)
                {
                    if(data.get(i) == qs.get(j))
                    {
                        pw.print(q.get(j)+ " ");
                    }
                }
            }
            pw.close();
        }
        catch(Exception ex){}
        
        
    }
}
