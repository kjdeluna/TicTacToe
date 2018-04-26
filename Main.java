import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Main{
    private static final String TITLE = "Undefeatable TicTacToe";
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private static final int SCALE = 2;

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container pane) {

        // pane.add(<JPanel>);
    }

    public static void main(String[] args){
        System.out.println("Test");
        createAndShowGUI();
    }
    
}