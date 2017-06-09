//package tetris;
//
//import static org.junit.Assert.*;
//
//import org.junit.*;
//
//public class BoardTest {
//    Board b;
//    Piece pyr1, pyr2, pyr3, pyr4, s, sRotated;
//    private int i;
//
//    // This shows how to build things in setUp() to re-use
//    // across tests.
//
//    // In this case, setUp() makes shapes,
//    // and also a 3X6 board, with pyr placed at the bottom,
//    // ready to be used by tests.
//    @Before
//    public void setUp() throws Exception {
//        b = new Board(3, 6);
//
//        pyr1 = new Piece(Piece.PYRAMID_STR);
//        pyr2 = pyr1.computeNextRotation();
//        pyr3 = pyr2.computeNextRotation();
//        pyr4 = pyr3.computeNextRotation();
//
//        s = new Piece(Piece.S1_STR);
//        sRotated = s.computeNextRotation();
//
//        i = b.place(pyr1, 0, 0);
//    }
//
//    // Check the basic width/height/max after the one placement
//    @Test
//    public void testSample1() {
//        assertEquals(Board.PLACE_ROW_FILLED, i);
//        assertEquals(1, b.getColumnHeight(0));
//        assertEquals(2, b.getColumnHeight(1));
//        assertEquals(2, b.getMaxHeight());
//        assertEquals(3, b.getRowWidth(0));
//        assertEquals(1, b.getRowWidth(1));
//        assertEquals(0, b.getRowWidth(2));
//    }
//
//    // Place sRotated into the board, then check some measures
//    @Test
//    public void testSample2() {
//        b.commit();
//        int result = b.place(sRotated, 1, 1);
//        assertEquals(Board.PLACE_OK, result);
//        assertEquals(1, b.getColumnHeight(0));
//        assertEquals(4, b.getColumnHeight(1));
//        assertEquals(3, b.getColumnHeight(2));
//        assertEquals(4, b.getMaxHeight());
//    }
//
//    @Test
//    public void testSample3() {
//        b.commit();
//        b.place(new Piece(Piece.STICK_STR), 0, 1);
//        assertEquals(5, b.getColumnHeight(0));
//        assertEquals(5, b.getMaxHeight());
//        assertEquals(1, b.getColumnHeight(2));
//        assertEquals(true, b.getGrid(2, 0));
//        b.clearRows();
//        assertEquals(4, b.getMaxHeight());
//        assertEquals(2, b.getRowWidth(0));
//        assertEquals(4, b.getMaxHeight());
//        b.commit();
//        b.place(new Piece(Piece.STICK_STR), 2, 0);
//        b.clearRows();
//        assertEquals(3, b.getMaxHeight());
//        assertEquals(3, b.getColumnHeight(0));
//        assertEquals(0, b.getColumnHeight(1));
//        assertEquals(3, b.getColumnHeight(2));
//        assertEquals(2, b.getRowWidth(0));
//        assertEquals(2, b.getRowWidth(1));
//        assertEquals(2, b.getRowWidth(2));
//        assertEquals(0, b.getRowWidth(3));
//        b.undo();
//        assertEquals(4, b.getMaxHeight());
//        assertEquals(2, b.getRowWidth(0));
//        assertEquals(1, b.getRowWidth(1));
//    }
//
//    @Test
//    public void testSample4() {
//        b.commit();
//        int j = b.place(new Piece(Piece.S1_STR).computeNextRotation(), 1, 1);
//        assertEquals(j, Board.PLACE_OK);
//    }
//
//    @Test
//    public void testSample5() {
//        Board board = new Board(6, 12);
//        Piece pyramid = new Piece(Piece.PYRAMID_STR);
//        Piece square = new Piece(Piece.SQUARE_STR);
//        Piece l = new Piece(Piece.L1_STR);
//        Piece stick = new Piece(Piece.STICK_STR);
//        int i = board.place(pyramid, 0, 0);
//        assertEquals(i, Board.PLACE_OK);
//        board.commit();
//        board.place(stick, 0, 1);
//        board.commit();
//        i = board.place(stick, 0, 5);
//        assertEquals(i, Board.PLACE_OK);
//        b.commit();
//        assertEquals(3, board.getRowWidth(0));
//        assertEquals(2, board.getRowWidth(1));
//        assertEquals(1, board.getRowWidth(2));
//        assertEquals(1, board.getRowWidth(8));
//        assertEquals(0, board.getRowWidth(9));
//        assertEquals(9, board.getColumnHeight(0));
//        assertEquals(2, board.getColumnHeight(1));
//        assertEquals(9, board.getMaxHeight());
//        assertEquals(2, board.dropHeight(l, 1));
//        board.commit();
//        board.place(l, 1, 2);
//        assertEquals(7, board.dropHeight(l.computeNextRotation().computeNextRotation(), 0));
//        assertEquals(3, board.dropHeight(l.computeNextRotation().computeNextRotation(), 1));
//        assertEquals(5, board.dropHeight(square, 1));
//        assertEquals(0, board.dropHeight(l.computeNextRotation(), 3));
//        board.commit();
//        board.place(l.computeNextRotation(), 3, 0);
//        board.clearRows();
//        assertEquals(8, board.getMaxHeight());
//
//        board.undo();
//        assertEquals(7, board.dropHeight(l.computeNextRotation().computeNextRotation(), 0));
//        assertEquals(3, board.dropHeight(l.computeNextRotation().computeNextRotation(), 1));
//        assertEquals(5, board.dropHeight(square, 1));
//        assertEquals(0, board.dropHeight(l.computeNextRotation(), 3));
//        board.place(l.computeNextRotation(), 3, 0);
//        i = board.clearRows();
//        assertEquals(i, Board.PLACE_ROW_FILLED);
//        assertEquals(8, board.getMaxHeight());
//        board.undo();
//        assertEquals(9, board.getMaxHeight());
//    }
//
//    @Test
//    public void testSample6() {
//        Piece square = new Piece(Piece.SQUARE_STR);
//        Piece stick = new Piece(Piece.STICK_STR);
//        Board board = new Board(5, 8);
//        board.place(square, 1, 0);
//        board.commit();
//        board.place(square, 3, 0);
//        board.commit();
//        board.place(square, 1, 2);
//        board.commit();
//        board.place(square, 3, 2);
//        board.commit();
//        board.place(stick, 0, 0);
//        board.commit();
//        board.place(new Piece(Piece.PYRAMID_STR), 2, 4);
//        System.out.println(board);
//        board.clearRows();
//        System.out.println(board);
//        assertEquals(2, board.getMaxHeight());
//        assertEquals(3, board.getRowWidth(0));
//        assertEquals(1, board.getColumnHeight(2));
//    }
//    ///
//    // Make  more tests, by putting together longer series of
//    // place, clearRows, undo, place ... checking a few col/row/max
//    // numbers that the board looks right after the operations.
//
//
//}
