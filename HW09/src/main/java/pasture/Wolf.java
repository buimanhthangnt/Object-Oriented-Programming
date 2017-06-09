package pasture;

import javax.swing.*;
import java.awt.*;

public class Wolf extends Animal {
    private static ImageIcon image = new ImageIcon(Pasture.class.getResource("/wolf.gif"));
    static int population = 0;

    Wolf(Pasture pasture, boolean alive) {
        MOVE_DELAY = 3;
        DIE_DELAY = 120;
        HUNGRY_DELAY = 30;
        REPRODUCE_DELAY = 350;
        GROWUP_DELAY = 600;
        sight = 7;
        this.wasBorn(pasture, alive);
    }

    public boolean isFood(Creature creature) {
        return creature instanceof Sheep;
    }

    public Point getBestMove() {
        WolfBrain brain = new WolfBrain();
        return brain.getBestMove(pasture, this);
    }

    public Wolf create() {
        return new Wolf(pasture, true);
    }

    public boolean isCompatible(Entity otherEntity) {
        return otherEntity instanceof Sheep || otherEntity instanceof Grass;
    }

    public ImageIcon getImage() {
        return image;
    }
}
