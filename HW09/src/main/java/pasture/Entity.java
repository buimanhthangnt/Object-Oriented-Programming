package pasture;

import javax.swing.*;

/**
 * This is the superclass of all entities in the pasture simulation
 * system. This interface <b>must</b> be implemented by all entities
 * that exist in the simulation of the pasture.
 */
public interface Entity {

    void tick();

    /**
     * ImageIcon returns the icon of this entity, to be displayed by
     * the pasture gui.
     */
    ImageIcon getImage();

    boolean isCompatible(Entity otherEntity);
}
