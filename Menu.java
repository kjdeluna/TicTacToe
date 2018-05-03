import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Menu extends JPanel {

    private static JButton START_BUTTON;
    private static JPanel MENU_CARD;
    public Menu() {
        // this.setLayout(new BorderLayout());
        // this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        START_BUTTON = new JButton("Start");
        this.add(START_BUTTON);
        START_BUTTON.setBounds(Constants.WIDTH * Constants.SCALE / 2 - 50, 
                                Constants.HEIGHT * Constants.SCALE / 2 - 150,
                                102, 
                                48);
        START_BUTTON.setFocusable(false);
        START_BUTTON.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Show Configurations Card
                MainCard.showConfigurations();
            }
        });

        
    }

}