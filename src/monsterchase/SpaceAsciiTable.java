/*
    Gives corresponding ASCII characters for space types in order to render the map in text
 */
package monsterchase;

import java.util.HashMap;

/**
 *
 * @author Will
 */
public class SpaceAsciiTable extends HashMap<SpaceType, String>{
    public SpaceAsciiTable(){
        this.put(SpaceType.OPEN, ".");
        this.put(SpaceType.CLOSED, "■");
        this.put(SpaceType.GOAL, "!");
        this.put(SpaceType.PLAYER, "+");
        this.put(SpaceType.ZOMBIE, "x");
        this.put(SpaceType.ERROR, "#");
    }
    
}
