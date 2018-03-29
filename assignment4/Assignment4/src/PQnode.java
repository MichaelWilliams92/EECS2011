
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
public class PQnode {
    private Node node;
    private List list = new ArrayList();
    private static int priority;
    
    PQnode(Node x, List y, int p){
        node = x;
        for(int i = 0; i<y.size();i++){
            list.add(y.get(i));
        }
        priority = p;
    } 
    
    public Node getNote(){
        return node;
    }
    
    public List getlist(){
        return list;
    }
    
    public int getpriority(){
        return priority;
    }
}
