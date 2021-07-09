import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class HexapawnGUI extends JFrame {
    
    JPanel gamePanel = new JPanel();
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;

    public HexapawnGUI() {
        setTitle("Hexapawn AI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        add(gamePanel);
        pack();
        setVisible(true);
    }
}
