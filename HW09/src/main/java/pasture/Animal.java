package pasture;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public abstract class Animal extends Creature {

    protected int MOVE_DELAY;
    protected int DIE_DELAY;
    protected int HUNGRY_DELAY;
    protected long GROWUP_DELAY;

    protected int moveDelay;
    protected int dieDelay;
    protected int hungryDelay;
    protected long growUpDelay;
    protected int sight;
    protected Point lastMove = null;

    protected void wasBorn(Pasture pasture, boolean alive) {
        this.pasture = pasture;
        this.alive = alive;
        moveDelay = MOVE_DELAY;
        dieDelay = DIE_DELAY;
        reproduceDelay = REPRODUCE_DELAY;
        hungryDelay = HUNGRY_DELAY;
        growUpDelay = 0;
    }

    public void tick() {
        if (!alive) return;
        grow();
        if (dieDelay == 0) {
            this.die();
            return;
        }
        if (reproduceDelay == 0 && growUpDelay > GROWUP_DELAY) reproduce();
        if (moveDelay == 0) {
            Point bestMove = getBestMove();
            if (bestMove != null) pasture.moveEntity(this, bestMove);
            moveDelay = this.MOVE_DELAY;
            if (hungryDelay == 0) eat(bestMove);
        }
    }

    protected void eat(Point target) {
        Collection<Entity> list = pasture.getEntitiesAt(target);
        if (list != null) {
            for (Entity e : list) {
                if (this.isFood((Creature) e)) {
                    ((Creature) e).die();
                    dieDelay = DIE_DELAY;
                    hungryDelay = HUNGRY_DELAY;
                }
            }
        }
    }

    protected void grow() {
        moveDelay--;
        dieDelay--;
        if (reproduceDelay > 0) reproduceDelay--;
        if (hungryDelay > 0) hungryDelay--;
        growUpDelay++;
    }

    protected abstract boolean isFood(Creature creature);

    protected abstract Point getBestMove();
}
