/**
 * Classname : Continents
 * 
 * Version information :
 *
 * This class represents the continents, which is a sub-graph of the map.
 * 
 * We give it a unique identifier (int).  
 *
 *
 * Date : Sat June 22, 2013
 * 
 **/

package fr.spicyrisk.game;

import java.util.ArrayList;

public class Continent {
	
	private final String name;
	private final ArrayList<Territory> territories;
	
	public Continent(String name, ArrayList<Territory> territories){
		this.name = name;
		this.territories = territories;
	}
	
	public Continent(String name){
		this(name, new ArrayList<Territory>());
	}
	
	public String getName(){
		return name;
	}
	
	public void addTerritory(Territory territory){
		territories.add(territory);
	}
}
