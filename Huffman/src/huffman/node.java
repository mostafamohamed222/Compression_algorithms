package huffman;

public class node {

     int data;
     char c ;
     node rnode;
     node lnode;

    public node(int data ) 
    {
        this.data = data;
        rnode=null;
        lnode=null;
    }
}
