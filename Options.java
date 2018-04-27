import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Options extends JPanel {
    
    private static JButton BACK_BUTTON;

    public Options() {
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SCALE, 32));
        BACK_BUTTON = new JButton("BACK");
        this.add(BACK_BUTTON);
        BACK_BUTTON.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Menu.goBackToMenu();
            }
        });
    }
}