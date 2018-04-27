import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class MainCard extends JPanel {

    public static JPanel CARD_HOLDER = new JPanel(new CardLayout());
    private static Menu MENU_CARD;
    private static Configurations CONFIGURATIONS_CARD;
    public static Game RECENT_GAME;

    public MainCard() {
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, Constants.HEIGHT * Constants.SCALE));
        this.setLayout(new BorderLayout());
        // Instantiate Menu (See Menu.java)
        MENU_CARD = new Menu();
        CARD_HOLDER.add(MENU_CARD, "MENU");
        // Menu will be the default card to be shown to the user
        CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
        c.show(CARD_HOLDER, "MENU");
        // Instantiate Configurations (See Configurations.java)
        CONFIGURATIONS_CARD = new Configurations();
        CARD_HOLDER.add(CONFIGURATIONS_CARD, "CONFIGURATIONS");
        // Add the CARD_HOLDER to the __contentPane
        this.add(CARD_HOLDER, BorderLayout.CENTER);
    }

    public static void goBackToMenu() {
        CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
        c.show(CARD_HOLDER, "MENU");
    }

    public static void showConfigurations() {
        CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
        c.show(CARD_HOLDER, "CONFIGURATIONS");
    }

    public static void startGame() {
        if(RECENT_GAME != null) CARD_HOLDER.remove(MainCard.RECENT_GAME);
        RECENT_GAME = new Game();
        CARD_HOLDER.add(RECENT_GAME, "GAME");
        CardLayout c = (CardLayout) CARD_HOLDER.getLayout();
        c.show(CARD_HOLDER, "GAME");
    }
}