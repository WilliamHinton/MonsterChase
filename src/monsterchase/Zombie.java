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
public class Zombie implements Monster{
    String myName;
    @Override
    public void move(){
        System.out.println(this.myName + " moved.\n");
    }
    
    public void getPos(){
        System.out.println(this.myName + " position is here.\n");
    }
    
    public Zombie(String name){
        myName = name;
    }
}
