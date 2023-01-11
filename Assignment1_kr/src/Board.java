public class Board {
    private Piece[][] board = new Piece[8][8];

    /**
     * Board Class
     */
    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Piece("", "", new int[]{-1, -1});
            }
        }
    }

    /**
     * adding position of pieces
     * @param piece
     */
    public void Add(Piece piece) {
        int xpos = piece.getPosition()[0];
        int ypos = piece.getPosition()[1];
        if (xpos < 9 && board[xpos][ypos].getPosition()[0] == -1 && ypos < 9) {
            board[xpos][ypos] = piece;
        } else {
            System.out.println("failed add");
        }
    }

    /**
     * printing the Display on "print" command
     */
    public void Display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].toString().equals("")) {
                    System.out.printf( " - ");

                } else {
                    System.out.printf( board[i][j].toString());
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    /**
     * Instance Variables
     * @param xpos
     * @param ypos
     * @param direction
     * @param n
     */
    public void move(int xpos, int ypos, String direction, int n) {
        if (board[xpos][ypos].getPosition()[0] != -1) {
            /**
             * || refers to OR gate
             */
            if (direction.equals("right") || direction.equals("left")) {
                movePiece(xpos, ypos, direction, n);
                /**
                 * direction of movement
                 */
            } else if (direction.equals("down") || direction.equals("up")) {
                moveFlexible(xpos, ypos, direction, n);
            }
            /**
             * position on the board
             * And error statement
             */
            board[board[xpos][ypos].getPosition()[0]][board[xpos][ypos].getPosition()[1]] =
                    board[xpos][ypos];
            board[xpos][ypos] = new Piece("", "", new int[]{-1, -1});
        } else {
            System.out.println("Error, no piece at " + xpos + ", " + ypos);
        }
    }

    /**
     * class for movePiece and moveFlexible
     * @param xpos
     * @param ypos
     * @param direction
     * @param n
     */
    public void movePiece(int xpos, int ypos, String direction, int n) {
        if (n > 1) {
            ((FastPiece) board[xpos][ypos]).move(direction, n);
        } else {
            ((SlowPiece) board[xpos][ypos]).move(direction);
        }
    }

    public void moveFlexible(int xpos, int ypos, String direction, int n) {
        if (n > 1) {
            ((FastFlexible) board[xpos][ypos]).move(direction, n);
        } else {
            ((SlowFlexible) board[xpos][ypos]).move(direction);
        }
    }
}
