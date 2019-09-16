package huffman;

public class tree {
    
    node root;
    static String [] code = new String[128];
    
    public tree() {
        root = null;
    }
    
    public tree(node root) {
        this.root = root;
    }
   
    public static void dfs(node i , String x)
    {
        if(i == null)
        {
            return;
        }
        if(i.c>=1 && i.c<=127)
        {
            code[i.c]=x;
            //System.out.println(i.data+ " " + i.c +" " + x);
        }
        dfs(i.rnode,x+'1');
        dfs(i.lnode,x+'0');
    }    
}
