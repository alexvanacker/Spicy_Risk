/**
 * Classname : Player
 * 
 * Version information :
 *
 * This class represents players.
 * Each player has a name
 *
 * Date : Sat June 22, 2013
 * 
 **/

package fr.spicyrisk.game;

import java.util.ArrayList;

public class Player{

	private final String name;

	private ArrayList<Territory> territories;

	public Player(String playerName){
		name = playerName;
	}

	public String getName(){
		return name;
	}

	public void addTerritory(Territory territory){
		territories.add(territory);
	}

	public void removeTerritory(Territory territory){
		territories.remove(territory);
	}
}
