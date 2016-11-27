package destiny.sorts;

import destiny.GameManager;
import destiny.mover.Mover;
import java.io.Serializable;

/**
 * La classe Spell est une classe mère de tous les sorts
 */
public class Spell implements Serializable {

    /**
     * The Percent critic.
     */
    protected float percentCritic = 0.2f; // Default
    private int rechargeRound = 0; // Minimum round before re-use the spell
    /**
     * The Current round.
     */
    protected int currentRound = 0; // Actual round counter
    /**
     * The Target.
     */
    protected Mover target;

    /**
     * Sets target.
     *
     * @param mover the mover
     */
    protected void setTarget(Mover mover) {
        this.target = mover;
    }

    /**
     * Gets target.
     *
     * @return the target
     */
    public Mover getTarget() {
        return target;
    }

    /**
     * Fonction qui est appelée lorsqu'un tour est passé
     * et qui incrémente le temps de recharge de tous les sorts.
     */
    public static void increaseRecharge(Mover mover) {
        if(mover != null) {
            for (Spell s : mover.getSorts()) {
                s.increaseCurrentRound();
            }
        }
    }

    public boolean canCastSpell() {
        if(currentRound < rechargeRound)
            return false;
        else
            return false;
    }

    /**
     * Gets percent critic.
     *
     * @return the percent critic
     */
    public float getPercentCritic() {
        return this.percentCritic;
    }

    /**
     * Sets percent critic.
     *
     * @param percentCritic the percent critic
     */
    public void setPercentCritic(float percentCritic) {
        this.percentCritic = percentCritic;
    }

    /**
     * Gets recharge round.
     *
     * @return the recharge round
     */
    public int getRechargeRound() {
        return this.rechargeRound;
    }

    /**
     * Fonction qui permet de mettre à jour le temps de recharge d'un sort
     */
    public void increaseCurrentRound() {
        this.setCurrentRound(currentRound + 1);
    }

    /**
     * Sets current round
     *
     * @param currentRound the current round
     */
    public void setCurrentRound(int currentRound) {
        if (currentRound > this.rechargeRound)
            currentRound = rechargeRound;

        this.currentRound = currentRound;
    }

    /**
     * Nombre de tours avant de pouvoir réutiliser le sort
     * Si le sort est toujours utilisable, recharge est à zéro.
     *
     * @param rechargeRound Nombre de tours avant recharge
     */
    public void setRechargeRound(int rechargeRound) {
        if(rechargeRound < 0)
            this.rechargeRound = 0;
        else
            this.rechargeRound = rechargeRound;
    }

    /**
     * Lance sur la cible courante du sort
     *
     * @return True si le sort peut être lancé
     */
    public boolean castOnTarget() {
        if (target == null)
            return false;
        return castOnTarget(target);
    }

    /**
     * Fonction qui permet de gérer le cooldown avant le lancement
     *
     * @param mover Mover qui sera la cible
     * @return Boolean : True s'il peut lancer le sort (cooldown ok), false sinon
     */
    public boolean castOnTarget(Mover mover) {
        if (rechargeRound == 0 || rechargeRound == currentRound) {
            // Spell peut être lancé directement
            currentRound = 0;
        } else {
            if (currentRound < rechargeRound) {
                // Ne peut PAS être lancé !
                System.out.println("|| Erreur : Impossible de lancer ce sort, rechargement...");
                return false;
            } else {
                this.currentRound++;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Attente: (" + currentRound + "/" + rechargeRound + ")";
    }
}