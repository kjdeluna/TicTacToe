import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Menu extends JPanel {

    private static JPanel CARD_HOLDER = new JPanel(new CardLayout());
    private static JButton START_BUTTON;
    private static JPanel MENU_CARD;
    private static Game RECENT_GAME;
    public Menu() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        MENU_CARD = new JPanel();
        MENU_CARD.setLayout(null);
        MENU_CARD.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        START_BUTTON = new JButton("Start");
        MENU_CARD.add(START_BUTTON);
        START_BUTTON.setBounds(Constants.WIDTH * Constants.SCALE / 2 - 50, 
                                Constants.HEIGHT * Constants.SCALE / 2 - 150,
                                102, 
                                48);
        START_BUTTON.setFocusable(false);
        START_BUTTON.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(RECENT_GAME != null) CARD_HOLDER.remove(RECENT_GAME);
                RECENT_GAME = new Game();
                CARD_HOLDER.add(RECENT_GAME, "GAME");
                CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
                c.show(CARD_HOLDER, "GAME");
                
            }
        });
        CARD_HOLDER.add(MENU_CARD, "MENU");
        CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
        c.show(CARD_HOLDER, "MENU");
        this.add(CARD_HOLDER, BorderLayout.CENTER);
        
    }

    public static void goBackToMenu() {
        CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
        c.show(CARD_HOLDER, "MENU");
    }

}