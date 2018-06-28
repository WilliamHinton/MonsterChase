/*
    Test monster. Will expand upon later.
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
