/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Will
 */
public class PathFinder {
    private int[][] map;
    private Pair goal;

    public PathFinder(int[][] map){
        this.map = map;
    }
    
    
    public boolean checkPath(Pair potentialGoalPoint){
        int[][] visitedMap = deepCopy(this.map);
        this.goal = potentialGoalPoint;
        
        List<Node> queue = new ArrayList<Node>();
        queue.add(new Node(goal.getX(), goal.getY()));
        boolean pathIsGood = false;
        
        while(!queue.isEmpty()){
            Node current = queue.remove(0);
            if(queue.size() > 200000){
                break;
            }
            if(visitedMap[current.x][current.y] == 2){
                pathIsGood = true;
                break;
            }
            
            visitedMap[current.x][current.y] = -1;
            
            List<Node> neighbors = getNeighbors(current, visitedMap);
            queue.addAll(neighbors);
        }
        return pathIsGood;
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
    
    List<Node> getNeighbors(Node current, int[][] map){
        int up = current.y - 1;
        int down = current.y + 1;
        int left = current.x - 1;
        int right = current.x + 1;
        int width = map.length;
        int height = map[0].length;
        
        List<Node> neighbors = new ArrayList<Node>();
        
        if(up >= 0){
            if(map[current.x][up] != 1 && map[current.x][up] != -1){
                neighbors.add(new Node(current.x, up));
            }
        }
        if(down < height){
            if(map[current.x][down] != 1 && map[current.x][down] != -1){
                neighbors.add(new Node(current.x, down));
            }
        }
        if(left >= 0){
            if(map[left][current.y] != 1 && map[left][current.y] != -1){
                neighbors.add(new Node(left, current.y));
            }    
        }
        if(right < width){
            if(map[right][current.y] != 1 && map[right][current.y] != -1){
                neighbors.add(new Node(right, current.y));
            }
        }
        
        return neighbors;
    }
}
