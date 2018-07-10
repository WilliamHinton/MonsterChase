/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

/**
 *
 * @author Will
 */

//Used in search algorithms
public class Node implements Comparable<Node>{
    int x;
    int y;
    int finalCost = 0; //incremented continuously
    int heuristicCost = 0;
    Node parent;
    
    
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Node o){
        if((o.heuristicCost + o.finalCost) < (this.heuristicCost + o.finalCost)){
            return -1;
        }
        else if((o.heuristicCost + o.finalCost) < (this.heuristicCost + o.finalCost)){
            return 1;
        }
        else
            return 0;
    }
}
