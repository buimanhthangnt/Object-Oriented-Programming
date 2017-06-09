package tetris;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Random;

public class JBrainTetris extends JTetris {
    private int tempCount = -1;
    private JSlider adversary;
    private Brain.Move bestMove = new Brain.Move();
    private JCheckBox brainMode;

    public JBrainTetris(int pixels) {
        super(pixels);
    }

    @Override
    public Piece pickNextPiece() {
        Random random = new Random();
        int randNum = random.nextInt(100);
        if (randNum >= adversary.getValue()) {
            int pieceNum;
            pieceNum = (int) (pieces.length * random.nextDouble());
            return (pieces[pieceNum]);
        }
        DefaultBrain brain = new DefaultBrain();
        double score = 0;
        int index = -1;
        Brain.Move move = new Brain.Move();
        for (int i = 0; i < pieces.length; i++) {
            move = brain.bestMove(board, pieces[i], board.getHeight() - 4, move);
            if (move == null) continue;
            int result = board.place(move.piece, move.x, move.y);
            if (result == Board.PLACE_ROW_FILLED) board.clearRows();
            double temp = brain.rateBoard(board);
            if (score < temp) {
                score = temp;
                index = i;
            }
            board.undo();
        }
        if (index == -1) return (pieces[(int) (pieces.length * random.nextDouble())]);
        return pieces[index];
    }

    @Override
    public JComponent createControlPanel() {
        JComponent panel;
        panel = super.createControlPanel();
        JPanel row = (JPanel) panel.getComponent(7);
        row.setMaximumSize(new Dimension(400, 100));
        brainMode = new JCheckBox("Brain active");
        panel.add(brainMode);

        panel.add(new JLabel("Adversary:"));
        adversary = new JSlider(0, 100, 0); // min, max, current
        adversary.setPreferredSize(new Dimension(100, 15));
        panel.add(adversary);
        speed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateTimer();
            }
        });
        return panel;
    }

    @Override
    public void tick(int verb) {
        if (!gameOn) return;
        if (currentPiece != null) {
            board.undo();
        }
        //crete best move
        if (tempCount   != count && brainMode.isSelected()) {
            bestMove = new Brain.Move();
            DefaultBrain brain = new DefaultBrain();
            bestMove = brain.bestMove(board, currentPiece, board.getHeight() - 4, bestMove);
            if (bestMove != null) tempCount = count;
        }

        // move piece
        if (!brainMode.isSelected()) computeNewPosition(verb);
        else if (bestMove != null && verb == DOWN && (currentX != bestMove.x || currentPiece != bestMove.piece)) {
            if (currentPiece != bestMove.piece) {
                currentPiece = currentPiece.fastRotation();
                if (currentX == bestMove.x) computeNewPosition(verb);
            }
            if (bestMove.x > currentX) {
                computeNewPosition(RIGHT);
            } else if (bestMove.x < currentX) {
                computeNewPosition(LEFT);
            }
            if (currentX != bestMove.x && currentY > bestMove.y && currentY > board.getMaxHeight()) newY--;
        } else computeNewPosition(verb);

        // assess
        int result = setCurrent(newPiece, newX, newY);
        if (result == Board.PLACE_ROW_FILLED) {
            repaint();
        }
        boolean failed = (result >= Board.PLACE_OUT_BOUNDS);
        if (failed) {
            if (currentPiece != null) board.place(currentPiece, currentX, currentY);
            repaintPiece(currentPiece, currentX, currentY);
        }

        if (failed && verb == DOWN && !moved) {

            int cleared = board.clearRows();
            if (cleared > 0) {
                switch (cleared) {
                    case 1:
                        score += 5;
                        break;
                    case 2:
                        score += 10;
                        break;
                    case 3:
                        score += 20;
                        break;
                    case 4:
                        score += 40;
                        Toolkit.getDefaultToolkit().beep();
                        break;
                    default:
                        score += 50;  // could happen with non-standard pieces
                }
                countLabel.setText("Pieces " + count);
                scoreLabel.setText("Score " + score);
                repaint();
            }

            if (board.getMaxHeight() > board.getHeight() - TOP_SPACE) stopGame();
            else addNewPiece();
        }
        moved = (!failed && verb != DOWN);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        JBrainTetris tetris = new JBrainTetris(16);
        JFrame frame = JTetris.createFrame(tetris);
        frame.setVisible(true);
    }
}
