package non.uniform;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class comp {

      public void com()
      {   
          int n=0 , bits=0 ;
          ArrayList<Integer> a = new ArrayList<Integer>();
          
          try
          {
                Scanner in = new Scanner(new File("org.txt"));
                
                n =in.nextInt();
                bits=in.nextInt();
                int x ;
                for(int i = 0 ; i < n ; i ++)
                {
                    x=in.nextInt();
                    a.add(x);
                }
          }
          catch(Exception ex){}
          
          
          node no = new node();
          no.arr=a;
          tree ro = new tree(no);
          ro.bits=bits;
          
          ro.bulid(ro.root);
          ro.print();
          ro.checktree();
          System.out.println("new");
          ro.print();
          
          //10 2
          //2 4 8 10 9 9 12 14 6 6
          
          ArrayList<Integer> lower=new ArrayList<Integer>();
          ArrayList<Integer> upper=new ArrayList<Integer>();
          ArrayList<Integer> q=new ArrayList<Integer>();
          ArrayList<Integer> qs=new ArrayList<Integer>();
          
          
          for(int i = 0 ; i < ro.lenodes.size() ; i ++)
          {
              node y = ro.lenodes.elementAt(i);
              q.add(y.ave);
              qs.add(i);
          }
          
          int last = 0 ;
          
          for(int i = 0 ; i < q.size() ; i++)
          {
              if(i == 0)
              {
                int  n1 = q.get(i);
                int  n2 = q.get(i+1);
                  lower.add(0);
                  last = ( (n1+n2) / 2 ) ;
                  upper.add(last);
              }
              else if(i == q.size()-1)
              {
                  lower.add(last+1);
                  upper.add(127);
              }
              else 
              {   
              int  n1 = q.get(i);
              int  n2 = q.get(i+1);
                  lower.add(last+1);
                  last=( (n1+n2) / 2 );
                  upper.add(last);
              }
          }
          
          try
          {
                File f = new File("tags.txt");
                
                if(!f.exists())
                {
                    f.createNewFile();
                }
                PrintWriter pw = new PrintWriter(f);
                
                pw.println(bits);
                for(int i = 0 ; i < lower.size() ; i ++)
                {
                    //pw.print(lower.get(i)+" ");
                    //pw.print(upper.get(i)+" ");
                    pw.print(q.get(i)+" ");
                    pw.println(qs.get(i));
                    //System.out.println(lower.get(i) + " " + upper.get(i) + " " +  q.get(i) + " " + qs.get(i));
                }
                for(int i = 0 ; i < a.size() ; i ++)
                {
                    for(int j = 0 ; j < lower.size() ; j ++)
                    {
                        if(a.get(i) <= upper.get(j) && a.get(i) >= lower.get(j))
                        {
                            pw.println(qs.get(j));
                            break ;
                        }
                    }
                }
                pw.close();
          }
          catch(Exception ex){}
                    
      }
    
}
