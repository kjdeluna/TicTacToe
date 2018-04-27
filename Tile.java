import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Insets;
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
        this.setBackground(Color.WHITE);
        this.setFocusable(false);        
        try{
            this.setIcon(new ImageIcon(ImageIO.read(new File(Constants.IMAGE_PATH + Constants.X_ICON))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.token = Constants.EMPTY;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
        // if(this.token != Constants.EMPTY)
    }

}