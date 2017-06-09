package pasture;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public abstract class Creature implements Entity{
    protected int REPRODUCE_DELAY;
    protected Pasture pasture;
    protected int reproduceDelay;
    protected boolean alive = true;

    public void die() {
        pasture.removeEntity(this);
        this.alive = false;
    }

    public abstract Creature create();

    public void reproduce() {
        Creature creature = this.create();
        Point neighbour = getRandomMember(pasture.getFreeNeighbours(this));
        if (neighbour == null) return;
        pasture.addEntity(creature, neighbour);
        reproduceDelay = REPRODUCE_DELAY;
    }

    protected <X> X getRandomMember(Collection<X> c) {
        if (c.size() == 0) return null;
        Iterator<X> it = c.iterator();
        int n = (int) (Math.random() * c.size());
        while (n-- > 0) {
            it.next();
        }
        return it.next();
    }
}
