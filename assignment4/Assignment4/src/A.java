
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class A {
    
    int field[][] = {
                    {0,1,0,1,0},  
                    {0,0,0,1,0},
                    {1,0,0,0,0},
                    {0,0,1,0,0},
                    {0,0,0,0,0},
                    };
    
     Node end = new Node(4,4);
    
    public void main (String arg[]){
       
       
        
        List list = new ArrayList();
        List list1 = new ArrayList();
       
        Node A = new Node();
        list1.add(A);
        PQnode init;
        init = new PQnode(A,list1,h(A));
        list.add(init);
        while(!list.isEmpty()){
            Node cur = (Node)list.remove(0);
            if(cur.getx())
        }
        
        
        
    }
    
    public int h(Node cur){
       return Math.abs(cur.getx()-end.getx()) + Math.abs(cur.gety()-end.gety());
   }
  
    
    public Node[] check(Node x){
        // this will check the adj nodes
     return ;   
    }
    
}
