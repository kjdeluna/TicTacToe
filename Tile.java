import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/* This class represents a cell in the board (See Board.java) */
public class Tile extends JButton implements ActionListener {

    private char token; // Possible values: X, O, or Constants.EMPTY

    public Tile() {
        // Initialize button properties
        this.setBackground(Color.WHITE);
        this.setFocusable(false);        
        this.addActionListener(this);
        // Initialize Tile attribute/s
        this.token = Constants.EMPTY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!Game.STATUS.equals("DONE")){
            if(this.token == Constants.EMPTY) {
                if(Game.getCurrentState().getTurn() == 'X') {
                    this.token = 'X';
                    try{
                        this.setIcon(new ImageIcon(ImageIO.read(new File(Constants.IMAGE_PATH + Constants.X_ICON))));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    this.token = 'O';
                    try{
                        this.setIcon(new ImageIcon(ImageIO.read(new File(Constants.IMAGE_PATH + Constants.O_ICON))));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if(Game.checkWin()) {
                    // Display status 
                    Game.stop();
                }
                Game.reverseTurn();
            }
        }
    }

    public char getToken() {
        return this.token;
    }
    public void setToken(char token) {
        this.token = token;
    }
}