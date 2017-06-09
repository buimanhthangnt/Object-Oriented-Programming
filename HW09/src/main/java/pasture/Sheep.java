package pasture;

import javax.swing.*;
import java.awt.*;

public class Sheep extends Animal {
    private static ImageIcon image = new ImageIcon(Pasture.class.getResource("/sheep.gif"));
    public static int population = 0;

    public Sheep(Pasture pasture, boolean alive) {
        MOVE_DELAY = 3;
        DIE_DELAY = 160;
        REPRODUCE_DELAY = 150;
        HUNGRY_DELAY = 30;
        GROWUP_DELAY = 220;
        sight = 5;

        this.wasBorn(pasture, alive);
    }

    public boolean isFood(Creature creature) {
        return creature instanceof Grass;
    }

    public Point getBestMove() {
        SheepBrain brain = new SheepBrain();
        return brain.getBestMove(pasture, this);
    }

    public Sheep create() {
        return new Sheep(pasture, true);
    }

    public boolean isCompatible(Entity otherEntity) {
        if (otherEntity instanceof Grass) return true;
        return false;
    }

    public ImageIcon getImage() {
        return image;
    }
}
