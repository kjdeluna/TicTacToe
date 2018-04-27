import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

    public Configurations() {
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Setup GridBagConstraints
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = Constants.WIDTH / 2;
        c.ipady = Constants.HEIGHT * 2 / 3;
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
        START_BUTTON = new JButton("Start");
        START_BUTTON.setFocusable(false);
        this.add(START_BUTTON, c);

    }
}