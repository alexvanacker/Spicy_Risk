/**
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
 **/

package fr.spicyrisk.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Territory {      

	private final int identifier;
	private final ArrayList<Territory> connexedTerritories;
	private Player owner;
	private int unitCount;
	
	private final Random random = new Random();

	public Territory(int id, ArrayList<Territory> neighbours, Player initialOwner, int initialUnitCount){
		identifier = id;
		connexedTerritories = neighbours;
		owner = initialOwner;
		unitCount = initialUnitCount;
	}

	public Territory(int id, Player initialOwner, int initialUnitCount){
		this(id, new ArrayList<Territory>(), initialOwner, initialUnitCount);
	}
	
	public Territory(int id){
		this(id, new ArrayList<Territory>(), null, 0);
	}
	
	public int getIdentifier(){
		return identifier;
	}

	public ArrayList<Territory> getConnexTerritories(){
		return connexedTerritories;
	}

	public Player getOwner() {
		return owner;
	}

	public int getUnitCount() {
		return unitCount;
	}

	/**
	 * 
	 * Rolling a dice
	 * 
	 * @return
	 */
	private int rollOneDice(){
		return (1 + (int)(Math.floor(random.nextDouble()*6)));
	}

	/**
	 * Rolling dices for an attacker or a defender for one round of
	 * fight
	 * 
	 * @param numberOfDice
	 * @return
	 */
	private int[] castTurnDices(int numberOfDice){
		int count = 0;
		int[] strength = new int[numberOfDice];
		while (count < numberOfDice) {
			strength[count] = rollOneDice();
			count++;
		};
		Arrays.sort(strength);
		return strength;
	}

	/**
	 * Returns the number of defence losses and the number of attack
	 * losses
	 * 
	 * @param defenceRolls
	 * @param attackRolls
	 * @return
	 */
	private int[] resultOfAttack(int[] defenceRolls, int[] attackRolls){
		int[] losses ={0,0};
		int defenceSize = defenceRolls.length;
		int attackSize = attackRolls.length;
		int remainingFights = Math.min(defenceSize,attackSize);
		int doneFights= 0;
		while(doneFights < remainingFights-1){
			if(defenceRolls[defenceSize-doneFights]>attackRolls[attackSize-doneFights]){
				losses[1]++;
			}
			else if(defenceRolls[defenceSize-doneFights]<attackRolls[attackSize-doneFights]){
				losses[0]++;
			}
			doneFights++;
		}
		return losses;
	}
	
	/**
	 * Verifies if Player has enough soldiers on its territory to
	 * initiate such an attack
	 * @param numberOfAttackers
	 * @return
	 */
	public boolean isAttackCorrect(int numberOfAttackers){
		return (numberOfAttackers <= this.getUnitCount())&&(numberOfAttackers > 1);
	}

	public void defend(Player attacker, int numberOfAttackers){
		//Implement the fighting pattern
		boolean endOfFight = false;
		int tempNumberOfDefenders = this.getUnitCount();
		int defendersInRound ;
		// I dont know if the next line is important, 
		// or if I should directly use numberOfAttackers
		int tempNumberOfAttackers = numberOfAttackers;
		int attackersInRound ;
		while (!endOfFight) {
			defendersInRound = Math.min(tempNumberOfDefenders,3);
			attackersInRound = Math.min(tempNumberOfAttackers,3);
			int[] defendersStrength = castTurnDices(defendersInRound);
			int[] attackersStrength = castTurnDices(attackersInRound);
			int[] losses = resultOfAttack(defendersStrength,attackersStrength);
			tempNumberOfDefenders -= losses[0];
			tempNumberOfAttackers -= losses[1];
			endOfFight = (tempNumberOfDefenders>0)&&(tempNumberOfAttackers>0);
		}
		if(tempNumberOfDefenders == 0){
			//Defense lost, the territory now belongs to the attacker

			//We have to change the table containing the territories owned by the defensor, and by the attacker.

			//We change the owner of this territory
			owner = attacker;
			unitCount = tempNumberOfAttackers;
		}
		else{
			//Defence won, we just set the units count to the new value
			unitCount = tempNumberOfDefenders;
		};
	}
}
