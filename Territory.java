// {{{
/*
 * Classname : Territory
 * 
 * Version information :
 *
 * This class represents the atomic territory unit.  Territories
 * are the nodes in the game map graph.  
 * 
 * We give it a unique identifier (int).  
 *
 * connexTerritories are the neighbour nodes in the map graph : 
 * this field represents the vertices in the graph.
 *  
 * The state of the territory states which player owns it, and how
 * many units are located there.
 *
 * Date : Sat June 22, 2013
 * 
 */
// }}}
class Territory {      
    
    int identifier;
    Territory[] connexTerritories;
    Territory_state territoryState;

    public Territory(int id, Territory[] neighbours, Territory_state initialState){
	identifier = id;
	connexTerritories = neighbours;
	territoryState = initialState;
    }

    //Get methods
    public int getIdentifier(){
	return identifier;
    }

    public Territory[] getConnexTerritories(){
	return connexTerritories;
    }

    public Territory_state getTerritoryState(){
	return territoryState;
    }
    //Set method for the state. The other fields do not need to be changed after having been instanciated by the constructor function
    private Territory setState(Territory_state new_state){
	territoryState = new_state;
	return this;
    }

}
