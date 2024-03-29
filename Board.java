import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.StringBuilder;
import javax.swing.JPanel;
public class Board extends JPanel {

    // A 2D-Array of Tile (See Tile.java)
    private Tile boardTiles[][];
    // Dimensions of the board (In this case: 3 x 3)

    public Board(){
        // Initialize properties of the board
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        this.setLayout(new GridLayout(Constants.ROWS, Constants.COLUMNS));
        this.boardTiles = new Tile[Constants.ROWS][Constants.COLUMNS];
        // Instantiate tiles within the boardTiles
        for(int i = 0; i < Constants.ROWS; i++) {
            for(int j = 0; j < Constants.COLUMNS; j++) {
                this.boardTiles[i][j] = new Tile();
                this.add(this.boardTiles[i][j]);
            }
        }

    }

    public Tile[][] getBoardTiles() {
        return this.boardTiles;
    }

    public char[][] getBoardCharacters() {
        char[][] table = new char[Constants.ROWS][Constants.COLUMNS];
        for(int i = 0; i < Constants.ROWS; i++) {
            for(int j = 0; j < Constants.COLUMNS; j++) {
                table[i][j] = this.boardTiles[i][j].getToken();
            }
        }
        return table;
        // StringBuilder sb = new StringBuilder();
        // for(int i = 0; i < Constants.ROWS; i++) {
        //     for(int j = 0; j < Constants.COLUMNS; j++) {
        //         sb.append(boardTiles[i][j].getToken());
        //     }
        // }
        // System.out.println(sb.toString());
        // return sb.toString();
    }

    public void setBoardTiles(Tile[][] boardTiles) {
        this.boardTiles = boardTiles;
    }

    public boolean checkIfFull() {
        char[][] table = this.getBoardCharacters();
        for(int i = 0; i < Constants.ROWS; ++i){
            for(int j = 0; j < Constants.COLUMNS; ++j){
                if(table[i][j] == '_') return false;
            }   
        }
        return true;
    }
}