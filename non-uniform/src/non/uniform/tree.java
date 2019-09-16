package non.uniform;

import java.util.Vector;

public class tree {

    
    node root ;
    int bits ;
    Vector<node> lenodes = new Vector<node>();
    Vector<node> nodes = new Vector<node>();
    
    public tree(node n ) {
        lenodes.clear();
        root = n;
    }    
    
    void checktree()
    {
        for(int i = 0 ; i < lenodes.size() ; i ++)
        {
            for(int j = i+1 ; j < lenodes.size() ; j ++)
            {
                node n1=lenodes.elementAt(i);
                node n2=lenodes.elementAt(j);
                checknode(n1 , n2);
            }
        }
        
        for(int i = 0 ; i < lenodes.size() ; i ++)
        {
            node no = lenodes.get(i);
            int sum  = 0 ;
            for(int j = 0 ; j < no.arr.size();j++)
            {
                sum+=no.arr.get(j);
            }
            no.ave=sum/no.arr.size();
            nodes.add(no);
        }
        lenodes=nodes;  
    }
    
    void checknode(node a , node b)
    {
        int d1 = 0 , d2 = 0 ;
        for(int i = 0 ; i < a.arr.size() ; i ++)
        {
            int num = a.arr.get(i);
            d1=Math.abs((num-a.ave));
            d2=Math.abs((num-b.ave));
            if(d1 > d2)
            {
                a.arr.remove(i);
                i--;
                b.arr.add(num);
            }
        }
        
        for(int i = 0 ; i < b.arr.size() ; i ++)
        {
            int num = b.arr.get(i);
            d1=Math.abs((num-a.ave));
            d2=Math.abs((num-b.ave));
            if(d1 < d2)
            {
                b.arr.remove(i);
                i--;
                a.arr.add(num);
            }
        }
    }
    
    void print()
    {
        for(int i = 0 ; i < lenodes.size() ; i ++)
        {
            node n = lenodes.get(i);
            
            System.out.println(n.level+ " " + n.ave);
            System.out.println(n.arr);
        }
    }
    
   
    void bulid(node i )
    {
        
        if(i.level == bits)
        {
            int sum = 0 ;
            for(int k = 0 ; k < i.arr.size() ; k ++)
            {
                sum+=i.arr.get(k);
            }
            i.ave=(sum/i.arr.size());
            lenodes.add(i);
            return;
            
        }
        int sum = 0 ;
        for(int k = 0 ; k < i.arr.size() ; k ++)
        {
            sum+=i.arr.get(k);
        }
        
        i.ave=(sum/i.arr.size());
        
        node n1 = new node(i.level+1);
        node n2 = new node(i.level+1);
        
        for(int k = 0 ; k < i.arr.size() ; k++)
        {
            int x = i.arr.get(k);
            if(x <= i.ave)
            {
                n1.arr.add(x);
            }
            else 
            {
                n2.arr.add(x);
            }
        }
    
        i.rnode=n1;
        i.lnode=n2;
    
        bulid(i.rnode);
        bulid(i.lnode);
    }
    
 
}
