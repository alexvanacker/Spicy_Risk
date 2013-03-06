On suppose qu'on a à disposition (calculée d'une manière ou d'une autre) une matrice dite "élémentaire" (on peut l'appeler autrement) M qui vérifie

\(M_{i,j}\) donne la proba de gagner un combat à i attaquants contre j défenseurs

Disons que M est suffisamment grande pour qu'on ait toute l'info sur les combats possibles 
(typiquement M est de taille N*N avec N=50,60,100 ?! 20 ca me semble trop juste)

Maintenant, on se pose la question suivante : je suis au point 1, j'ai des vues sur le point P, et j'ai envie de tester la proba d'arriver en vie au point P par le chemin (1,2,...,P). L'idée c'est d'associer une note à ce chemin, et ensuite de comparer tous les chemins possibles de 1 à P et de prendre celui ac la meilleure note.