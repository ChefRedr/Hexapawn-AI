import java.util.HashMap;

public class HexapawnAI {
    private HashMap<Integer, Integer[]> boardConfigurations = new HashMap<Integer, Integer[]>();
<<<<<<< HEAD
    private HashMap<Integer[], HexapawnMove[]> aiMoveSet = new HashMap<Integer[], HexapawnMove[]>();
    public int from;
    public int to;

    // First two digits is the boardConfigurations key, last digit is the index of the move set
    public int lastMoveCode;

    public HexapawnAI() {
        createBoardConfigurations();
        createAIMoves();
    }
=======
>>>>>>> parent of 6bef4c2 (Added all AI moves)

    class HexapawnMove {
        int from = 0;
        int to = 0;
        public void setFrom(int from) { this.from = from; }
        public void setTo(int to) { this.to = to; }
<<<<<<< HEAD
        public void makeBadMove() { goodMove = false; }
        public void reverse() {
            if(from == 0 || from == 3 || from == 6) { from += 2; }
            if(from == 2 || from == 5 || from == 8) { from -= 2; }
            if(to == 0 || to == 3 || to == 6) { to += 2; }
            if(to == 2 || to == 5 || to == 8) { to -= 2; }
        }
    }

    private Integer[] fillArray(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        Integer[] arr = {arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9};
        return arr;
    }

    private void initializeMoveArray(HexapawnMove[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = new HexapawnMove();
        }
    }

    private void createBoardConfigurations() {
        Integer[] board = new Integer[9];

        // <---- Move 2 ---->
            board = fillArray(2, 2, 2, 1, 0, 0, 0, 1, 1);
            boardConfigurations.put(0, board);

            board = fillArray(2, 2, 2, 0, 1, 0, 1, 0, 1);
            boardConfigurations.put(1, board);
        
        // <---- Move 4 ---->
            board = fillArray(2, 0, 2, 1, 0, 0, 0, 0, 1);
            boardConfigurations.put(2, board);

            board = fillArray(2, 0, 2, 2, 1, 0, 0, 0, 1);
            boardConfigurations.put(3, board);

            board = fillArray(2, 0, 2, 2, 0, 1, 0, 1, 0);
            boardConfigurations.put(4, board);

            board = fillArray(2, 0, 2, 1, 1, 0, 0, 1, 0);
            boardConfigurations.put(5, board);

            board = fillArray(2, 2, 0, 1, 1, 2, 0, 0, 1);
            boardConfigurations.put(6, board);

            board = fillArray(2, 2, 0, 1, 0, 1, 0, 0, 1);
            boardConfigurations.put(7, board);

            board = fillArray(0, 2, 2, 1, 2, 0, 0, 0, 1);
            boardConfigurations.put(8, board);

            board = fillArray(0, 2, 2, 0, 1, 0, 0, 0, 1);
            boardConfigurations.put(9, board);

            board = fillArray(0, 2, 2, 0, 1, 0, 1, 0, 0);
            boardConfigurations.put(10, board);

            board = fillArray(0, 2, 2, 0, 2, 1, 1, 0, 0);
            boardConfigurations.put(11, board);

        // <---- Move 6 ---->
            board = fillArray(0, 0, 2, 2, 1, 0, 0, 0, 0);
            boardConfigurations.put(12, board);

            board = fillArray(0, 0, 2, 2, 2, 1, 0, 0, 0);
            boardConfigurations.put(13, board);

            board = fillArray(2, 0, 0, 2, 1, 0, 0, 0, 0);
            boardConfigurations.put(14, board);

            board = fillArray(2, 0, 0, 2, 2, 1, 0, 0, 0);
            boardConfigurations.put(15, board);

            board = fillArray(2, 0, 0, 1, 1, 1, 0, 0, 0);
            boardConfigurations.put(16, board);

            board = fillArray(0, 2, 0, 1, 1, 2, 0, 0, 0);
            boardConfigurations.put(17, board);

            board = fillArray(0, 2, 0, 0, 2, 1, 0, 0, 0);
            boardConfigurations.put(18, board);
    }

