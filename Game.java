import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/* This class contains the actual logic of the game */
public class Game extends JPanel {
    
    private static Options OPTIONS;
    private static Board BOARD; // (See Board.java)
    public static char TURN = 'X'; // Whose turn it is
                    // Possible values: X, O
    public Game() {
        OPTIONS = new Options();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE + 32));
        BOARD = new Board();
        // Occupy the whole center screen
        this.add(OPTIONS, BorderLayout.NORTH);
        this.add(BOARD, BorderLayout.CENTER);
    }

    public static void reverseTurn() {
        if(TURN == 'X') {
            TURN = 'O';
        } else if(TURN  == 'O') {
            TURN = 'X';
        }
    }

    public static void checkWin() {
        if(checkHorizontal()) JOptionPane.showMessageDialog(null, "You win - Horizontal");
        else if(checkVertical()) JOptionPane.showMessageDialog(null, "You win - Vertical");
        else if(checkDiagonal()) JOptionPane.showMessageDialog(null, "You win - Diagonal");
    }
    private static boolean checkDiagonal() {
        /*
            DIAGONAL:
                    [0][0]
                            [1][1]
                                    [2][2]
                    ----------------------
                                    [0][2]
                            [1][1]
                    [2][0]
        */
        Tile[][] boardTiles = BOARD.getBoardTiles(); 
        boolean continuous = true;
        // Check backslash (' \ ') diagonal
        char first = boardTiles[0][0].getToken();
        for(int i = 1; i < Constants.COLUMNS; i++) {
            if(first != Constants.EMPTY) {
                if(first != boardTiles[i][i].getToken()) {
                    continuous = false;
                    break;
                }
            } 
            else {
                continuous = false;
                break;
            }
        }
        if(continuous) return true;
        continuous = true;
        first = boardTiles[Constants.ROWS - 1][0].getToken();
        for(int i = 2, j = 0; i >= 0 && j < Constants.COLUMNS; i--, j++) {
            if(first != Constants.EMPTY) {
                if(first != boardTiles[i][j].getToken()) {
                    continuous = false;
                    break;
                }
            }
            else {
                continuous = false;
                break;
            }
        }
        if(continuous) return true;
        return false;
    }

    private static boolean checkHorizontal() {
        /*
            HORIZONTAL:
                    [0][0]  [0][1]  [0][2],

                    [1][0]  [1][1]  [1][2],

                    [2][0]  [2][1]  [2][2]
        */
        Tile[][] boardTiles = BOARD.getBoardTiles(); 
        for(int i = 0; i < Constants.ROWS; i++) {
            char first = boardTiles[i][0].getToken();
            if(first == Constants.EMPTY) continue;
            boolean continuous = true;
            for(int j = 1; j < Constants.COLUMNS; j++) {
                if(first != boardTiles[i][j].getToken()) {
                    continuous = false;
                    break;
                }
            }
            if(continuous) return true;
        }
        return false;
    }

    private static boolean checkVertical() {
        /*
            VERTICAL:
                    [0][0]
                    [1][0]
                    [2][0]
                    ------
                    [0][1]
                    [1][1]
                    [2][1]
                    ------
                    [0][2]
                    [1][2]
                    [2][2]
        */
        Tile[][] boardTiles = BOARD.getBoardTiles(); 
        for(int i = 0; i < Constants.COLUMNS; i++) {
            char first = boardTiles[0][i].getToken();
            boolean continuous = true;
            if(first == Constants.EMPTY) continue;
            for(int j = 0; j < Constants.ROWS; j++) {
                if(first != boardTiles[j][i].getToken()) {
                    continuous = false;
                    break;
                }
            }
            if(continuous) return true;
        }
        return false;
    }

}