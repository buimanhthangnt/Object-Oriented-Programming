package pasture;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

public abstract class Brain {
    public abstract Point getBestMove(Pasture pasture, Animal animal);

    protected Point findFood(Pasture pasture, Animal animal, Point target) {
        Point bestMove;
        Collection<Point> list = pasture.getFreeNeighbours(animal);
        //find the nearest target
        if (target != null && animal.hungryDelay == 0) {
            double bestDistance = 9999;
            if (list.size() == 0) return null;
            bestMove = new Point();
            for (Point p : list) {
                double temp = getDistance(target, p);
                if (temp < bestDistance) {
                    bestDistance = temp;
                    bestMove = p;
                }
            }
            saveLastMove(bestMove, pasture, animal);
            return bestMove;
        }
        //if possible, go along the same direction as before
        if (animal.lastMove != null && animal.hungryDelay == 0) {
            Point current = pasture.getEntityPosition(animal);
            int x = (int) (current.getX() + animal.lastMove.getX());
            int y = (int) (current.getY() + animal.lastMove.getY());
            bestMove = new Point(x, y);
            for (Point p : list) {
                if (bestMove.getX() == p.getX() && bestMove.getY() == p.getY()) return bestMove;
            }
        }
        //finally, go randomly
        bestMove = animal.getRandomMember(pasture.getFreeNeighbours(animal));
        saveLastMove(bestMove, pasture, animal);
        return bestMove;
    }

    protected Collection<Entity> findObjects(Pasture pasture, Animal animal, int sight) {
        Collection<Entity> collection = new HashSet<>();
        Point tempPoint;
        int entityX = (int) pasture.getEntityPosition(animal).getX();
        int entityY = (int) pasture.getEntityPosition(animal).getY();
        for (int x = -sight; x <= sight; x++) {
            for (int y = -sight; y <= sight; y++) {
                tempPoint = new Point(entityX + x, entityY + y);
                if (pasture.getEntitiesAt(tempPoint) == null) continue;
                for (Entity e : pasture.getEntitiesAt(tempPoint)) collection.add(e);
            }
        }
        if (collection.size() == 0) return null;
        return collection;
    }

    protected double getDistance(Point p1, Point p2) {
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        return Math.sqrt(x * x + y * y);
    }

    protected void saveLastMove(Point p, Pasture pasture, Animal animal) {
        if (p == null) return;
        int x = (int) pasture.getEntityPosition(animal).getX();
        int y = (int) pasture.getEntityPosition(animal).getY();
        animal.lastMove = new Point((int) p.getX() - x, (int) p.getY() - y);
    }
}
