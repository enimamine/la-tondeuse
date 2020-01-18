# la-tondeuse
exercide de la tondeuse qui tond le gazon !

La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) 
et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N,E,W,S). 

Par exemple, la position de la tondeuse peut être « 0, 0, N », ce qui signifie qu'elle se situe dans le coin inférieur gauche de la pelouse, et orientée vers le Nord. 

« D » et « G » font pivoter la tondeuse de 90° à droite ou à gauche respectivement, sans la déplacer. 

« A » signifie que l'on avance la tondeuse d'une case dans la direction à laquelle elle fait face. 

Si la position après mouvement est en dehors de la pelouse, la tondeuse ne bouge pas, conserve son orientation et traite la commande suivante. 

on lui fournit un fichier d'entrée construit comme suit : 

● La première ligne correspond aux coordonnées du coin supérieur droit de la pelouse, celles du coin inférieur gauche sont supposées être (0,0) 

● La suite du fichier permet de piloter toutes les tondeuses qui ont été déployées.

 Chaque tondeuse a deux lignes la concernant : 
 
● la première ligne donne la position initiale de la tondeuse, ainsi que son orientation. 

● la seconde ligne est une série d'instructions, ce qui signifie que la seconde tondeuse ne bouge que lorsque la première a exécuté intégralement sa série d'instructions. 


Lorsqu'une tondeuse achève une série d'instruction, elle communique sa position et son orientation. 

TEST Le fichier suivant est fourni en entrée : 
5 5 

1 2 N 

GAGAGAGAA 

3 3 E 

AADAADADDA

On attend le résultat suivant (position finale des tondeuses) : 

1 3 N 

5 1 E
