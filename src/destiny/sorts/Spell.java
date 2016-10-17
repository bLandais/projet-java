package destiny.sorts;

import destiny.mover.Mover;

public abstract class Spell {
    protected float percentCritic = 0.2f; // Default
    protected int rechargeRound = 3; // Minimum round before re-use the spell

    public float getPercentCritic() { return this.percentCritic; }
    public int getRechargeRound() { return this.rechargeRound; }

    public void setPercentCritic(float percentCritic) { this.percentCritic = percentCritic; }
    public void setRechargeRound(int rechargeRound) { this.rechargeRound = rechargeRound; }

    public abstract void castOnMover(Mover mover);
}
