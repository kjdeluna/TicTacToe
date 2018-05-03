import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/* This class contains the actual logic of the game */
public class Game extends JPanel {
    public static String STATUS = "~";
    private static Options OPTIONS;
    private static Board BOARD; // (See Board.java)
    public static char PLAYER;
    public static State currentState;
                    // Possible values: X, O
    public static AISolver aiSolver;
    public Game(char playerToken, int playerTurn) {
        char _TURN; // temporary variable
        PLAYER = playerToken;
        aiSolver = new AISolver(invert(playerToken));
        if(playerTurn == 1) {
            _TURN = playerToken;
        } else {
            _TURN = invert(playerToken);
        }
        OPTIONS = new Options();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE + 32));
        BOARD = new Board();
        this.currentState = new State(BOARD, _TURN);
        // Occupy the whole center screen
        this.add(OPTIONS, BorderLayout.NORTH);
        this.add(BOARD, BorderLayout.CENTER);
    }
    public static State getCurrentState() {
        return currentState;
    }
    public static char invert(char playerToken) {
        if(playerToken == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    public static void reverseTurn() {
        aiSolver.think(currentState);
        if(currentState.getTurn() == 'X') {
            currentState.setTurn('O');
        } else if(currentState.getTurn()  == 'O') {
            currentState.setTurn('X');
        }
    }
    public static void stop() {
        Game.STATUS = "DONE";
    }
    public static void restart() {
        Game.STATUS = "~";
    }
    // Insert here if (AI) -> do recursive value fxn
    public static Board getBoard() {
        return BOARD;
    }
    public static boolean checkWin() {
        currentState.printStatus();
        return currentState.checkWin();
    }
}