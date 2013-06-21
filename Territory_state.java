/*
 * Classname : Territory_state
 * 
 * Version information :
 *
 * This class represents the current state of a territory, 
 * that is, its owner, and the number of military units 
 * stacked on it.
 *
 * Date : Sat June 22, 2013
 * 
 */

class Territory_state{

    Player owner;
    int unitCount;

    /* This constructor function only assigns a territory to a Player. The
     * unitCount field must be set right after, since it is not
     * possible to have zero unit on a territory*/
    public Territory_state (Player initialOwner){
	owner = initialOwner;
	unitCount = 0;
    }

    public Territory_state (Player initialOwner, int initialUnitCount){
	owner = initialOwner;
	unitCount = initialUnitCount;
    }

    /*
     * Get methods
     */

    public Player get_owner() {
	return owner;
    }
    
    public int get_unitCount() {
	return unitCount;
    }

    /*
     * Set methods
     */
    
    private Territory_state set_owner(Player newOwner){
	owner = newOwner;
	return this;
    }

    private Territory_state set_unitCount(int newCount){
	unitCount = newCount;
	return this;
    }
}