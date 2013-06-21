// {{{
/*
 * Classname : Player
 * 
 * Version information :
 *
 * This class represents players.
 * Each player has a name
 *
 * Date : Sat June 22, 2013
 * 
 */
// }}}

class Player{

    String name;

    public Player(String playerName){
	name = playerName;
    }

    public String getName(){
	return name;
    }
}
