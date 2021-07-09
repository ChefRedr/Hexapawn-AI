import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

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
    private boolean whiteTurn = true;
    private int whiteWins = 0;
    private int blackWins = 0;
    private JLabel whiteWinsLabel = new JLabel("Human Wins: " + whiteWins);
    private JLabel blackWinsLabel = new JLabel("AI Wins: " + blackWins);
    private JLabel botIntelligence = new JLabel("Bot Intelligence Level: ");
    private JLabel[] boardCoordinates = new JLabel[6];
    Font myFont = new Font("Ariel", Font.PLAIN, 25);

    private final static int EMPTY = 0;
    private final static int WHITE_PAWN = 1;
    private final static int BLACK_PAWN = 2;
    private final static int SELECTED = 10;

    public HexapawnGUI() {
        setTitle("Hexapawn AI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(blackPawnIcon.getImage());

        whiteWinsLabel.setBounds(165, 400, 300, 50);
        whiteWinsLabel.setFont(myFont);
        blackWinsLabel.setBounds(165, 425, 300, 50);
        blackWinsLabel.setFont(myFont);
        botIntelligence.setBounds(100, 35, 300, 50);
        botIntelligence.setFont(myFont);

        gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        gamePanel.setLayout(null);
        initializeBoard();
        gamePanel.add(whiteWinsLabel);
        gamePanel.add(blackWinsLabel);
        gamePanel.add(botIntelligence);

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

    public boolean isLegalMove(int from, int to) {
        if(to == from - 3) { //Check if piece is moving directly ahead
            if(gameBoard[to] == EMPTY) { return true; }
        }
        else if((to == from - 2 && (from + 1) % 3 != 0 ) || to == from - 4) { //Check if piece is moving diagonally
            if(gameBoard[to] == BLACK_PAWN) { return true; }
        }

        return false;
    }

    public void move(int from, int to) {
        if(whiteTurn) {
            if(isLegalMove(from, to)) {
                
            }
            else {
                
            }
        }
    }

    /*
     * Will return the index of any piece that is selected
     * Will return -1 if there are no pieces selected
    */
    public int findSelectedIndex() {
        for(int i = 0; i < BOARD_LENGTH; ++i) {
            if(gameBoard[i] / SELECTED == 1) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(whiteTurn) {
            for(int i = 0; i < BOARD_LENGTH; ++i) {
                if(e.getSource() == buttonBoard[i]) {
                    if(findSelectedIndex() == -1 && gameBoard[i] == WHITE_PAWN) {
                        gameBoard[i] += SELECTED;
                        buttonBoard[i].setBackground(Color.GREEN);
                    }
                    else if(findSelectedIndex() != -1) {
                        move(findSelectedIndex(), i);
                    }
                }
            }
        }
    }
}
