package pasture;

import javax.swing.*;

public class Fence implements Entity {
    private static ImageIcon image = new ImageIcon(Pasture.class.getResource("/fence.gif"));

    public void tick() {
    }

    public boolean isCompatible(Entity otherEntity) {
        return false;
    }

    public ImageIcon getImage() {
        return image;
    }
}
