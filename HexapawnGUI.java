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
    private ImageIcon whitePawnIcon = new ImageIcon("images\\hexapawn_white_pawn.png");
    private ImageIcon blackPawnIcon = new ImageIcon("images\\hexapawn_black_pawn.png");
    private boolean whiteTurn = true;
    private int whiteWins = 0;
    private int blackWins = 0;
    private int botIntelligence = 0;
    private JLabel whiteWinsLabel = new JLabel("Human Wins: " + whiteWins);
    private JLabel blackWinsLabel = new JLabel("AI Wins: " + blackWins);
    private JLabel botIntelligence = new JLabel("AI Intelligence Level: ");
    private Font myFont = new Font("Ariel", Font.PLAIN, 25);
    HexapawnAI AI = new HexapawnAI();

    public final static int EMPTY = 0;
    public final static int WHITE_PAWN = 1;
    public final static int BLACK_PAWN = 2;
    public final static int SELECTED = 10;

    public HexapawnGUI() {
        setTitle("Hexapawn AI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(blackPawnIcon.getImage());

        whiteWinsLabel.setBounds(165, 400, 300, 50);
        whiteWinsLabel.setFont(myFont);
        blackWinsLabel.setBounds(165, 425, 300, 50);
        blackWinsLabel.setFont(myFont);
        botIntelligenceLabel.setBounds(100, 35, 300, 50);
        botIntelligenceLabel.setFont(myFont);

        gamePanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        gamePanel.setLayout(null);
        initializeButtons();
        setBoard();
        gamePanel.add(whiteWinsLabel);
        gamePanel.add(blackWinsLabel);
        gamePanel.add(botIntelligenceLabel);

        add(gamePanel);
        pack();
        setVisible(true);
    }

    public void setBoard() {
        for(int i = 0; i < BOARD_LENGTH; ++i) {
            if(i >= 0 && i <= 2) {
                gameBoard[i] = BLACK_PAWN;
                buttonBoard[i].setIcon(blackPawnIcon);
            }
            else if(i >= 3 && i <= 5) {
                gameBoard[i] = EMPTY;
                buttonBoard[i].setIcon(null);
            }
            else {
                gameBoard[i] = WHITE_PAWN;
                buttonBoard[i].setIcon(whitePawnIcon);
            }
        }
    }

    public void initializeButtons() {
        for(int i = 0; i < BOARD_LENGTH; ++i) {
            buttonBoard[i] = new JButton();
            buttonBoard[i].addActionListener(this);
            buttonBoard[i].setBounds(((i*100) % 300) + 100, ((i/3)*100) + 100, 100, 100);
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

    public void printInfo() {
        for(int i = 0; i < BOARD_LENGTH; ++i) {
            System.out.print(gameBoard[i] + ", ");
            if(i == 2 || i == 5) { System.out.println(); }
            if(i == BOARD_LENGTH - 1) { System.out.println('\n'); }
        }
    }

    public boolean areTherePossibleMoves() {
        for(int i = 0; i < BOARD_LENGTH; ++i) {
            if(gameBoard[i] == WHITE_PAWN) {
                if(isLegalMove(i, i-2) || isLegalMove(i, i-3) || isLegalMove(i, i-4)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWin(int person) {
        if(person == WHITE_PAWN) {
            if(gameBoard[0] == WHITE_PAWN || gameBoard[1] == WHITE_PAWN || gameBoard[2] == WHITE_PAWN) {
                return true;
            }
        }
        else if(person == BLACK_PAWN) {
            if(gameBoard[6] == BLACK_PAWN || gameBoard[7] == BLACK_PAWN || gameBoard[8] == BLACK_PAWN) {
                return true;
            }
        }
        return false;
    }

    public void move(int from, int to) {
        if(whiteTurn) {
            if(isLegalMove(from, to)) {
                System.out.println("White's Move - From: " + from + " To: " + to);
                gameBoard[to] = WHITE_PAWN;
                buttonBoard[to].setIcon(whitePawnIcon);
                gameBoard[from] = EMPTY;
                buttonBoard[from].setIcon(null);
                // whiteTurn = false;
            }
            if(gameBoard[from] > 10) { gameBoard[from] -= SELECTED; }
            buttonBoard[from].setBackground(null);
        }
        else {
            
        }
        printInfo();
    }

    /*
     * returns the index of any piece that is selected
     * returns -1 if there are no pieces selected
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