    private void createAIMoves() {
        // <---- Move 2 ---->
            HexapawnMove[] moveSet0 = new HexapawnMove[3];
            initializeMoveArray(moveSet0);
                moveSet0[0].setFrom(1); moveSet0[0].setTo(3);
                moveSet0[1].setFrom(1); moveSet0[1].setTo(4);
                moveSet0[2].setFrom(2); moveSet0[2].setTo(5);
            
            HexapawnMove[] moveSet1 = new HexapawnMove[2];
            initializeMoveArray(moveSet1);
                moveSet1[0].setFrom(0); moveSet1[0].setTo(3);
                moveSet1[1].setFrom(0); moveSet1[1].setTo(4);

        // <---- Move 4 ---->
            HexapawnMove[] moveSet2 = new HexapawnMove[1];
            initializeMoveArray(moveSet2);
                moveSet2[0].setFrom(2); moveSet2[0].setTo(5);
            
            HexapawnMove[] moveSet3 = new HexapawnMove[4];
            initializeMoveArray(moveSet3);
                moveSet3[0].setFrom(0); moveSet3[0].setTo(4);
                moveSet3[1].setFrom(2); moveSet3[1].setTo(4);
                moveSet3[2].setFrom(2); moveSet3[2].setTo(5);
                moveSet3[3].setFrom(3); moveSet3[3].setTo(6);
            
            HexapawnMove[] moveSet4 = new HexapawnMove[2];
            initializeMoveArray(moveSet4);
                moveSet4[0].setFrom(3); moveSet4[0].setTo(6);
                moveSet4[1].setFrom(3); moveSet4[1].setTo(7);
            
            HexapawnMove[] moveSet5 = new HexapawnMove[3];
            initializeMoveArray(moveSet5);
                moveSet5[0].setFrom(0); moveSet5[0].setTo(4);
                moveSet5[1].setFrom(2); moveSet5[1].setTo(4);
                moveSet5[2].setFrom(2); moveSet5[2].setTo(5);

            HexapawnMove[] moveSet6 = new HexapawnMove[2];
            initializeMoveArray(moveSet6);
                moveSet6[0].setFrom(0); moveSet6[0].setTo(4);
                moveSet6[1].setFrom(1); moveSet6[1].setTo(3);

            HexapawnMove[] moveSet7 = new HexapawnMove[3];
            initializeMoveArray(moveSet7);
                moveSet7[0].setFrom(1); moveSet7[0].setTo(3);
                moveSet7[1].setFrom(1); moveSet7[1].setTo(4);
                moveSet7[2].setFrom(1); moveSet7[2].setTo(5);

            HexapawnMove[] moveSet8 = new HexapawnMove[4];
            initializeMoveArray(moveSet8);
                moveSet8[0].setFrom(1); moveSet8[0].setTo(3);
                moveSet8[1].setFrom(2); moveSet8[1].setTo(5);
                moveSet8[2].setFrom(4); moveSet8[2].setTo(7);
                moveSet8[3].setFrom(4); moveSet8[3].setTo(8);

            HexapawnMove[] moveSet9 = new HexapawnMove[2];
            initializeMoveArray(moveSet9);
                moveSet9[0].setFrom(2); moveSet9[0].setTo(4);
                moveSet9[1].setFrom(2); moveSet9[1].setTo(5);

            HexapawnMove[] moveSet10 = new HexapawnMove[2];
            initializeMoveArray(moveSet10);
                moveSet10[0].setFrom(2); moveSet10[0].setTo(4);
                moveSet10[1].setFrom(2); moveSet10[1].setTo(5);

            HexapawnMove[] moveSet11 = new HexapawnMove[3];
            initializeMoveArray(moveSet11);
                moveSet11[0].setFrom(1); moveSet11[0].setTo(5);
                moveSet11[1].setFrom(4); moveSet11[1].setTo(6);
                moveSet11[2].setFrom(4); moveSet11[2].setTo(7);

        // <---- Move 6 ---->
            HexapawnMove[] moveSet12 = new HexapawnMove[3];
            initializeMoveArray(moveSet12);
                moveSet12[0].setFrom(2); moveSet12[0].setTo(4);
                moveSet12[1].setFrom(2); moveSet12[1].setTo(5);
                moveSet12[2].setFrom(3); moveSet12[2].setTo(6);

            HexapawnMove[] moveSet13 = new HexapawnMove[2];
            initializeMoveArray(moveSet13);
                moveSet13[0].setFrom(3); moveSet13[0].setTo(6);
                moveSet13[1].setFrom(4); moveSet13[1].setTo(7);
            
            HexapawnMove[] moveSet14 = new HexapawnMove[2];
            initializeMoveArray(moveSet14);
                moveSet14[0].setFrom(0); moveSet14[0].setTo(4);
                moveSet14[1].setFrom(3); moveSet14[1].setTo(6);
                
            HexapawnMove[] moveSet15 = new HexapawnMove[2];
            initializeMoveArray(moveSet15);
                moveSet15[0].setFrom(3); moveSet15[0].setTo(6);
                moveSet15[1].setFrom(4); moveSet15[1].setTo(7);

            HexapawnMove[] moveSet16 = new HexapawnMove[1];
            initializeMoveArray(moveSet16);
                moveSet16[0].setFrom(0); moveSet16[0].setTo(4);

            HexapawnMove[] moveSet17 = new HexapawnMove[2];
            initializeMoveArray(moveSet17);
                moveSet17[0].setFrom(1); moveSet17[0].setTo(3);
                moveSet17[1].setFrom(5); moveSet17[1].setTo(8);

            HexapawnMove[] moveSet18 = new HexapawnMove[2];
            initializeMoveArray(moveSet18);
                moveSet18[0].setFrom(1); moveSet18[0].setTo(5);
                moveSet18[1].setFrom(4); moveSet18[1].setTo(7);

        // <---- Adding to AI Moves Hash Map ---->
        aiMoveSet.put(boardConfigurations.get(0), moveSet0);
        aiMoveSet.put(boardConfigurations.get(1), moveSet1);
        aiMoveSet.put(boardConfigurations.get(2), moveSet2);
        aiMoveSet.put(boardConfigurations.get(3), moveSet3);
        aiMoveSet.put(boardConfigurations.get(4), moveSet4);
        aiMoveSet.put(boardConfigurations.get(5), moveSet5);
        aiMoveSet.put(boardConfigurations.get(6), moveSet6);
        aiMoveSet.put(boardConfigurations.get(7), moveSet7);
        aiMoveSet.put(boardConfigurations.get(8), moveSet8);
        aiMoveSet.put(boardConfigurations.get(9), moveSet9);
        aiMoveSet.put(boardConfigurations.get(10), moveSet10);
        aiMoveSet.put(boardConfigurations.get(11), moveSet11);
        aiMoveSet.put(boardConfigurations.get(12), moveSet12);
        aiMoveSet.put(boardConfigurations.get(13), moveSet13);
        aiMoveSet.put(boardConfigurations.get(14), moveSet14);
        aiMoveSet.put(boardConfigurations.get(15), moveSet15);
        aiMoveSet.put(boardConfigurations.get(16), moveSet16);
        aiMoveSet.put(boardConfigurations.get(17), moveSet17);
        aiMoveSet.put(boardConfigurations.get(18), moveSet18);
    }

