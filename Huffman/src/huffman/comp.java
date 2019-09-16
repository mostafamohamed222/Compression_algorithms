package huffman;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class comp {
   
    public static void com(String data)
    {
        //Scanner in = new Scanner(System.in);
        //String data ;
        int [] sum = new int[128];
            
        //data=in.next();
        
        char next  ;
        int num  ;
        
        for(int i = 0 ; i < data.length() ; i ++)
        {
            next = data.charAt(i);
            num=(int)next;
            sum[num]++;
        }
        
        Vector < node > v = new Vector<node>();
        
        for(int i = 0 ; i < 128 ; i ++)
        {
            int n = sum[i];
            if(n != 0)
            {
                node no = new node(n);
                no.c=(char) i;
                v.addElement(no);
            }
        }
        
        
        node n = null;
            
        while(v.size() != 1)
        {
            int m1=10000 , m2=10000 , ind1=0 ,ind2=0 ;
        
            for(int i = 0 ; i < v.size() ; i++)
            {
                n=v.elementAt(i);
                int x = n.data;
                if(x < m1)
                {
                    m2=m1;
                    ind2=ind1;
                    m1=x;
                    ind1=i;
                }
                else if(x < m2)
                {
                    m2=x;
                    ind2=i;
                }
            }
            int ma;
            int mi;
            if(ind1 < ind2)
            {
                ma=ind2;
                mi=ind1;
            }
            else 
            {
                ma=ind1;
                mi=ind2;
            }
            
            node n1 = v.elementAt(ind1);
            node n2 = v.elementAt(ind2);
            int sum2node = n1.data+n2.data;
            node n3 = new node(sum2node);
            n3.rnode= n1;
            n3.lnode= n2;
            v.remove(ma);
            v.remove(mi);
            v.addElement(n3);
        }
        n=v.elementAt(0);
        
        tree t =new tree(v.elementAt(0));       
        
        t.dfs(t.root,"");
    
        try
        {
            File f = new File("tags.txt");
                
            if(!f.exists())
            {
                f.createNewFile();
            }
            PrintWriter pw = new PrintWriter(f);
            
            for(int i = 0 ; i < data.length() ; i ++)
            {
                char x = data.charAt(i);
                pw.print(t.code[x]);
                
            }
            pw.println("");
            
            for(int i = 0 ; i < 128 ; i ++)
            {
                if(t.code[i] != null)
                {
                    pw.println(i);
                    pw.println(t.code[i]);
                }
            }
            pw.close();
        }
        catch(Exception ex){}
    }
}
