/**
 * Inheritance Implementation
 */
public class FastPiece extends Piece {
    /**
     * Instance Variables
     * @param name
     * @param colour
     * @param position
     */
    public FastPiece(String name, String colour, int[] position) {
        super(name, colour, position);
    }

    /**
     * this method moves left and right by "n" spaces directly
     * @param direction
     * @param n
     */
    public void move(String direction, int n) {
        if (direction.equals("left")) {
            moveLeft(n);
        } else if (direction.equals("right")) {
            moveRight(n);
        } else {
            System.out.println("illegal command");
        }
    }

    /**
     * for left movement including white spaces
     * @param n
     */
    public void moveLeft(int n) {
        if (super.getPosition()[1] - n >= 0) {
            int[] array = super.getPosition();
            array[1] -= n;
            super.setPosition(array);
        }
    }

    /**
     * for right movement including white spaces
     * @param n
     */
    public void moveRight(int n) {
        if (super.getPosition()[1] + n <= 8) {
            int[] array = super.getPosition();
            array[1] += n;
            super.setPosition(array);
        }
    }

    /**
     * toString() Method
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "F";
    }
}
