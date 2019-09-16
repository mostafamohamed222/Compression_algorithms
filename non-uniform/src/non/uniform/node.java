package non.uniform;

import java.util.ArrayList;

public class node {
    
    ArrayList<Integer> arr = new ArrayList<Integer>();
    int ave  ;
    node rnode;
    node lnode;
    int level ;
    public node() {
        rnode=null;
        lnode=null;
        ave=0;
        level = 0;
    }

    public node(int level) {
        this.level = level;
    }
}