    public void swap(int indexA, int indexB, Integer[] arr) {
        int temp = indexA;
        arr[indexA] = arr[indexB];
        arr[indexB] = arr[temp];
    }

    public Integer[] getReversedArray(Integer[] arr) {
        Integer[] dupArr = arr;
        swap(0, 2, dupArr);
        swap(3, 5, dupArr);
        swap(6, 8, dupArr);
        return dupArr;
    }

    public int getCorrectKey(int[] board) {
        int correctKey = 0;
        int correctness = 0;
        boolean reverse = false;
        int length = boardConfigurations.size();
        for(int i = 0; i < length * 2; ++i) {
            correctness = 0;
            correctKey = i;
            for(int j = 0; j < board.length; ++j) {
                if(i < length) {
                    if(board[j] == boardConfigurations.get(i)[j]) {
                        ++correctness;
                    }
                }
                else {
                    reverse = true;
                    if(board[j] == getReversedArray(boardConfigurations.get(i))[j]) {
                        ++correctness;
                    }
                }
            }
            if(correctness == board.length) {
                break;
            }
        }
        if(reverse) {
            return correctKey * 100;
        }
        return correctKey;
    }

    public boolean isLegalMove(int from, int to, int[] currentBoard) {
        if(to == from + 3) { //Check if piece is moving directly ahead
            if(currentBoard[to] == HexapawnGUI.EMPTY) { return true; }
        }
        else if((to == from + 2 && (from - 1) % 3 != 0 ) || to == from + 4) { //Check if piece is moving diagonally
            if(currentBoard[to] == HexapawnGUI.WHITE_PAWN) { return true; }
        }

        return false;
    }

    public boolean areTherePossibleMoves(int[] currentBoard) {
        for(int i = 0; i < currentBoard.length; ++i) {
            if(currentBoard[i] == HexapawnGUI.BLACK_PAWN) {
                if(isLegalMove(i, i+2, currentBoard) || isLegalMove(i, i+3, currentBoard) || isLegalMove(i, i+4, currentBoard)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createMove(int[] currentBoard) {
        if(areTherePossibleMoves(currentBoard)) {
            HexapawnMove[] moveSet = aiMoveSet.get(boardConfigurations.get(getCorrectKey(currentBoard)%100));
            HexapawnMove move = moveSet[(int) (Math.random() * moveSet.length)];
            int randomNumber = 0;
            do {
                randomNumber = (int) (Math.random() * moveSet.length);
                move = moveSet[randomNumber];
            } while(!move.goodMove);
            lastMoveCode = (getCorrectKey(currentBoard) * 10) + randomNumber;
            if(getCorrectKey(currentBoard) % 100 == 1) {
                move.reverse();
            }
            from = move.from;
            to = move.to;
        }
        else {
            to = -1;
        }
    }

    public void removeLastMove() {
        int key = lastMoveCode / 10;
        int index = lastMoveCode % 10;
        aiMoveSet.get(boardConfigurations.get(key))[index].makeBadMove();
    }

=======
    }
>>>>>>> parent of 6bef4c2 (Added all AI moves)
}
