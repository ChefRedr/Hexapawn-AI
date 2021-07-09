import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HexapawnGUI extends JFrame implements ActionListener {
    
    private JPanel gamePanel = new JPanel();
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;
    private final int BOARD_LENGTH = 9;
    private int[] gameBoard = new int[BOARD_LENGTH];
    private JButton[] buttonBoard = new JButton[BOARD_LENGTH];
    ImageIcon whitePawnIcon = new ImageIcon("images\\hexapawn_white_pawn.png");
    ImageIcon blackPawnIcon = new ImageIcon("images\\hexapawn_black_pawn.png");
    private boolean whiteMove = true;

    private final static int EMPTY = 0;
    private final static int WHITE_PAWN = 1;
    private final static int BLACK_PAWN = 2;
    private final static int SELECTED = 10;

    public HexapawnGUI() {
        setTitle("Hexapawn AI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(blackPawnIcon.getImage());

        gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        gamePanel.setLayout(null);
        initializeBoard();

        add(gamePanel);
        pack();
        setVisible(true);
    }

    public void initializeBoard() {
        for(int i = 0; i < BOARD_LENGTH; ++i) {
            buttonBoard[i] = new JButton();
            buttonBoard[i].addActionListener(this);
            buttonBoard[i].setBounds(((i*100) % 300) + 100, ((i/3)*100) + 100, 100, 100);
            if(i >= 0 && i <= 2) {
                gameBoard[i] = BLACK_PAWN;
                buttonBoard[i].setIcon(blackPawnIcon);
            }
            else if(i >= 3 && i <= 5) {
                gameBoard[i] = EMPTY;
            }
            else {
                gameBoard[i] = WHITE_PAWN;
                buttonBoard[i].setIcon(whitePawnIcon);
            }
            gamePanel.add(buttonBoard[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
