/**
 * 
 * AI.java
 * 
 * Version information :
 *
 * This class gathers the methods for an Artificial Intelligence to compute the moves, blabla.
 *
 * Date : Sat June 22, 2013
 * 
 **/

package fr.spicyrisk.game;

public class AI extends Player {

	public AI(String playerName) {
		super(playerName);
	}

	/**
	 * 
	 * Evaluate the probability of winning if territory 1 attacks territory 2
	 * 
	 * @param territory1
	 * @param territory2
	 * @return
	 */
	public double getWinProbability(Territory territory1, Territory territory2)
	{
		//TODO: not implemented yet
		//WARNING : FOR NOW THIS IS ONLY BULLSHIT and will always return 1/2

		//to implement, a lot to think about this
		//see the Wiki (the link on the Win win strategy)
		
		/*
		int nArmy1 = territory1.getUnitCount();
		int nArmy2 = territory2.getUnitCount();
		 */
		
		return 0.5;
	}

	/**
	 * 
	 * This method returns an array of doubles, of the same size as the size of territory.connexTerritories
	 * the j-th element of this array is the probability of winning the j-th connex territories of territory
	 * 
	 * @param territory
	 * @return
	 */
	public double[] getWinNeighboursProbabilities(Territory territory)
	{
		int nNeighbours = territory.getConnexTerritories().size();

		double[] winNeighboursProbabilities = new double[nNeighbours];

		for(int n=0; n<nNeighbours; n++)
		{
			winNeighboursProbabilities[n]=getWinProbability(territory, territory.getConnexTerritories().get(n));
		}

		return winNeighboursProbabilities;
	}

}