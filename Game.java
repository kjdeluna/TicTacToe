import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
/* This class contains the actual logic of the game */
public class Game extends JPanel {
    
    private static Board BOARD; // (See Board.java)
    public static char TURN = 'X'; // Whose turn it is
                    // Possible values: X, O
    public Game() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        BOARD = new Board();
        this.add(BOARD, BorderLayout.CENTER);
    }

    public static void reverseTurn() {
        if(TURN == 'X') {
            TURN = 'O';
        } else if(TURN  == 'O') {
            TURN = 'X';
        }
    }

}