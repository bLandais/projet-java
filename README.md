# Projet de Java M1

[![Build Status](https://travis-ci.org/bLandais/projet-java.svg?branch=master)](https://travis-ci.org/bLandais/projet-java) [![Coverage Status](https://coveralls.io/repos/github/bLandais/projet-java/badge.svg?branch=master)](https://coveralls.io/github/bLandais/projet-java?branch=master)


## Règles du jeu

* Jeu solo
* 12 paliers
* Des monstres qui spawnent sur le chemin et qu'il faut combattre !
* Des sorts
* Un boss

### Lancer une partie :

* Lancer le programme
* Sélectionner le type de jeu (New game : 1 , A partir d'un fichier de sauvegarde : 0 )
* Choisir son nom (si Nouvelle partie)
* Le jeu commence

#### Deroulement de la partie

* BOUCLE : ( A chaque execution succeptible de modifier la vie : rappel de la vie des combattants)
    * Rencontre avec le monstre
    * Selectionner l'action à réaliser ( 0 : attaque , 1: soin , 2: boost de degats pour les 2 tours suivants) (Utilisation de l'inventaire "I"
    possible uniquement pendant le tour du joueur et avant de sélectionner une action)
    * Affichage des conséquences de l'action ( si 0 : Perte de pdv du monstre , si 1: gain de pdv du joueur , si 2: ......)
    * Tour du Monstre
* SORTIE DE BOULCE si :
    * Monstre vaincu (retour dans une nouvelle boucle avec nouveau monstre)
    * Joueur Vaincu : "Game Over" --> Fermeture du programme

##### Présentation du Joueur, des Monstres , Sorts , Inventaire

*JOUEUR:
    *PDV de base : 200
    *chance d'esquive de base : 5%
    *chance de CoupCritique de base : 20% --> hausse des degats de 50%
    *chance d'echec critique de base: 5% --> echec de l'attaque


*MONSTRES ( Monstre 1 au Monstre 11):
    *PDV : 120 Pv ( +10 Pv par monstre suivant par rapport au précédent )
    *chance d'esquive : 5% (+1% par monstre suivant)
    *chance de coup critique : 10% (+2% par monstre suivant)
    *chance d'echec critique : 8% (-0,5% par monstre suivant)

*BOSS:
    *PDV : 300 PV
    *Chance d'esquive : 20%
    *Chance de CC : 33%
    *Chance d'echec critique : 3%
    *Chance de stun : 7%
    *Regénaration automatique : +20% des pdv max tous les 10 tours

*SORTS JOUEUR:
    * Attaque : Utilisable chaque tour ! Enleve 30PDV au monstre de base

    * Soin : Temps de recharge de 3 tours avant réutilisation .
        *Effet : Soigne le joueur à hauteur de 20% de ses PDV max

    * Boost : Temps de recharge de 4 tours avant réutilisation
        *Effet : Chance de CC portée à 100%
                 Chance d  EC portée à 0%
                 Chance de Double coup : 33%
                 Chance de triple coup : 10%
                 Chance de OS : 3% (sauf BOSS)

*INVENTAIRE:
    *2 POTIONS FULL SOIN
    *3 POTIONS DEFENSE : réduit les degats subis de 50% pendant l'intégralité du combat
    *3 POTIONS ATTAQUE : augmente les degats infligés de 50% pendant l'intégralité du combat
    *3 POTIONS RESET : reinitialise les compteurs de recharges des sorts spéciaux
    *1 POTION SURPRISE