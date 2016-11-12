package destiny.sorts;

import destiny.mover.Mover;

public class Spell {
    protected float percentCritic = 0.2f; // Default
    private int rechargeRound = 0; // Minimum round before re-use the spell
    protected int currentRound = 0; // Actual round counter
    protected Mover target;

    protected void setTarget(Mover mover) {
        this.target = mover;
    }
    public Mover getTarget() {
        return target;
    }

    public float getPercentCritic() {
        return this.percentCritic;
    }
    public void setPercentCritic(float percentCritic) {
        this.percentCritic = percentCritic;
    }

    public int getRechargeRound() {
        return this.rechargeRound;
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

    public void castOnTarget() {
        castOnTarget(target);
    }

    public void castOnTarget(Mover mover) {
        // TODO
        if (rechargeRound == 0) {
            // Spell peut être lancé directement

        } else {
            if (currentRound < rechargeRound) {
                // Ne peut PAS être lancé !
            } else {
                this.currentRound++;
            }
        }
    }

    @Override
    public String toString() {
        return "Attente: (" + currentRound + "/" + rechargeRound + ")";
    }
}