import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Configurations extends JPanel {

    private static JButton SELECT_X;
    private static JButton SELECT_O;
    private static JButton SELECT_FIRST;
    private static JButton SELECT_SECOND;
    private static JButton START_BUTTON;
    private static JButton SELECTED_TOKEN = null;
    private static JButton SELECTED_TURN = null;

    public Configurations() {
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Setup GridBagConstraints
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        // c.ipadx = Constants.WIDTH / 2;
        // c.ipady = Constants.HEIGHT * 2 / 3;
        // Instantiate Button
        SELECT_X = new JButton();
        SELECT_X.setFocusable(false);
        try{
            SELECT_X.setIcon(new ImageIcon(ImageIO.read(new File(Constants.IMAGE_PATH + Constants.X_ICON))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.add(SELECT_X, c);

        c.gridx = 1;
        c.gridy = 0;
        SELECT_O = new JButton();
        SELECT_O.setFocusable(false);
        try{
            SELECT_O.setIcon(new ImageIcon(ImageIO.read(new File(Constants.IMAGE_PATH + Constants.O_ICON))));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        this.add(SELECT_O, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, 0, 0, 0);
        SELECT_FIRST = new JButton("First turn");
        SELECT_FIRST.setFocusable(false);
        this.add(SELECT_FIRST, c);

        c.gridx = 1;
        c.gridy = 1;
        SELECT_SECOND = new JButton("Second turn");
        SELECT_SECOND.setFocusable(false);
        this.add(SELECT_SECOND, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        // c.ipady = 100;
        START_BUTTON = new JButton("Start");
        START_BUTTON.setFocusable(false);
        this.add(START_BUTTON, c);

        START_BUTTON.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // To pass: PlayerToken, PlayerTurn
                if(SELECTED_TOKEN == null || SELECTED_TURN == null) {
                    return;
                } 
                char playerToken;
                int playerTurn; // Possible value: 1 or 2
                if(SELECTED_TOKEN == SELECT_X) {
                    playerToken = 'X';
                } else {
                    playerToken = 'O';
                }
                if(SELECTED_TURN == SELECT_FIRST) {
                    playerTurn = 1;
                } else {
                    playerTurn = 2;
                }
                MainCard.startGame(playerToken, playerTurn);
            }
        });

        SELECT_X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SELECTED_TOKEN = (JButton) e.getSource();
                repaint();
            }
        });

        SELECT_O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SELECTED_TOKEN = (JButton) e.getSource();
                repaint();
            }
        });

        SELECT_FIRST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SELECTED_TURN = (JButton) e.getSource();
                repaint();
            }
        });

        SELECT_SECOND.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SELECTED_TURN = (JButton) e.getSource();
                repaint();
            
            }
        });
    }

    // TODO: create a class for these buttons
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // TOKEN
        if(SELECTED_TOKEN == SELECT_X) {
            SELECT_X.setBackground(new Color(144, 238, 144));
            SELECT_O.setBackground(null);
        } else if(SELECTED_TOKEN == SELECT_O){
            SELECT_O.setBackground(new Color(144, 238, 144));
            SELECT_X.setBackground(null);
        }
        // TURN
        if(SELECTED_TURN == SELECT_FIRST) {
            SELECT_FIRST.setBackground(new Color(144, 238, 144));
            SELECT_SECOND.setBackground(null);
        } else if(SELECTED_TURN == SELECT_SECOND){
            SELECT_SECOND.setBackground(new Color(144, 238, 144));
            SELECT_FIRST.setBackground(null);
        }
    }
}