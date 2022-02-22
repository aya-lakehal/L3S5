# -projet-2021 
# L3 MIAGE G2
# Binomes :  

- Mame aby magatte Niang
- Aya LAKEHAL
- Chaimae Jedda
## Livrable 1

# Representation du Sujet
- Ce projet représente une compétition sportive est définie par un ensemble de matchs (Match) joués entre compétiteurs (Competitor).
[Le sujet 2021](https://www.fil.univ-lille1.fr/~quinton/coo/projet/competitions.pdf)


## Installation 
Pour installer le projet et ses dépendances, ainsi que l'archive jar exécutable, assurez vous d'être connecté au VPN de l'Université et lancez la commande suivante dans le répertoire de votre choix :
`git clone https://gitlab-etu.fil.univ-lille1.fr/lakehala/coo_project.git` 

## Exécution
### 1- Execution sur Eclipse
Pour executer la classe principale sur eclipse, ouvrez cette dernière dans eclipse "Main.java" puis appuyez sur l'onglet "Run"->"Run.
### 1- Execution sur un terminal
Pour cette execution il faudra le faire à l'aide de la commande make make doc et make main


### 2- Choix Conception

On a tout dabord garder une idée de la premiere version à quelques changements près puis on a du réflichir à une bonne prise de cette nouvelle type de Competition.
Pour on a créer une interface StrategyMaster afin que pour toute selection startégique choisis on aurait qu'à changer le code dans la classe concernée et ca nous permettrait d'en avoir autant de classes stratégiques que l'on voudra.
En parallele on a une classe Master qui gerera la majeur partie de la bonne exécution du code.

Pour verifier ceci, vous pouvez dejà constater sur eclipse au niveau de la console pour une trace d'execution d'une competition master avec 16 joueurs, de 4 poules de 4 joueurs :

``` bash
****** A master game ******
******* Une Poule *******
Blastoff vs Drift --> Blastoff wins! 
Blastoff vs Lynx --> Lynx wins! 
Blastoff vs Catalyst --> Catalyst wins! 
Drift vs Blastoff --> Blastoff wins! 
Drift vs Lynx --> Lynx wins! 
Drift vs Catalyst --> Drift wins! 
Lynx vs Blastoff --> Lynx wins! 
Lynx vs Drift --> Drift wins! 
Lynx vs Catalyst --> Lynx wins! 
Catalyst vs Blastoff --> Blastoff wins! 
Catalyst vs Drift --> Catalyst wins! 
Catalyst vs Lynx --> Catalyst wins! 

*** Ranking ***
Lynx - 4
Blastoff - 3
Catalyst - 3
Drift - 2
******* Une Poule *******
Raven vs Midas --> Midas wins! 
Raven vs George --> George wins! 
Raven vs François --> Raven wins! 
Midas vs Raven --> Raven wins! 
Midas vs George --> Midas wins! 
Midas vs François --> François wins! 
George vs Raven --> Raven wins! 
George vs Midas --> George wins! 
George vs François --> François wins! 
François vs Raven --> François wins! 
François vs Midas --> Midas wins! 
François vs George --> George wins! 

*** Ranking ***
Midas - 3
George - 3
François - 3
Raven - 3
******* Une Poule *******
Vita vs Slimane --> Vita wins! 
Vita vs Julie --> Vita wins! 
Vita vs Louis --> Louis wins! 
Slimane vs Vita --> Vita wins! 
Slimane vs Julie --> Slimane wins! 
Slimane vs Louis --> Louis wins! 
Julie vs Vita --> Julie wins! 
Julie vs Slimane --> Julie wins! 
Julie vs Louis --> Julie wins! 
Louis vs Vita --> Louis wins! 
Louis vs Slimane --> Louis wins! 
Louis vs Julie --> Julie wins! 

*** Ranking ***
Julie - 4
Louis - 4
Vita - 3
Slimane - 1
******* Une Poule *******
Lucas vs Julien --> Lucas wins! 
Lucas vs Antony --> Antony wins! 
Lucas vs Paul --> Lucas wins! 
Julien vs Lucas --> Julien wins! 
Julien vs Antony --> Antony wins! 
Julien vs Paul --> Julien wins! 
Antony vs Lucas --> Lucas wins! 
Antony vs Julien --> Julien wins! 
Antony vs Paul --> Antony wins! 
Paul vs Lucas --> Paul wins! 
Paul vs Julien --> Julien wins! 
Paul vs Antony --> Antony wins! 

*** Ranking ***
Antony - 4
Julien - 4
Lucas - 3
Paul - 1
******* Un tournoi *******
Lynx vs Midas --> Lynx wins! 
Julie vs Antony --> Antony wins! 
Lynx vs Antony --> Lynx wins! 

*** Ranking ***
Lynx - 6
Antony - 5
Julie - 4
Midas - 3


Lynx Wins The Master!

``` 

