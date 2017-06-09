package pasture;

import java.awt.*;
import java.util.Collection;

public class WolfBrain extends Brain {

    public Point getBestMove(Pasture pasture, Animal animal) {
        Point sheepPoint = findTarget(pasture, animal, animal.sight);
        return findFood(pasture, animal, sheepPoint);
    }

    private Point findTarget(Pasture pasture, Animal animal, int sight) {
        Collection<Entity> collection = findObjects(pasture, animal, sight);
        double distance = 99999;
        if (collection == null) return null;
        Point targetPoint;
        Point entityPoint = pasture.getEntityPosition(animal);
        Point returnPoint = entityPoint;
        for (Entity e : collection) {
            if (!(e instanceof Sheep)) continue;
            targetPoint = pasture.getEntityPosition(e);
            double temp = getDistance(entityPoint, targetPoint);
            if (temp < distance) {
                returnPoint = targetPoint;
                distance = temp;
            }
        }
        if (returnPoint.equals(entityPoint)) return null;
        return returnPoint;
    }
}
