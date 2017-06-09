// Board.java
package tetris;

/**
 * CS108 Tetris Board.
 * Represents a Tetris board -- essentially a 2-d grid
 * of booleans. Supports tetris pieces and row clearing.
 * Has an "undo" feature that allows clients to add and remove pieces efficiently.
 * Does not do any drawing or have any idea of pixels. Instead,
 * just represents the abstract 2-d board.
 */
public class Board {
    // Some ivars are stubbed out for you:
    private int width;
    private int height;
    private boolean[][] grid;
    private boolean[][] backupGrid;
    private boolean DEBUG = true;
    private int[] widths;
    private int[] backupWidths;
    private int[] heights;
    private int[] backupHeights;
    private int maxHeight;
    private int backupMaxHeight;
    boolean committed;


    // Here a few trivial methods are provided:

    /**
     * Creates an empty board of the given width and height
     * measured in blocks.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        backupGrid = new boolean[width][height];
        committed = true;
        widths = new int[height];
        backupWidths = new int[height];
        heights = new int[width];
        backupHeights = new int[width];
        maxHeight = 0;
        backupMaxHeight = 0;
    }


    /**
     * Returns the width of the board in blocks.
     */
    public int getWidth() {
        return width;
    }


    /**
     * Returns the height of the board in blocks.
     */
    public int getHeight() {
        return height;
    }


    /**
     * Returns the max column height present in the board.
     * For an empty board this is 0.
     */
    public int getMaxHeight() {
        return maxHeight;
    }


    /**
     * Checks the board for internal consistency -- used
     * for debugging.
     */
    public void sanityCheck() {
        if (DEBUG) {
            int[] widthCheck = new int[height];
            int[] heightCheck = new int[width];
            int maxHeightCheck = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[i][j] == true) {
                        widthCheck[j]++;
                        if (heightCheck[i] < j + 1) heightCheck[i] = j + 1;
                    }
                }
                if (heightCheck[i] > maxHeightCheck) maxHeightCheck = heightCheck[i];
            }
            for (int i = 0; i < width; i++) {
                if (heightCheck[i] != heights[i]) throw new RuntimeException("Wrong heights!");
            }
            for (int i = 0; i < height; i++) {
                if (widths[i] != widthCheck[i]) throw new RuntimeException("Wrong widths!");
            }
            if (maxHeight != maxHeightCheck) throw new RuntimeException("Wrong maxHeight!");
        }
    }

    /**
     * Given a piece and an x, returns the y
     * value where the piece would come to rest
     * if it were dropped straight down at that x.
     * <p>
     * <p>
     * Implementation: use the skirt and the col heights
     * to compute this fast -- O(skirt length).
     */
    public int dropHeight(Piece piece, int x) {
        int max = 0;
        for (int i = 0; i < piece.getWidth(); i++) {
            if (heights[x + i] - piece.getSkirt()[i] > max) {
                max = heights[x + i] - piece.getSkirt()[i];
            }
        }
        return max;
    }


    /**
     * Returns the height of the given column --
     * i.e. the y value of the highest block + 1.
     * The height is 0 if the column contains no blocks.
     */
    public int getColumnHeight(int x) {
        return heights[x];
    }


    /**
     * Returns the number of filled blocks in
     * the given row.
     */
    public int getRowWidth(int y) {
        return widths[y];
    }


    /**
     * Returns true if the given block is filled in the board.
     * Blocks outside of the valid width/height area
     * always return true.
     */
    public boolean getGrid(int x, int y) {
        if (x >= width || y >= height || x < 0 || y < 0) return true;
        if (grid[x][y] == true) return true;
        return false;
    }


    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     * <p>
     * <p>Error cases:
     * A placement may fail in two ways. First, if part of the piece may falls out
     * of bounds of the board, PLACE_OUT_BOUNDS is returned.
     * Or the placement may collide with existing blocks in the grid
     * in which case PLACE_BAD is returned.
     * In both error cases, the board may be left in an invalid
     * state. The client can use undo(), to recover the valid, pre-place state.
     */
    public int place(Piece piece, int x, int y) {
        // flag !committed problem
        if (!committed) throw new RuntimeException("place commit problem");
        if (x < 0 || x >= width || y < 0 || y >= height) return PLACE_OUT_BOUNDS;
        if (x + piece.getWidth() > width || y + piece.getHeight() > height) return PLACE_OUT_BOUNDS;
        boolean isFilled = false;
        committed = false;
        for (int i = 0; i < piece.getBody().length; i++) {
            int cx = piece.getBody()[i].x + x;
            int cy = piece.getBody()[i].y + y;
            if (grid[cx][cy] == true) return PLACE_BAD;
            grid[cx][cy] = true;
            widths[cy]++;
            if (heights[cx] < cy + 1) heights[cx] = cy + 1;
            if (heights[cx] > maxHeight) maxHeight = heights[cx];
            if (widths[cy] == width) isFilled = true;
        }
        sanityCheck();
        if (isFilled) return PLACE_ROW_FILLED;
        return PLACE_OK;
    }


    /**
     * Deletes rows that are filled all the way across, moving
     * things above down. Returns the number of rows cleared.
     */
    public int clearRows() {
        int rowsCleared = 0;
        committed = false;
        for (int j = 0; j < maxHeight; j++) {
            if (widths[j] == width) {
                for (int i = 0; i < width; i++) {
                    grid[i][j] = false;
                }
                widths[j] = 0;
                rowsCleared++;
                continue;
            }
            for (int i = 0; i < width; i++) {
                grid[i][j - rowsCleared] = grid[i][j];
                if (rowsCleared != 0) grid[i][j] = false;
            }
            widths[j - rowsCleared] = widths[j];
            if (rowsCleared != 0) widths[j] = 0;
        }
        maxHeight = 0;
        for (int i = 0; i < width; i++) {
            int j = height - 1;
            while (j >= 0 && grid[i][j] == false) j--;
            heights[i] = j + 1;
            if (maxHeight < heights[i]) maxHeight = heights[i];
        }
        sanityCheck();
        return rowsCleared;
    }


    /**
     * Reverts the board to its state before up to one place
     * and one clearRows();
     * If the conditions for undo() are not met, such as
     * calling undo() twice in a row, then the second undo() does nothing.
     * See the overview docs.
     */
    public void undo() {
        if (committed) return;
        for (int i = 0; i < backupGrid.length; i++) {
            System.arraycopy(backupGrid[i], 0, grid[i], 0, backupGrid[i].length);
        }
        System.arraycopy(backupWidths, 0, widths, 0, backupWidths.length);
        System.arraycopy(backupHeights, 0, heights, 0, backupHeights.length);
        maxHeight = backupMaxHeight;
        committed = true;
        sanityCheck();
    }


    /**
     * Puts the board in the committed state.
     */
    public void commit() {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, backupGrid[i], 0, grid[i].length);
        }
        System.arraycopy(widths, 0, backupWidths, 0, widths.length);
        System.arraycopy(heights, 0, backupHeights, 0, heights.length);
        backupMaxHeight = maxHeight;
        committed = true;
    }


    /*
     Renders the board state as a big String, suitable for printing.
     This is the sort of print-obj-state utility that can help see complex
     state change over time.
     (provided debugging utility)
     */
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (int y = height - 1; y >= 0; y--) {
            buff.append('|');
            for (int x = 0; x < width; x++) {
                if (getGrid(x, y)) buff.append('+');
                else buff.append(' ');
            }
            buff.append("|\n");
        }
        for (int x = 0; x < width + 2; x++) buff.append('-');
        return (buff.toString());
    }
}


