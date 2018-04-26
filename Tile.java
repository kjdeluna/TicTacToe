import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JButton;
/* This class represents a cell in the board (See Board.java) */
public class Tile extends JButton implements ActionListener {

    private char token; // Possible values: X, O, or Constants.EMPTY

    public Tile() {
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
    }

}