/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Node {
    private int x;
    private int y;
    
    
    Node(){
        x = 0;
        y = 0;
    }
    
    Node(int i, int j){
        x = i;
        y = j;
    }
    
    public void setx(int i){ 
        x = i;
    }
    
    public void sety(int i){
        y = i;
    }
    
    public int getx(){
        return x;
    }
    
    public int gety(){
        return x;
    }
    
}
