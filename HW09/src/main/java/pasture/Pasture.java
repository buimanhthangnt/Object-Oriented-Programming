package pasture;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;


/**
 * A pasture contains sheep, wolves, fences, plants, and possibly
 * other entities. These entities move around in the pasture and try
 * to find food, other entities of the same kind and run away from
 * possible enemies.
 */
public class Pasture {

    private int width = 20;
    private int height = 20;

    private int wolves = 3;
    private int sheep = 20;
    private int plants = 100;

    private Set<Entity> world = new HashSet<Entity>();
    private Map<Point, List<Entity>> grid = new HashMap<Point, List<Entity>>();
    private Map<Entity, Point> point = new HashMap<Entity, Point>();

    private PastureGUI gui;

    /**
     * Creates a new instance of this class and places the entities in
     * it on random positions.
     */
    public Pasture() {
        readConfig();
        Engine engine = new Engine(this);
        gui = new PastureGUI(width, height, engine);

        for (int i = 0; i < width; i++) {
            addEntity(new Fence(), new Point(i, 0));
            addEntity(new Fence(), new Point(i, height - 1));
        }
        for (int i = 1; i < height - 1; i++) {
            addEntity(new Fence(), new Point(0, i));
            addEntity(new Fence(), new Point(width - 1, i));
        }

        /* 
         * Now insert the right number of different entities in the
         * pasture.
         */
        for (int i = 0; i < wolves; i++) {
            Entity wolve = new Wolf(this, true);
            addEntity(wolve, getFreePosition(wolve));
        }
        for (int i = 0; i < sheep; i++) {
            Entity aSheep = new Sheep(this, true);
            addEntity(aSheep, getFreePosition(aSheep));
        }
        for (int i = 0; i < plants; i++) {
            Entity grass = new Grass(this, true);
            addEntity(grass, getFreePosition(grass));
        }
        gui.update();
    }

    private void readConfig() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            String filename = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            prop.load(input);
            height = Integer.parseInt(prop.getProperty("world.height"));
            width = Integer.parseInt(prop.getProperty("world.width"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void refresh() {
        gui.update();
    }

    /**
     * Returns a random free position in the pasture if there exists
     * one.
     * <p/>
     * If the first random position turns out to be occupied, the rest
     * of the board is searched to find a free position.
     */
    private Point getFreePosition(Entity toPlace)
            throws MissingResourceException {
        Point position = new Point((int) (Math.random() * width),
                (int) (Math.random() * height));
        int startX = (int) position.getX();
        int startY = (int) position.getY();

        int p = startX + startY * width;
        int m = height * width;
        int q = 97; //any large prime will do

        for (int i = 0; i < m; i++) {
            int j = (p + i * q) % m;
            int x = j % width;
            int y = j / width;

            position = new Point(x, y);
            boolean free = true;

            Collection<Entity> c = getEntitiesAt(position);
            if (c != null) {
                for (Entity thisThing : c) {
                    if (!toPlace.isCompatible(thisThing)) {
                        free = false;
                        break;
                    }
                }
            }
            if (free) return position;
        }
        throw new MissingResourceException(
                "There is no free space" + " left in the pasture",
                "pasture.Pasture", "");
    }


    /**
     * Add a new entity to the pasture.
     */
    public void addEntity(Entity entity, Point pos) {

        world.add(entity);

        List<Entity> l = grid.get(pos);
        if (l == null) {
            l = new ArrayList<Entity>();
            grid.put(pos, l);
        }
        l.add(entity);

        point.put(entity, pos);

        gui.addEntity(entity, pos);
        if (entity instanceof Grass) Grass.population++;
        else if (entity instanceof Sheep) Sheep.population++;
        else if (entity instanceof Wolf) Wolf.population++;
    }

    public void moveEntity(Entity e, Point newPos) {

        Point oldPos = point.get(e);
        List<Entity> l = grid.get(oldPos);
        if (!l.remove(e))
            throw new IllegalStateException("Inconsistent stat in pasture.Pasture");
        /* We expect the entity to be at its old position, before we
           move, right? */

        l = grid.get(newPos);
        if (l == null) {
            l = new ArrayList<Entity>();
            grid.put(newPos, l);
        }
        l.add(e);

        point.put(e, newPos);

        gui.moveEntity(e, oldPos, newPos);
    }

    /**
     * Remove the specified entity from this pasture.
     */
    public void removeEntity(Entity entity) {

        Point p = point.get(entity);
        world.remove(entity);
        grid.get(p).remove(entity);
        point.remove(entity);
        gui.removeEntity(entity, p);
        if (entity instanceof Grass) Grass.population--;
        else if (entity instanceof Sheep) Sheep.population--;
        else if (entity instanceof Wolf) Wolf.population--;
    }

    /**
     * Various methods for getting information about the pasture
     */

    public List<Entity> getEntities() {
        return new ArrayList<Entity>(world);
    }

    public Collection<Entity> getEntitiesAt(Point lookAt) {

        Collection<Entity> l = grid.get(lookAt);

        if (l == null) {
            return null;
        } else {
            return new ArrayList<Entity>(l);
        }
    }


    public Collection<Point> getFreeNeighbours(Entity entity) {
        Set<Point> free = new HashSet<Point>();
        Point p;

        int entityX = (int) getEntityPosition(entity).getX();
        int entityY = (int) getEntityPosition(entity).getY();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                p = new Point(entityX + x,
                        entityY + y);
                if (freeSpace(p, entity))
                    free.add(p);
            }
        }
        return free;
    }

    private boolean freeSpace(Point p, Entity e) {

        List<Entity> l = grid.get(p);
        if (l == null) return true;
        for (Entity old : l)
            if (!e.isCompatible(old)) return false;
        return true;
    }

    public Point getEntityPosition(Entity entity) {
        return point.get(entity);
    }


    /**
     * The method for the JVM to run.
     */
    public static void main(String[] args) {

        new Pasture();
    }


}


