package pasture;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

public class SheepBrain extends Brain {
    private Collection<Point> wolfPoint = new HashSet<>();
    private Point grassPoint = null;

    public Point getBestMove(Pasture pasture, Animal animal) {
        Point bestMove;
        Collection<Point> list = pasture.getFreeNeighbours(animal);
        findTarget(pasture, animal, animal.sight);
        //find the point which has smallest the sum of distances to wolfs
        if (wolfPoint.size() != 0) {
            double bestDistance = 0;
            if (list.size() == 0) return null;
            bestMove = pasture.getEntityPosition(animal);
            for (Point p1 : list) {
                double temp = 0;
                for (Point p2 : wolfPoint) {
                    temp += getDistance(p1, p2);
                }
                if (temp > bestDistance) {
                    bestDistance = temp;
                    bestMove = p1;
                }
            }
            saveLastMove(bestMove, pasture, animal);
            return bestMove;
        } else return findFood(pasture, animal, grassPoint);
    }

    private void findTarget(Pasture pasture, Animal animal, int sight) {
        Collection<Entity> collection = findObjects(pasture, animal, sight);
        double grassDistance = 99999;
        if (collection == null) return;
        Point targetPoint;
        Point entityPoint = pasture.getEntityPosition(animal);
        for (Entity e : collection) {
            targetPoint = pasture.getEntityPosition(e);
            double temp = getDistance(entityPoint, targetPoint);
            if (e instanceof Grass && temp < grassDistance) {
                grassPoint = targetPoint;
                grassDistance = temp;
            }
            if (e instanceof Wolf) wolfPoint.add(targetPoint);
        }
    }
}
