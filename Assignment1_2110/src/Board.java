public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Piece("", "", new int[]{-1, -1});
            }
        }
    }

    public void Add(Piece piece) {
        int xpos = piece.getPosition()[0];
        int ypos = piece.getPosition()[1];
        if (xpos < 9 && board[xpos][ypos].getPosition()[0] == -1 && ypos < 9) {
            board[xpos][ypos] = piece;
        } else System.out.println("failed add");
    }

    public void Display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].toString().equals("")) {
                    System.out.printf("%-20s", " - ");

                } else System.out.printf("%-20s", board[i][j].toString());
                System.out.print("\t");
            }
            System.out.println();
        }

    }

    public void move(int xpos, int ypos, String direction, int n){
        if ( board[xpos][ypos].getPosition()[0] != -1){
            if (direction.equals("right") || direction.equals("left")){
                if(n>1){
                    ((FastPiece) board [xpos][ypos]).move(direction, n);
                }
                else ((SlowPiece) board [xpos][ypos]).move(direction);
            }
            else if(direction.equals("down") || direction.equals("up")){
                if(n>1){
                    ((FastFlexible) board [xpos][ypos]).move(direction, n);
                }
                else ((SlowFlexible) board [xpos][ypos]).move(direction);

            }
            int array_x = board[xpos][ypos].getPosition()[0];
            int array_y = board[xpos][ypos].getPosition()[1];
            board[array_x][array_y]=board[xpos][ypos];
            board[xpos][ypos] = new Piece("","",new int[]{-1,-1});
        }
        else System.out.println("Error, no piece at " + xpos + ", " + ypos);
    }
}