package game_elements;

import game_elements.cases.Case;

public class Plateau {
    private Case[] cases;

    public Plateau(int size) {
        cases = new Case[size];
    }

    public void generate() {
        // TODO Generation du plateau (random ? à la main ?)
    }
}
