package destiny.sorts;

import destiny.mover.Mover;

public class Spell {
    protected float percentCritic = 0.2f; // Default
    private int rechargeRound = 0; // Minimum round before re-use the spell
    protected int currentRound = 0; // Actual round counter

    public float getPercentCritic() {
        return this.percentCritic;
    }

    public int getRechargeRound() {
        return this.rechargeRound;
    }

    public void setPercentCritic(float percentCritic) {
        this.percentCritic = percentCritic;
    }

    /**
     * Nombre de tours avant de pouvoir réutiliser le sort
     * Si le sort est toujours utilisable, recharge est à zéro.
     * @param rechargeRound     Nombre de tours avant recharge
     */
    public void setRechargeRound(int rechargeRound) {
        if(rechargeRound < 0)
            this.rechargeRound = 0;
        else
            this.rechargeRound = rechargeRound;
    }

    public void castOnMover(Mover mover) {
        this.currentRound++;
    }

    @Override
    public String toString() {
        return "Attente: (" + currentRound + "/" + rechargeRound + ")";
    }
}