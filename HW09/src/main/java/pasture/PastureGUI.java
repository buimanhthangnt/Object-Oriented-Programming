package pasture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PastureGUI extends JFrame implements ActionListener {

    private final ImageIcon II_UNKNOWN = new ImageIcon(PastureGUI.class.getResource("/unknown.gif"));
    private final ImageIcon II_EMPTY = new ImageIcon(PastureGUI.class.getResource("/empty.gif"));
    private final int SCALE = 30;
    private Engine engine;

    private JLabel[][] grid;
    private Map<Point, java.util.List<ImageIcon>> icons =
            new HashMap<Point, java.util.List<ImageIcon>>();

    private JLabel clockLabel = new JLabel("Time: 0");
    private JLabel wolfLabel = new JLabel("Wolves: " + Wolf.population);
    private JLabel sheepLabel = new JLabel("Sheep: " + Sheep.population);
    private JLabel grassLabel = new JLabel("Grasses: " + Grass.population);
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Pause");
    private JButton exitButton = new JButton("Exit");

    private int height;
    private int width;
    int size = 0;

    /**
     * Creates a new instance of this class with the specified
     * settings for the pasture to display.
     */

    public PastureGUI(int width, int height, Engine engine) {
        this.height = height;
        this.width = width;

        this.engine = engine;

        setSize(width * SCALE, height * SCALE);

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 5));
        buttons.add(clockLabel);
        buttons.add(wolfLabel);
        buttons.add(sheepLabel);
        buttons.add(grassLabel);
        buttons.add(startButton);
        buttons.add(stopButton);
        buttons.add(exitButton);

        JPanel field = new JPanel();
        field.setBackground(new Color(27, 204, 89));
        field.setLayout(new GridLayout(height, width));
        grid = new JLabel[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = new JLabel(II_EMPTY);
                grid[x][y].setVisible(true);
                field.add(grid[x][y]);

            }
        }

        Container display = getContentPane();
        display.setBackground(new Color(27, 204, 89));
        display.setLayout(new BorderLayout());
        display.add(field, BorderLayout.CENTER);
        display.add(buttons, BorderLayout.SOUTH);

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        exitButton.setEnabled(true);

        update();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    /**
     * This method is called when an action event has occured and
     * carries out the correct actions depending on the event. In this
     * class, this means that someone has pressed any of the buttons
     * start, stop, or exit.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            exitButton.setEnabled(true);
            engine.start();
        } else if (e.getSource() == stopButton) {
            if (stopButton.getText() == "Pause") {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                stopButton.setText("Continue");
                exitButton.setEnabled(true);
                engine.stop();
            }
            else {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                stopButton.setText("Pause");
                exitButton.setEnabled(true);
                engine.start();
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    /**
     * The method addEntity is called to notify the GUI that an entity
     * has been added to a position. The icon of the added entity is
     * displayed at the position.
     */

    public void addEntity(Entity e, Point p) {
        ImageIcon icon = e.getImage();

        java.util.List<ImageIcon> l = icons.get(p);
        if (l == null) {
            l = new ArrayList<ImageIcon>();
            icons.put(p, l);
        }
        l.add(icon);
//        if (e instanceof Grass) l.add(icon);
//                       else l.add(0,icon);

        int x = (int) p.getX();
        int y = (int) p.getY();
        grid[x][y].setIcon(icon);

        size++;
    }

    public void moveEntity(Entity e, Point old, Point ny) {
        removeEntity(e, old);
        addEntity(e, ny);
    }

    /**
     * The method removeEntity is called to notify the GUI that an
     * entity has been removed from a position. One icon among the
     * icons of the remaining entities is displayed at the position.
     */

    public void removeEntity(Entity e, Point p) {

        ImageIcon icon0 = e.getImage();

        java.util.List<ImageIcon> l = icons.get(p);
        l.remove(icon0);

        ImageIcon icon;
        if (l.isEmpty()) icon = II_EMPTY;
        else icon = l.get(0);

        int x = (int) p.getX();
        int y = (int) p.getY();
        grid[x][y].setIcon(icon);

        size--;
    }

    public void update() {

        clockLabel.setText("Time: " + engine.getTime());
        wolfLabel.setText("Wolves: " + Wolf.population);
        sheepLabel.setText("Sheep: " + Sheep.population);
        grassLabel.setText("Grasses: " + Grass.population);
    }
}

