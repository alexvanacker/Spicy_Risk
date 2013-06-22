// {{{
/*
 * Classname : AI
 * 
 * Version information :
 *
 * This class gathers the methods for an Artificial Intelligence to compute the moves, blabla.
 *
 * Date : Sat June 22, 2013
 * 
 */
// }}}

class AI extends Player {
	
	//Evaluate the probability of winning if territory 1 attacks territory 2
	private double getWinProbability(Territory territory1, Territory territory2)
	{
		
		//WARNING : FOR NOW THIS IS ONLY BULLSHIT and will always return 1/2
		
		//to implement, a lot to think about this
		//see the Wiki (the link on the Win win strategy)
		
		int nArmy1 = territory1.getTerritoryState().getUnitCount();
		int nArmy2 = territory1.getTerritoryState().getUnitCount();
		
		return 0.5;
	}
	
	//This method returns an array of doubles, of the same size as the size of territory.connexTerritories
	//the j-th element of this array is the probability of winning the j-th connex territories of territory
	private double[] getWinNeighboursProbabilities(Territory territory)
	{
		Territory[] connexTerritories = territory.getConnexTerritories();
		int nNeighbours = Array.size(connexTerritories);
		
		double[] winNeighboursProbabilities = new double[nNeighbours];
		
		for(int n=0; n<nNeighbours; n++)
		{
			winNeighboursProbabilities[n]=getWinProbability(territory, connexTerritories[n]);
		}
		
		return winNeighboursProbabilities;
	}
	
}