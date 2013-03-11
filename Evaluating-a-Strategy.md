## Objective : Evaluate a "payoff for each strategy".

## Two steps :
1. Evaluate a strategy without taking into account other players 
2. Evaluate a strategy taking into account other players

## 1. Evaluate a strategy ?
Benefit between two states ? 

### Function of : 
* Probability of that strategy working (if 0.5 % chance of taking all the map in one turn, don't try that baby).
* delta total troups
* potential reinforcements for the next turn. This must (later) be ponderated by the probability of keeping it : ie. evaluate if there are two many soldiers that can break the state. 
* obtention of a reinforcment card
* (later) delta next turn reinforcement and total troups of the other players ponderated by a coefficient of agressivity of the player, other players, (very later) alliances.

### How to aggregate this information
Well a simple thing to do would be to make a weighted sum (weights coefficient chosen, from aggressive to very conservative...). But we can think ideas like the social choice theory and non linear utility functions ... not a pro on that.
This way => we have a score for each strat. Now we just take the one with higher score. 
Note : we don't want to test all strategies so it would be interesting to rapidely delete the ones with low probabilities.

## 2. Evaluate a strategy taking into account other players
Again two steps :
1. Knowing of other player's strategy
(which zone is interesting for which player ? aggressivity of other players...)
2. Use this knowledge
Compute an analogue (to first part) scores for other players. Keep the one's with high probability.
Now what we have belongs to game theory : should check something about Nash equilibrium and pareto optimum in dynamic games with partial information and memory...

