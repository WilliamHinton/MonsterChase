/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author Will
 */
public class PathFinderAStar {
    private int[][] map;
    Node goalNode;
    Node startNode;
    PriorityQueue<Node> open = new PriorityQueue<>();
    boolean[][] closed;
    Node[][] grid;
    
    
    public PathFinderAStar(int [][] map, Pair start, Pair goal){
        this.map = deepCopy(map);
        this.goalNode = new Node(goal.getX(),goal.getY());
        this.startNode = new Node(start.getX(),start.getY());
        this.grid = new Node[map.length][map[0].length];
        this.closed = new boolean[map.length][map[0].length];
    }
    
    //cost for the time-being will remain 1
    void checkAndUpdateCost(Node n, Node current, int cost){
        if(n == null || closed[n.y][n.x]){
            return;
        }
        
        int newFinalCost = n.heuristicCost + cost;
        boolean inOpen = open.contains(n);
        
        if(!inOpen || newFinalCost < n.finalCost){
            n.finalCost = newFinalCost;
            n.parent = current;
            if(!inOpen){
                open.add(n);
            }
        }
        return;
    }
    
    public boolean doesPathExist(){
        System.out.println(map[0].length + "," + map.length + "-- " + grid[0].length + ", " + grid.length);
        open.add(startNode);
        Node current;
        int cost = 1;
        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[0].length; x++){
                if(map[y][x] != 1)
                    grid[y][x] = new Node(x, y);
            }
        }
        
        
        
        while(true){
            Node n;
            current = open.poll();
            if(current==null)
                break;
            current.heuristicCost = estimateHeuristic(goalNode, current);
            closed[current.y][current.x] = true;
            
            if((current.x == goalNode.x) && (current.y==goalNode.y)){
                return true;
            }
            //left
            if(current.x - 1 >= 0){
                n = grid[current.y][current.x-1];
                checkAndUpdateCost(n, current, current.finalCost+cost);
            }
            //right
            if(current.x + 1 < grid[0].length){
                n = grid[current.y][current.x+1];
                checkAndUpdateCost(n, current, current.finalCost+cost);
            }
            //up
            if(current.y - 1 >= 0){
                n = grid[current.y-1][current.x];
                checkAndUpdateCost(n, current, current.finalCost+cost);
            }
            //down
            if(current.y + 1 < grid.length){
                n = grid[current.y+1][current.x];
                checkAndUpdateCost(n, current, current.finalCost+cost);
            }
        }
        System.out.println("wtf");
        return false;
    }
    
    //estimating using Manhattan Distance
    private int estimateHeuristic(Node goal, Node current){
        int heuristic = Math.abs(goal.x - current.x) + Math.abs(goal.y - current.y);
        
        return heuristic;
    }
    
    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
