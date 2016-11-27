# Projet de Java M1

[![Build Status](https://travis-ci.org/bLandais/projet-java.svg?branch=master)](https://travis-ci.org/bLandais/projet-java) [![Coverage Status](https://coveralls.io/repos/github/bLandais/projet-java/badge.svg?branch=master)](https://coveralls.io/github/bLandais/projet-java?branch=master)

Rendu de projet le 28 Novembre à 8h. Envoyer par mail le projet contenant:

- Un .zip ou un .tar une archive `StudentName1_StudentName2` 
    - Un court rapport
    - Un dossier de source avec que les *.java.
    - Tous les autres éléments requis pour executer le projet (fichier d'initialisation).
    
## Règles du jeu

* Jeu solo
* 12 paliers
* Des monstres qui spawnent sur le chemin et qu'il faut combattre !
* Des sorts
* Un boss

### Lancer une partie :

* Lancer le programme
* Sélectionner le type de jeu (New game : n , A partir d'un fichier de sauvegarde : y )
* Choisir son nom (si Nouvelle partie)
* Le jeu commence

#### Deroulement de la partie

* **BOUCLE** : ( A chaque execution succeptible de modifier la vie : rappel de la vie des combattants)
    * Rencontre avec le monstre
    * Selectionner l'action à réaliser ( 0 : attaque , 1: soin , 2: boost de degats pour les 2 tours suivants) (Utilisation de l'inventaire "l"
    possible uniquement pendant le tour du joueur et avant de sélectionner une action)
    * Affichage des conséquences de l'action ( si 0 : Perte de pdv du monstre , si 1: gain de pdv du joueur , si 2: augmentation de l'attaque du joueur pour 2 tours)
    * Tour du Monstre
* **SORTIE DE BOUCLE** si :
    * Monstre vaincu (retour dans une nouvelle boucle avec nouveau monstre)
    * Joueur Vaincu : "Game Over" --> Fermeture du programme

##### Présentation du Joueur, des Monstres , Sorts , Inventaire

* **JOUEUR**:
    * PDV de base : 200
    * Defense de base: 200
    * Degats de base : 100%


* **MONSTRES ( Monstre 1 au Monstre 11)**:
    * PDV : 120 Pv ( +10 Pv par monstre suivant par rapport au précédent )
    * Défense de base : 200
    * Dégâts de base : 100%

* **BOSS**:
    * PDV : 400 PV
    * Chance d'esquive : 20%
    * Chance de CC : 33%
    * Chance d'echec critique : 3%
    * Chance de stun : 7%
    * Regénaration automatique : +20% des pdv max tous les 10 tours

* **SORTS JOUEUR**:
    * Attaque : Utilisable chaque tour ! Enleve 100PDV au monstre de base
    * Soin : Temps de recharge de 3 tours avant réutilisation
        * Effet : Soigne le joueur à hauteur de 60 PDV

    * Soutiens: Utilisable chaque tour
        * Effet : Augmente les degats de 10% jusque la fin du combat avec le monstre actuel


* **INVENTAIRE** :

| Quantité | Nom | Description |
| --- | ---| --- |
| x2   | POTIONS FULL SOIN | |
| x3   | POTIONS DEFENSE   | Réduit les degats subis de 50% pendant l'intégralité du combat |
| x3   | POTIONS ATTAQUE   | Augmente les degats infligés de 50% pendant l'intégralité du combat |
| x3   | POTIONS RESET | Reinitialise les compteurs de recharges des sorts spéciaux |
| x1   | POTION SURPRISE | |