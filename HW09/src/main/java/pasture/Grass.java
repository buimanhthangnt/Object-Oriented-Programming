package pasture;

import javax.swing.*;

public class Grass extends Creature {
    private static ImageIcon image = new ImageIcon(Pasture.class.getResource("/plant.gif"));
    public static int population = 0;

    public Grass(Pasture pasture, boolean alive) {
        REPRODUCE_DELAY = 100;

        this.pasture = pasture;
        this.alive = alive;
        reproduceDelay = REPRODUCE_DELAY;
    }

    public void tick() {
        if (!alive) return;
        if (reproduceDelay > 0) reproduceDelay--;
        if (reproduceDelay == 0) reproduce();
    }

    public Grass create() {
        return new Grass(pasture, true);
    }

    public boolean isCompatible(Entity otherEntity) {
        return false;
    }

    public ImageIcon getImage() {
        return image;
    }
}
