package la77;

import java.util.Scanner;

public class La77 {

    public static void main(String[] args) {
        
           Scanner  input = new Scanner(System.in);
           String data = input.next();
           int[] pos = new int [1000];
           int [] len = new int [1000];
           char [] c = new char [1000];
           int tagnumber = 0 ;
           String sub , dic = "";
           int search  ; 
           int i=0 ,  j=i+1 ;
           
           
                while(i<data.length())
                {
                    j=i+1;
                    sub=data.substring(i,j);
                    search=dic.lastIndexOf(sub);
                    if(search==-1)
                    {
                        pos[tagnumber]=0;
                        len[tagnumber]=0;
                        c[tagnumber]=sub.charAt(0);
                        
                        tagnumber++;
                        dic+=sub;
                    }
                    else 
                    {
                        while(j < data.length() && search !=-1)
                        {
                            j++;
                            sub = data.substring(i,j);
                            search=dic.lastIndexOf(sub);
                        }
                        String x  = sub.substring(0,sub.length()-1);

                        pos[tagnumber]=dic.length() - dic.lastIndexOf(x);
                        len[tagnumber]=x.length();
                        c[tagnumber]=sub.charAt(sub.length() - 1);
                        tagnumber++;
                        dic+=sub;
                    }
                    i=j;

                }
        
                
               for(int k = 0 ; k < tagnumber ; k++)
               {
                   System.out.println(pos[k] + " " + len[k]+" " + c[k] );
               }
                
            String newdata = "";
            i = 0;
            j = 0;
            for(int k = 0 ; k < tagnumber ; k ++)
            {
                if(pos[k] == 0)
                {
                    newdata +=c[k];
                }
                else 
                {
                    i = newdata.length()-pos[k];
                    j = i + len[k];
                    String y = newdata.substring(i,j);
                    newdata+=y;
                    newdata+=c[k];
                }
            }



            System.out.println(newdata);

    }
    
}
